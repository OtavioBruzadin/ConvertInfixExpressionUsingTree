package org.example;

import java.util.Stack;

public class Tree {
    static Node newNode(char c){
        Node node = new Node(c);
        return node;
    }

    // Function to build Expression Tree
    static Node buildExpressionTree(String expression) {

        // Stack to hold nodes
        Stack<Node> nodeStack = new Stack<>();

        // Stack to hold chars
        Stack<Character> characterStack = new Stack<>();
        Node t, t1, t2;

        // Prioritising the operators
        int []priorityRank = new int[123];
        priorityRank['+'] = priorityRank['-'] = 1;
        priorityRank['/'] = priorityRank['*'] = 2;
        priorityRank['^'] = 3;
        priorityRank[')'] = 0;

        for (int i = 0; i < expression.length(); i++)
        {
            if (expression.charAt(i) == '(') {

                // Push '(' in char stack
                characterStack.add(expression.charAt(i));
            }

            // Push the operands in node stack
            else if (Character.isAlphabetic(expression.charAt(i)))
            {
                t = newNode(expression.charAt(i));
                nodeStack.add(t);
            }
            else if (priorityRank[expression.charAt(i)] > 0)
            {

                // If an operator with lower or
                // same associativity appears
                while (
                        !characterStack.isEmpty() && characterStack.peek() != '('
                                && ((expression.charAt(i) != '^' && priorityRank[characterStack.peek()] >= priorityRank[expression.charAt(i)])
                                || (expression.charAt(i) == '^'
                                && priorityRank[characterStack.peek()] > priorityRank[expression.charAt(i)])))
                {

                    // Get and remove the top element
                    // from the character stack
                    t = newNode(characterStack.peek());
                    characterStack.pop();

                    // Get and remove the top element
                    // from the node stack
                    t1 = nodeStack.peek();
                    nodeStack.pop();

                    // Get and remove the currently top
                    // element from the node stack
                    t2 = nodeStack.peek();
                    nodeStack.pop();

                    // Update the tree
                    t.setLeftSon(t2);
                    t.setRightSon(t1);

                    // Push the node to the node stack
                    nodeStack.add(t);
                }

                // Push s[i] to char stack
                characterStack.push(expression.charAt(i));
            }
            else if (expression.charAt(i) == ')') {
                while (!characterStack.isEmpty() && characterStack.peek() != '(')
                {
                    t = newNode(characterStack.peek());
                    characterStack.pop();
                    t1 = nodeStack.peek();
                    nodeStack.pop();
                    t2 = nodeStack.peek();
                    nodeStack.pop();
                    t.setLeftSon(t2);
                    t.setRightSon(t1);
                    nodeStack.add(t);
                }
                characterStack.pop();
            }
        }
        t = nodeStack.peek();
        return t;
    }

    public static  String inOrder(Node currentNode, String resultString) {
        if(currentNode == null){
            return resultString;
        }

        resultString = inOrder(currentNode.getLeftSon(), resultString);
        resultString = resultString + currentNode.getValue()+ " ";
        resultString = inOrder(currentNode.getRightSon(), resultString);
        return resultString;
    }

public static  String postOrder(Node currentNode, String resultString) {
    if(currentNode == null)
    {
        return resultString; // preserve previously calculated value
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
}
