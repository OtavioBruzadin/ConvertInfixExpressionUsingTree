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
    static Node build(String s)
    {

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

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(') {

                // Push '(' in char stack
                stC.add(s.charAt(i));
            }

            // Push the operands in node stack
            else if (Character.isAlphabetic(s.charAt(i)))
            {
                t = newNode(s.charAt(i));
                stN.add(t);
            }
            else if (p[s.charAt(i)] > 0)
            {

                // If an operator with lower or
                // same associativity appears
                while (
                        !stC.isEmpty() && stC.peek() != '('
                                && ((s.charAt(i) != '^' && p[stC.peek()] >= p[s.charAt(i)])
                                || (s.charAt(i) == '^'
                                && p[stC.peek()] > p[s.charAt(i)])))
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
                stC.push(s.charAt(i));
            }
            else if (s.charAt(i) == ')') {
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

        public static void inOrder(Node root){
        if(root==null) return;

        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }

    public static void preOrder(Node root){
        if(root==null) return;
        System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);

    }
    static void postorder(Node root) {
        if (root != null)
        {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data);
        }
    }
}
