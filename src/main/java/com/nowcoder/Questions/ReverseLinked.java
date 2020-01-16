package com.nowcoder.Questions;

import java.util.Stack;

/**
 * 反转链表
 */


public class ReverseLinked {



    public static void main(String[] args) throws InterruptedException {
        Node root = new Node(1);
        Node cur = root;
        for (int i = 2; i < 5; i++) {
            Node temp = new Node(i);
            cur.next = temp;
            cur = temp;
        }
        //第一种方法  使用while循环
        Node a = reverse(root);
        Node temp2 = a;
        for (int i = 1; i < 5; i++) {
            System.out.println(temp2.value);
            temp2 = temp2.next;
        }
        Thread.sleep(1000);
        //第二种方法 使用递归 但是无法返回链表反转之后的根节点
        System.out.println("============================");
        reverse2(root);
        for (int i = 1; i < 5; i++) {
            System.out.println(cur.value);
            cur = cur.next;
        }


    }

    public static Node reverse(Node head){
        Node pre = null;
        Node next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 递归方法  此方法无法返回反转后链表的 头节点
     * @param head
     * @return
     */
    public static Node reverse2(Node head){
        if(head==null || head.next==null)return head;
        Node newHead = reverse2(head.next);
        newHead.next = head;
        return head;
    }


}


class Node{
    Node next;
    int value;
    Node(int value){
        this.value = value;
    }

}