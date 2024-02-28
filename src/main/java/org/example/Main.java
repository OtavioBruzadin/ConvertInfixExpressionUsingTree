package org.example;


import java.util.Arrays;

import static org.example.Convertions.*;
import static org.example.Tree.*;

public class Main {
    public static void main(String[] args) {
        String[] variables = new String[0];
        String[] variableValues = new String[0];

//        String postfix = "ABC*+D/";
//
//        CharNode r = expressionTree(postfix);
//        inOrder(r);
//        System.out.println("\n");
//        preOrder(r);
// Para o codigo dentro de ExpressionTree

        String infixExpression = "((A+B)*C)^D";
        variables = createVariableArray(infixExpression);
        System.out.println(Arrays.toString(variables)+"\n");

        variableValues = assignValuesToLetterVariable(variables);
        String infixWithNumbers = changeLetterToNum(variableValues, infixExpression, variables);
        System.out.println("A expressao Infixa com numeros é: " + infixWithNumbers);
        infixExpression = "(" + infixExpression;
        infixExpression += ")";
        Node expressionTreeRoot = buildExpressionTree(infixExpression);

        // Function call

        System.out.println("\nA versao posfixa é: " + postOrder(expressionTreeRoot,"") );
        String PostFixWithNumbers = changeLetterToNum(variableValues,postOrder(expressionTreeRoot,"")  , variables);
        System.out.println("\nA versao posfixa com numeros é: " + PostFixWithNumbers);
        System.out.println("\n");
        System.out.println("\nA versao prefixa é: " + preOrder(expressionTreeRoot,"") );
        String PreFixWithNumbers = changeLetterToNum(variableValues,preOrder(expressionTreeRoot,"")  , variables);
        System.out.println("\nA versao prefixa com numeros é: " + PreFixWithNumbers);

    }
}