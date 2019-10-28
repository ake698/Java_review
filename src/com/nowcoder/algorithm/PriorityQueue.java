package com.nowcoder.algorithm;

/**
 * 优先级队列  从大到小排序，从末尾开始取值出去
 */
public class PriorityQueue {
    //数组
    private long [] arr;

    //最大空间
    private  int maxSize;

    //有效元素大小
    private int elems;


    //构造方法
    public PriorityQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new long[maxSize];
        elems = 0;
    }

    //插入数据
    public void insert(long value){
        if(isFull()){
            return;
        }

        int i;
        for (i = 0; i < elems; i++) {
            if(value > arr[i]){
                break;
            }
        }

        for (int j = elems; j > i ; j--) {
            arr[j] = arr[j-1];
        }
        arr[i] = value;
        elems++;
    }

    //移除数据
    public long remove(){
        if(isEmpty()){
            return 0;
        }
        long value = arr[elems-1];
        elems--;
        return value;
    }

    //是否为空
    public boolean isEmpty(){
        return (elems==0);
    }

    //是否满
    public boolean isFull(){
        return (elems==maxSize);
    }

    //返回有校元素大小
    public int size(){
        return elems;
    }

}
