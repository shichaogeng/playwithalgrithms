package gengsc.algo.tree;

import java.awt.font.TextHitInfo;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author shichaogeng
 * @Create 2018-02-26 22:54
 */
public class BST2<Key extends Comparable<Key>, Value> {

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
}
