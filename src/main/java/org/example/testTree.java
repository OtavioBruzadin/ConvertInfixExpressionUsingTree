package org.example;

import java.util.Stack;

public class testTree {


    // Node class representing a node in the expression tree


    // Main ExpressionTree class
    public static class ExpressionTree {
        Node root;

        // Constructor
        public ExpressionTree() {
            root = null;
        }

        // Method to construct expression tree from infix expression
        public void constructTree(String expression) {
            Stack<Node> stack = new Stack<>();
            Stack<Character> operatorStack = new Stack<>();

            for (int i = 0; i < expression.length(); i++) {
                char c = expression.charAt(i);

                // Skip whitespaces
                if (c == ' ')
                    continue;

                // If current token is an operand, push it to stack
                if (Character.isDigit(c)) {
                    StringBuilder sb = new StringBuilder();
                    while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                        sb.append(expression.charAt(i++));
                    }
                    i--;
                    stack.push(new Node(sb.toString()));
                }
                // If current token is an opening brace, push it to operator stack
                else if (c == '(')
                    operatorStack.push(c);

                    // If current token is a closing brace, pop operators from stack until matching opening brace is encountered
                else if (c == ')') {
                    while (!operatorStack.isEmpty() && operatorStack.peek() != '(')
                        stack.push(popOperator(operatorStack.pop(), stack.pop(), stack.pop()));
                    operatorStack.pop();
                }
                // If current token is an operator
                else {
                    while (!operatorStack.isEmpty() && precedence(c) <= precedence(operatorStack.peek()))
                        stack.push(popOperator(operatorStack.pop(), stack.pop(), stack.pop()));
                    operatorStack.push(c);
                }
            }

            // Pop remaining operators from operator stack and construct expression tree
            while (!operatorStack.isEmpty())
                stack.push(popOperator(operatorStack.pop(), stack.pop(), stack.pop()));

            // Root of expression tree is now at the top of stack
            root = stack.pop();
        }

        // Utility method to pop an operator and two operands from stack and construct a node
        private Node popOperator(char operator, Node right, Node left) {
            Node node = new Node(Character.toString(operator));
            node.setRightSon(right);
            node.setLeftSon(left);
            return node;
        }

        // Utility method to get precedence of operators
        private int precedence(char operator) {
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

        private static int toInt(String s)
        {
            int num = 0;

            // Check if the integral value is
            // negative or not
            // If it is not negative, generate
            // the number normally
            if (s.charAt(0) != '-')
                for(int i = 0; i < s.length(); i++)
                    num = num * 10 + ((int)s.charAt(i) - 48);

                // If it is negative, calculate the +ve number
                // first ignoring the sign and invert the
                // sign at the end
            else
            {
                for(int i = 1; i < s.length(); i++)
                    num = num * 10 + ((int)(s.charAt(i)) - 48);
                num = num * -1;
            }
            return num;
        }

        // This function receives a node of the syntax
// tree and recursively evaluate it
        public static int evalTree(Node root) {

            // Empty tree
            if (root == null)
                return 0;

            // Leaf node i.e, an integer
            if (root.getLeftSon() == null && root.getRightSon() == null)
                return toInt(root.getValue());

            // Evaluate left subtree
            int leftEval = evalTree(root.getLeftSon());

            // Evaluate right subtree
            int rightEval = evalTree(root.getRightSon());

            // Check which operator to apply
            if (root.getValue().equals("+"))
                return leftEval + rightEval;

            if (root.getValue().equals("-"))
                return leftEval - rightEval;

            if (root.getValue().equals("*"))
                return leftEval * rightEval;

            if (root.getValue().equals("^"))
                return (int) Math.pow(leftEval,rightEval);

            if (root.getValue().equals("/"))
                return leftEval / rightEval;

            return leftEval / rightEval;
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

        // Method to check if a given string is an operator
        private boolean isOperator(String str) {
            return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("^");
        }

        // Method to traverse and print the expression tree in infix order (wrapper method)
        public void printInOrder() {
            printInOrder(root);
        }
        public void printPostOrder(){
            System.out.println(postOrder(root,""));
        }
        public void  printPreOrder(){
            System.out.println(preOrder(root,""));
        }
        public void evaluate(){
            System.out.println(evalTree(root));
        }
    }
}
