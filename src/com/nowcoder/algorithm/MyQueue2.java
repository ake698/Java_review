package com.nowcoder.algorithm;

public class MyQueue2 {

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
    public MyQueue2(int maxSize){
        this.maxSize = maxSize;
        arr = new long[maxSize];
        elems = 0;
        font = 0;
        end = -1;
    }

    //插入数据
    public void insert(long value){
        arr[++end] = value;
        elems++;
    }

    //移除数据
    public long remove(){
        elems--;
        return arr[font++];
    }

    //是否为空
    public boolean isEmpty(){
        return (elems==0);
    }

    //是否满
    public boolean isFull(){
        return (end==maxSize-1);
    }

    //返回有校元素大小
    public int size(){
        return elems;
    }

}
