package org.example;

public class Main {
    public static void main(String[] args) {

        Tree<Integer> tree = new Tree<Integer>();

        tree.add(4);
        tree.add(6);
        tree.add(8);
        tree.add(3);
        tree.add(9);
        tree.add(12);
        tree.add(10);
        tree.add(1);
        tree.add(0);
        tree.add(7);
        tree.add(5);

        System.out.println("Current root: " + tree.getValue(tree.getRoot()) + "/" + tree.getColor(tree.getRoot()));
        System.out.println(tree.treeToString(tree.getRoot()));
    }
}