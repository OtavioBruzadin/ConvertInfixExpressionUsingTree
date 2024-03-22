package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionTree {
    Node root;

    // Constructor
    public ExpressionTree() {
        root = null;
    }

    //Constroi uma  arvore de expressao a partir de uma expressao infixa
    public void createExpressionTree(String expression) {
        Stack<Node> stack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Se o item atual for um operador adicionamos a stack
            if (Character.isDigit(c)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i++));
                }
                i--;
                stack.push(new Node(sb.toString()));
            }
            // se o operator for ( adicionamos a stack
            else if (c == '(')
                operatorStack.push(c);

                // Se o token atual for um ) o os operadores serão removidos da pilha até que a chave de ( seja encontrada
            else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(')
                    stack.push(popOperator(operatorStack.pop(), stack.pop(), stack.pop()));
                operatorStack.pop();
            }
            // se um item atual for um operador
            else {
                while (!operatorStack.isEmpty() && operatorHierarchy(c) <= operatorHierarchy(operatorStack.peek()))
                    stack.push(popOperator(operatorStack.pop(), stack.pop(), stack.pop()));
                operatorStack.push(c);
            }
        }

        // Retirar os operadores restantes da pilha e construir a arvore de expressao
        while (!operatorStack.isEmpty())
            stack.push(popOperator(operatorStack.pop(), stack.pop(), stack.pop()));

        // coloca a raiz da expressao no topo da stack
        root = stack.pop();
    }

    // remove um operador e dois operandos para construir um no
    private Node popOperator(char operator, Node right, Node left) {
        Node node = new Node(Character.toString(operator));
        node.setRightSon(right);
        node.setLeftSon(left);
        return node;
    }

    // metodo utilizado para definir a hierarquia dos operadores
    private int operatorHierarchy(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    private static double convertToDouble(String s) {
        return Double.parseDouble(s);
    }
    public static float evaluateExpressionTree(Node root) {
        if (root == null)
            return 0;

        if (root.getLeftSon() == null && root.getRightSon() == null)
            return root.visitar();

        float leftEvaluation = evaluateExpressionTree(root.getLeftSon());
        float rightEvaluation = evaluateExpressionTree(root.getRightSon());

        switch (root.getValue()) {
            case "+":
                return leftEvaluation + rightEvaluation;
            case "-":
                return leftEvaluation - rightEvaluation;
            case "*":
                return leftEvaluation * rightEvaluation;
            case "^":
                return (float) Math.pow(leftEvaluation, rightEvaluation);
            case "/":
                return leftEvaluation / rightEvaluation;
            default:
                return 0;
        }
    }
    private boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("^");
    }
    // Method to traverse and print the expression tree in infix order
    private void printInOrder(Node node) {
        if (node != null) {
            if (isOperator(node.getValue()))
                System.out.print("(");
            printInOrder(node.getLeftSon());
            System.out.print(node.getValue());
            printInOrder(node.getRightSon());
            if (isOperator(node.getValue()))
                System.out.print(")");
        }
    }
    public  String postOrder(Node currentNode, String resultString) {
        if(currentNode == null)
        {
            return resultString;
        }
        //Go through left
        resultString = postOrder(currentNode.getLeftSon(), resultString);
        //Go through right
        resultString = postOrder(currentNode.getRightSon(), resultString);
        resultString = resultString + currentNode.getValue() + " ";
        return resultString;
    }

    public static  String preOrder(Node currentNode, String resultString) {
        if(currentNode == null)
        {
            return resultString; // preserve previously calculated value
        }
        resultString = resultString + currentNode.getValue() + " ";
        //Go through left
        resultString = preOrder(currentNode.getLeftSon(), resultString);
        //Go through right
        resultString = preOrder(currentNode.getRightSon(), resultString);

        return resultString;
    }


    public void printInOrder() {
        System.out.println("\nExpressao infixa da arvore de expressao: ");
        printInOrder(root);

    }
    public void printPostOrder(){
        System.out.println("\nExpressao posfixa da arvore de expressao: \n"+postOrder(root,""));
    }
    public void  printPreOrder(){
        System.out.println("Expressao prefixa da arvore de expressao: \n"+ preOrder(root,""));

    }
    public void evaluate(){
        System.out.println("O resultado da equação é : "+ evaluateExpressionTree(root));
    }
}