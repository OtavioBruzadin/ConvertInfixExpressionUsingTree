package org.example;

import java.util.Stack;

public class ExpressionTree {
    public static boolean isOperator(char ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '(' || ch == ')' || ch == '{' || ch == '}';
    }

    public static CharNode expressionTree(String postfix){
        Stack<CharNode> st = new Stack<CharNode>();
        CharNode t1,t2,temp;

        for(int i=0;i<postfix.length();i++){
            if(!isOperator(postfix.charAt(i))){
                temp = new CharNode(postfix.charAt(i));
                st.push(temp);
            }
            else{
                temp = new CharNode(postfix.charAt(i));

                t1 = st.pop();
                t2 = st.pop();

                temp.left = t2;
                temp.right = t1;

                st.push(temp);
            }

        }
        temp = st.pop();
        return temp;
    }
    public static void inOrder(CharNode root){
        if(root==null) return;

        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }

    public static void preOrder(CharNode root){
        if(root==null) return;
        System.out.print(root.data);
        preOrder(root.left);
        preOrder(root.right);

    }

}
