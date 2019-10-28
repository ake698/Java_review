package com.nowcoder.demo;

public class NodeTest {


    public static void main(String[] args) {
        Node node1 = new Node(10);
        Node node2 = node1;
        System.out.println(node2.value);
        node1.value = 8;
        System.out.println(node2.value);
    }
}

class Node{
    int value;
    public Node(int value){
        this.value = value;
    }
}
