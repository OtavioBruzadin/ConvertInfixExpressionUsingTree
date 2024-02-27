package org.example;


import static org.example.Tree.*;

public class Main {
    public static void main(String[] args) {

//        String postfix = "ABC*+D/";
//
//        CharNode r = expressionTree(postfix);
//        inOrder(r);
//        System.out.println("\n");
//        preOrder(r);
        // Para o codigo dentro de ExpressionTree
        String s = "((A+B)*C)^D"; // nao funciona com numeros tem que ser letra ai depois usa o trabalho do semestre passado pra resolver a equacao
        s = "(" + s;
        s += ")";
        Node root = build(s);

        // Function call
        postorder(root);
        System.out.println("\n");
        preOrder(root);
    }
}