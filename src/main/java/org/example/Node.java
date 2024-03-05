package org.example;

public class Node {

    private String value;
//    private Node parentNode;

    private Node leftSon;

    private Node rightSon;

    public Node (String  data){
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

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public float visitar(){return Float.parseFloat(value);}

    public Node getLeftSon() {
        return leftSon;
    }



    public Node getRightSon() {
        return rightSon;
    }
}
