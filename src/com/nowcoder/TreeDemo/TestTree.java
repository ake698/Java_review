package com.nowcoder.TreeDemo;

/**
 * 二叉树的测试类  二叉排列树
 */
public class TestTree {

    public static void main(String[] args) {
//        findAndChange();
//        displayTree();
//        indisplayTree();
        deleteTest();
//        endTree();
    }


    public static Tree  test1(){
        Tree tree = new Tree();
        tree.insert(10,1);
        tree.insert(36,2);
        tree.insert(9,3);
        tree.insert(66,4);
        tree.insert(69,5);
        tree.insert(6,5);
        tree.insert(7,5);
        tree.insert(42,434);
        tree.insert(100,5);
        tree.insert(102,5);
        tree.insert(70,5);
        tree.insert(30,5);
        tree.insert(3,5);
        tree.insert(1,5);
        tree.insert(4,5);
        tree.insert(50,5);
        return tree;
    }

    public static void deleteTest(){
        Tree tree = test1();
        tree.inOrder(tree.getRoot());
        System.out.println();
        tree.delete(6);
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
