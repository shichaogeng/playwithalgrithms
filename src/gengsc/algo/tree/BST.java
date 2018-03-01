package gengsc.algo.tree;

import gengsc.algo.util.FileOperations;

import java.awt.font.TextHitInfo;
import java.awt.geom.RoundRectangle2D;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-02-26 22:54
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;
    private int count;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int count() {
        return this.count;
    }

    public void insert(Key key, Value value) {
        this.root = insert(this.root, key, value);
    }

    public boolean contain(Key key) {
        return contain(root, key);
    }

    public Value search(Key key) {
        return search(root, key);
    }

    public void preOrder() {
        preOrder(root);
    }

    public void inOrder() {
        inOrder(root);
    }

    public void postOrder() {
        postOrder(root);
    }

    public void levelOrder() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.println(node.key);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    public Key minimum() {
        return minimum(root).key;
    }

    public Key maximum() {
        return maximum(root).key;
    }

    public void removeMin() {
        this.root = removeMin(root);
    }

    public void removeMax() {
        this.root = removeMax(root);
    }

    public void remove(Key key) {
        root=remove(root, key);
    }

    private Node remove(Node node, Key key) {
        if (node == null) return null;

        if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else {
            if (node.left == null) {
                Node rightNode = node.right;
                node = null;
                count--;
                return rightNode;
            } else if (node.right == null) {
                Node leftNode = node.left;
                node = null;
                count--;
                return leftNode;
            } else {
                Node leftNode = node.left;
                Node rigtNode = node.right;
                node = null;
                Node successor = minimum(rigtNode);
                rigtNode = removeMin(rigtNode);
                successor.right = rigtNode;
                successor.left = leftNode;
                return successor;
            }
        }

    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node = null;
            count--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node = null;
            count--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node maximum(Node node) {
        if (node.right  == null) return node;
        return maximum(node.right);
    }

    private Node minimum(Node node) {
        if (node.left == null) return node;
        return minimum(node.left);
    }

    private void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.key);
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.key);
        inOrder(node.right);
    }

    private void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }

    private Value search(Node node, Key key) {
        if (node == null) return null;
        if (key.compareTo(node.key) > 0) {
            return search(node.right, key);
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return node.value;
        }

    }

    private boolean contain(Node node, Key key) {
        if (node == null) return false;
        if (key.compareTo(node.key) > 0) {
            return contain(node.right, key);
        } else if (key.compareTo(node.key) < 0) {
            return contain(node.left, key);
        } else {
            return true;
        }
    }

    private Node insert(Node node, Key key, Value value) {
        if (node == null) {
            this.count++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) > 0) {
            node.right = insert(node.right, key, value);
        } else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.value = value;
        }

        return node;
    }

    // 测试二分搜索树和顺序查找表之间的性能差距
    // 二分搜索树的性能远远优于顺序查找表
    public static void main(String[] args) {

        // 使用圣经作为我们的测试用例
        String filename = "bible.txt";
        Vector<String> words = new Vector<String>();
        if(FileOperations.readFile(filename, words)){
            System.out.println( "There are totally " + words.size() + " words in " + filename );
            System.out.println();

            // 测试 BST
            long startTime = System.currentTimeMillis();

            // 统计圣经中所有词的词频
            // 注: 这个词频统计法相对简陋, 没有考虑很多文本处理中的特殊问题
            // 在这里只做性能测试用
            BST<String, Integer> bst = new BST<String, Integer>();
            for (String word: words) {
                Integer res = bst.search(word);
                if (res == null)
                    bst.insert(word, new Integer(1));
                else
                    bst.insert(word, res + 1);
            }

            // 输出圣经中god一词出现的频率
            if( bst.contain("god") )
                System.out.println("'god' : " + bst.search("god") );
            else
                System.out.println("No word 'god' in " + filename);

            long endTime = System.currentTimeMillis();
            System.out.println("BST , time: " + (endTime - startTime) + "ms.");

            System.out.println();


            // 测试顺序查找表 SST
            startTime = System.currentTimeMillis();

            // 统计圣经中所有词的词频
            // 注: 这个词频统计法相对简陋, 没有考虑很多文本处理中的特殊问题
            // 在这里只做性能测试用
            SST<String, Integer> sst = new SST<String, Integer>();
            for (String word: words) {
                Integer res = sst.search(word);
                if (res == null)
                    sst.insert(word, new Integer(1));
                else
                    sst.insert(word, res + 1);
            }

            // 输出圣经中god一词出现的频率
            if( sst.contain("god") )
                System.out.println("'god' : " + sst.search("god") );
            else
                System.out.println("No word 'god' in " + filename);

            endTime = System.currentTimeMillis();
            System.out.println("SST , time: " + (endTime - startTime) + "ms.");

        }
    }
}
