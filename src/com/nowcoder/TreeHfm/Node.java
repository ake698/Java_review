package com.nowcoder.TreeHfm;
//赫夫曼树节点

public class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return -(this.value-o.value); //大到小
    }

    public String toString(){
        return "value="+this.value;
    }
}
