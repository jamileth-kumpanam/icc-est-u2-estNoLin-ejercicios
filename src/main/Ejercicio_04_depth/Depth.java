package main.Ejercicio_04_depth;

public class Depth {

    public static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        Node root = new Node(50); //NUEVA RAÍZ
        root.left = new Node(30);
        root.right = new Node(70);
        root.left.left = new Node(20);
        root.left.right = new Node(40);
        root.left.left.left = new Node(10); //NODO MÁS PROFUNDO

        Depth d = new Depth();
        int profundidad = d.maxDepth(root);

        System.out.println("Profundidad máxima del árbol: " + profundidad);
    }
}