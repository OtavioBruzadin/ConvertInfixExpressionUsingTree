package org.example;

import java.util.Stack;

public class Tree {
    static Node newNode(char c)
    {
        Node n = new Node();
        n.data = c;
        n.left = n.right = null;
        return n;
    }

    // Function to build Expression Tree
    static Node buildExpressionTree(String expression) {

        // Stack to hold nodes
        Stack<Node> stN = new Stack<>();

        // Stack to hold chars
        Stack<Character> stC = new Stack<>();
        Node t, t1, t2;

        // Prioritising the operators
        int []p = new int[123];
        p['+'] = p['-'] = 1;
        p['/'] = p['*'] = 2;
        p['^'] = 3;
        p[')'] = 0;

        for (int i = 0; i < expression.length(); i++)
        {
            if (expression.charAt(i) == '(') {

                // Push '(' in char stack
                stC.add(expression.charAt(i));
            }

            // Push the operands in node stack
            else if (Character.isAlphabetic(expression.charAt(i)))
            {
                t = newNode(expression.charAt(i));
                stN.add(t);
            }
            else if (p[expression.charAt(i)] > 0)
            {

                // If an operator with lower or
                // same associativity appears
                while (
                        !stC.isEmpty() && stC.peek() != '('
                                && ((expression.charAt(i) != '^' && p[stC.peek()] >= p[expression.charAt(i)])
                                || (expression.charAt(i) == '^'
                                && p[stC.peek()] > p[expression.charAt(i)])))
                {

                    // Get and remove the top element
                    // from the character stack
                    t = newNode(stC.peek());
                    stC.pop();

                    // Get and remove the top element
                    // from the node stack
                    t1 = stN.peek();
                    stN.pop();

                    // Get and remove the currently top
                    // element from the node stack
                    t2 = stN.peek();
                    stN.pop();

                    // Update the tree
                    t.left = t2;
                    t.right = t1;

                    // Push the node to the node stack
                    stN.add(t);
                }

                // Push s[i] to char stack
                stC.push(expression.charAt(i));
            }
            else if (expression.charAt(i) == ')') {
                while (!stC.isEmpty() && stC.peek() != '(')
                {
                    t = newNode(stC.peek());
                    stC.pop();
                    t1 = stN.peek();
                    stN.pop();
                    t2 = stN.peek();
                    stN.pop();
                    t.left = t2;
                    t.right = t1;
                    stN.add(t);
                }
                stC.pop();
            }
        }
        t = stN.peek();
        return t;
    }

    public static  String inOrder(Node currentNode, String resultString) {
        if(currentNode == null){
            return resultString;
        }

        resultString = inOrder(currentNode.left, resultString);
        resultString = resultString + currentNode.data + " ";
        resultString = inOrder(currentNode.right, resultString);
        return resultString;
    }

public static  String postOrder(Node currentNode, String resultString) {
    if(currentNode == null)
    {
        return resultString; // preserve previously calculated value
    }
    //Go through left
    resultString = postOrder(currentNode.left, resultString);
    //Go through right
    resultString = postOrder(currentNode.right, resultString);
    resultString = resultString + currentNode.data + " ";
    return resultString;
}

    public static  String preOrder(Node currentNode, String resultString) {
        if(currentNode == null)
        {
            return resultString; // preserve previously calculated value
        }
        resultString = resultString + currentNode.data + " ";
        //Go through left
        resultString = preOrder(currentNode.left, resultString);
        //Go through right
        resultString = preOrder(currentNode.right, resultString);

        return resultString;
    }
}
