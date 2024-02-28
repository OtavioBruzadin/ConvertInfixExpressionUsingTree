package org.example;

public class Node {

    private char value;
//    private Node parentNode;

    private Node leftSon;

    private Node rightSon;

    public Node (char data){
        this.value = data;
//      this.parentNode = parent;
        this.leftSon =null;
        this.rightSon = null;
    }

    public void setLeftSon(Node leftSon) {
        this.leftSon = leftSon;
    }

    public void setRightSon(Node rightSon) {
        this.rightSon = rightSon;
    }

//    public void setParentNode(Node parentNode) {
//        this.parentNode = parentNode;
//    }

    public void setValue(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public Node getLeftSon() {
        return leftSon;
    }



    public Node getRightSon() {
        return rightSon;
    }
}
