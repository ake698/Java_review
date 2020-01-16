package com.nowcoder.TreeHfm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestHuffmanTree {
    public static void main(String[] args) {
        int [] arr = {3,7,8,29,5,11,23,14};
        Node node = createHuffmanTree(arr);
        System.out.println(node);
        System.out.println(node.right.right);
    }

    public static Node createHuffmanTree(int [] arr){
        //先使用数组中的所有元素创建若干个二叉树（只有一个节点）
        List<Node> nodes = new ArrayList<>();
        for (int i : arr) {
            nodes.add(new Node(i));
        }
//        Collections.sort(nodes);
//        System.out.println(nodes);
        while(nodes.size()>1){
            //排序
            Collections.sort(nodes);//从大到小排序
            //取出来权值最小的二叉树
            //取出权值最小的二叉树
            Node left = nodes.get(nodes.size()-1);
            //取出权值次小的二叉树
            Node right = nodes.get(nodes.size()-2);
            //创建一颗新的二叉树
            Node partent = new Node(left.value + right.value);
            partent.left = left;
            partent.right = right;
            //把取出来的俩个二叉树移除
            nodes.remove(left);
            nodes.remove(right);
            //放入原来的二叉树聚合中
            nodes.add(partent);
        }
        return nodes.get(0);
    }
}
