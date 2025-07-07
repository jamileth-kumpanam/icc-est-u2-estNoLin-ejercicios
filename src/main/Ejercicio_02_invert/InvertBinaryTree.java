package main.Ejercicio_02_invert;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public Node invertTree(Node root) {
        if (root == null) return null;

        Node temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

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
        Node root = new Node(8); // NUEVA RAÍZ
        root.left = new Node(4);
        root.right = new Node(10);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.left = new Node(9);
        root.right.right = new Node(12);

        InvertBinaryTree ibt = new InvertBinaryTree();
        Node invertido = ibt.invertTree(root);

        System.out.println("Árbol invertido por niveles:");
        printLevelOrder(invertido);
    }
}