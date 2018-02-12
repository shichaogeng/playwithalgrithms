package gengsc.algo.tree;

import gengsc.algo.util.FileOperations;

import java.util.Vector;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-02-08 9:50
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

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(Key key, Value value) {
        //如果有就替换
        //没有就插入
        this.root = insert(this.root, key, value);
    }

    private Node insert(Node node, Key key, Value value) {

        if (node == null) {
            this.count++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) == 0) {
            node.value = value;
        } else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        } else {
            node.right = insert(node.right, key, value);
        }
        return node;
    }

    public boolean contain(Key key) {
        return contain(this.root, key);
    }

    private boolean contain(Node node, Key key) {

        if (node == null) {
            return false;
        }

        if (key.compareTo(node.key) == 0) {
            return true;
        } else if (key.compareTo(node.key) < 0) {
            return contain(node.left, key);
        } else {
            return contain(node.right, key);
        }
    }

    public Value search(Key key) {
        return search(this.root, key);
    }

    private Value search(Node node, Key key) {

        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }

    }

    public void preOrder() {
        preOrder(this.root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.key);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(this.root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.key);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(this.root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.key);
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
