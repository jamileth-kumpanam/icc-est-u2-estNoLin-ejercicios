package main.Ejercicio_01_insert;

import java.util.LinkedList;
import java.util.Queue;

public class InsertBSTTest {

    public static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public Node insert(Node root, int value) {
        if (root == null) return new Node(value);

        if (value < root.val) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    public static void printLevelOrder(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nivel = queue.size();
            for (int i = 0; i < nivel; i++) {
                Node current = queue.poll();
                System.out.print(current.val + " ");
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        InsertBSTTest tree = new InsertBSTTest();
        int[] valores = {10, 5, 15, 3, 7, 12, 18}; // NUEVOS VALORES
        Node root = null;

        for (int v : valores) {
            root = tree.insert(root, v);
        }

        System.out.println("Árbol BST insertado por niveles:");
        printLevelOrder(root);
    }
}