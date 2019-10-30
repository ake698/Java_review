package com.nowcoder.Questions;

/**
 * 检查链表是否有环
 *
 * 1.硬找 遍历链表，出现null为无环
 *
 * 2.Set 判重  每次遍历记录 重复为有环
 *
 * 3.快慢指针  快走俩步  慢走一步  重复为有环
 */
public class CheckLinked {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node2;
        System.out.println(checkLinked(node1));
    }

    //快慢法
    public static boolean  checkLinked(Node node){
        if(node==null||node.next==null||node.next.next==null)return false;
        Node fast = node;
        Node slow = node;
        while (true){
            fast = fast.next.next;
            if(fast==null)return false;
            slow = slow.next;
            if(fast==slow){
                return true;
            }
        }
    }
}
