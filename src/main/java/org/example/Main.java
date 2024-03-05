package org.example;


public class Main {
    public static void main(String[] args) {

            String expression = "((0.5+0.5)*5)^4";
            testTree.ExpressionTree tree;
            tree = new testTree.ExpressionTree();
            tree.constructTree(expression);
            System.out.println("Infix expression from constructed tree:" );
            tree.printInOrder();
            System.out.println("\nPostfix expression from constructed tree:" );

            tree.printPostOrder();

        System.out.println("\nPrefix expression from constructed tree:" );
        tree.printPreOrder();
        tree.evaluate();
    }
}