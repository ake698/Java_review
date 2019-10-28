package com.nowcoder.TreeAVL;

/**
 * 二叉树的测试类  二叉排列树
 */
public class TestTree {

    public static void main(String[] args) {
//        displayTree();
//        indisplayTree();
//        deleteTest();
//        endTree();
//        Tree tree = test1();
//        int a = tree.height(tree.getRoot().getLeftNode());
//        System.out.println(a);
        llTest();
    }


    public static Tree test1(){
        Tree tree = new Tree();
        int [] arrs = {8,5,12,10,20,11};
        for (int arr : arrs) {
            tree.insert(arr,1);
        }
        return tree;
    }

    public static void deleteTest(){
        Tree tree = test1();
        tree.inOrder(tree.getRoot());
        System.out.println();
        tree.delete(8);
        tree.inOrder(tree.getRoot());
    }

    public static void llTest(){
        Tree tree = test1();
        System.out.println(tree.getRoot());
        tree.inOrder(tree.getRoot());
    }

    public static  void findAndChange(){
        Tree tree = test1();
        Node result = tree.find(66);
        result.display();
        tree.change(66,1010);
        result.display();
    }

    public static void displayTree(){
        Tree tree = test1();
        tree.preOrder(tree.getRoot());
    }

    //中序遍历
    public static void indisplayTree(){
        Tree tree = test1();
        tree.inOrder(tree.getRoot());
    }

    //后序遍历
    public static void endTree(){
        Tree tree = test1();
        tree.endOrder(tree.getRoot());
    }
}
