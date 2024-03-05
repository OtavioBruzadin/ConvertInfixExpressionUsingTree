package org.example;


public class Main {
    public static void main(String[] args) {
//        String[] variables = new String[0];
//        String[] variableValues = new String[0];
//
////        String postfix = "ABC*+D/";
////
////        CharNode r = expressionTree(postfix);
////        inOrder(r);
////        System.out.println("\n");
////        preOrder(r);
//// Para o codigo dentro de ExpressionTree que transforma postfix em infixa
//
//        String infixExpression = "((10+20)*30)^40";
//        variables = createVariableArray(infixExpression);
//        System.out.println(Arrays.toString(variables)+"\n");
//
//        variableValues = assignValuesToLetterVariable(variables);
//        String infixWithNumbers = changeLetterToNum(variableValues, infixExpression, variables);
//        System.out.println("A expressao Infixa com numeros é: " + infixWithNumbers);
//        infixExpression = "(" + infixExpression;
//        infixExpression += ")";
//        Node expressionTreeRoot = buildExpressionTree(infixExpression);
//
//        // Function call
//
//        System.out.println("\nA versao posfixa é: " + postOrder(expressionTreeRoot,"") );
//        String PostFixWithNumbers = changeLetterToNum(variableValues,postOrder(expressionTreeRoot,"")  , variables);
//        System.out.println("\nA versao posfixa com numeros é: " + PostFixWithNumbers);
//        System.out.println("\n");
//        System.out.println("\nA versao prefixa é: " + preOrder(expressionTreeRoot,"") );
//        String PreFixWithNumbers = changeLetterToNum(variableValues,preOrder(expressionTreeRoot,"")  , variables);
//        System.out.println("\nA versao prefixa com numeros é: " + PreFixWithNumbers);


            String expression = "(9/3)";
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