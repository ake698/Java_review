package com.nowcoder.TreeDemo;

public class Node {

    //关键字
    private int keyData;

    //其他数据
    private int otherData;

    //左子节点
    private Node leftNode;

    //右子节点
    private Node rightNode;

    public Node(int keyData, int otherData) {
        this.keyData = keyData;
        this.otherData = otherData;
    }

    public int getKeyData() {
        return keyData;
    }

    public void setKeyData(int keyData) {
        this.keyData = keyData;
    }

    public int getOtherData() {
        return otherData;
    }

    public void setOtherData(int otherData) {
        this.otherData = otherData;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public void display(){
        System.out.print(this.keyData+","+this.otherData+"   ");
    }

    @Override
    public String toString() {
        return "Node{" +
                "keyData=" + keyData +
                ", otherData=" + otherData +
                '}';
    }
}
