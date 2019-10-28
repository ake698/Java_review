package com.nowcoder.algorithm;

public class TestQueue {
    public static void main(String[] args) {
        PriorityTest();
    }
    public static void PriorityTest(){
        PriorityQueue pq = new PriorityQueue(4);
        pq.insert(30);
        pq.insert(45);
        pq.insert(15);
        pq.insert(2);
        pq.insert(1);

        while (!pq.isEmpty()){
            System.out.print(pq.remove()+" ");
        }
    }

}
