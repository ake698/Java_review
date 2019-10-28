package com.nowcoder.algorithm;

public class MyQueue {

    //数组
    private long [] arr;

    //最大空间
    private  int maxSize;

    //有效元素大小
    private int elems;

    //队头
    private int font;

    //对尾
    private int end;

    //构造方法
    public MyQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new long[maxSize];
        elems = 0;
        font = 0;
        end = -1;
    }

    //插入数据
    public void insert(long value){
        if(isFull()){
            return;
        }

        if(end == maxSize -1){
            //队列满
            end = -1;
        }
        arr[++end] = value;
        elems++;
    }

    //移除数据
    public long remove(){
        if(isEmpty()){
            return 0;
        }

        long tmp = arr[font++];
        if(font == maxSize){
            font = 0;
        }
        elems--;
        return tmp;
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
