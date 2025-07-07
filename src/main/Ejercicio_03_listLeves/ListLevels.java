package main.Ejercicio_03_listLeves;

import java.util.*;

public class ListLevels {

    public static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public List<List<Node>> listLevels(Node root) {
        List<List<Node>> resultado = new ArrayList<>();
        if (root == null) return resultado;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nivel = queue.size();
            List<Node> listaNivel = new ArrayList<>();

            for (int i = 0; i < nivel; i++) {
                Node nodo = queue.poll();
                listaNivel.add(nodo);
                if (nodo.left != null) queue.add(nodo.left);
                if (nodo.right != null) queue.add(nodo.right);
            }

            resultado.add(listaNivel);
        }

        return resultado;
    }

    public static void main(String[] args) {
        Node root = new Node(20); // NUEVA RAÍZ
        root.left = new Node(10);
        root.right = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(15);
        root.right.left = new Node(25);
        root.right.right = new Node(35);

        ListLevels ll = new ListLevels();
        List<List<Node>> niveles = ll.listLevels(root);

        System.out.println("Niveles del árbol como listas:");
        for (List<Node> nivel : niveles) {
            for (Node nodo : nivel) {
                System.out.print(nodo.val + " → ");
            }
            System.out.println("null");
        }
    }
}