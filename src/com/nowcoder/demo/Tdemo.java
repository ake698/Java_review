package com.nowcoder.demo;


import java.lang.reflect.Field;
import java.util.ArrayList;

public class Tdemo{

    public static void main(String[] args) {
//        int [][] arrs = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        System.out.println(FindByBinary(13,arrs));

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        System.out.println(new Tdemo().printListFromTailToHead(listNode));

    }

    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        myMethod(listNode);
        return list;
    }

    public void myMethod(ListNode listNode){
        int a = listNode.val;
        if(listNode.next != null){
            myMethod(listNode.next);
        }
        list.add(listNode.val);
    }



    public static boolean Find(int target, int [][] array) {
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                    System.out.println(array[i][j]);
                if(array[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean FindByBinary(int target, int [][] array) {

        for (int i = 0; i <array.length ; i++) {

            int low = 0;
            int high = array[i].length-1;
            int mid = (high+low)/2;
            while (low<=high){
                mid = (high+low)/2;
                if(array[i][mid]==target){
                    return true;
                }
                if(array[i][mid]>target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return false;
    }

}

    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
 }