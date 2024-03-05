package org.example;


public class Main {
    public static void main(String[] args) {

            String expression = "0.5*3/0.25";
            ExpressionTree tree;
            tree = new ExpressionTree();
            tree.createExpressionTree(expression);
            tree.printInOrder();
            tree.printPostOrder();

        tree.printPreOrder();
        tree.evaluate();
    }
}