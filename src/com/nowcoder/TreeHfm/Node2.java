package com.nowcoder.TreeHfm;

/**
 * Huffman 编码实现
 */

public class Node2 implements Comparable<Node2>{
    int weight; //权值
    Byte data;
    Node2 left;
    Node2 right;
    public Node2(Byte data,int weight){
        this.data = data;
        this.weight = weight;
    }


    @Override
    public int compareTo(Node2 o) {
        return o.weight-this.weight;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "weight=" + weight +
                ", data=" + data +
                '}';
    }
}
