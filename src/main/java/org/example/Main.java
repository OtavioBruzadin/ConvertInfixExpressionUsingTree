package org.example;


public class Main {
    public static void main(String[] args) {

            String expression = "(45+20) * 2 - 15";
            ExpressionTree tree;
            tree = new ExpressionTree();
            tree.createExpressionTree(expression);
            tree.printInOrder();
            tree.printPostOrder();

        tree.printPreOrder();
        tree.evaluate();
    }
}