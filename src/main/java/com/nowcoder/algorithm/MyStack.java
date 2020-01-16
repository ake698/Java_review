package com.nowcoder.algorithm;

/**
 * 栈 先进后出
 */
public class MyStack {

    //栈底层使用数组
    int [] elements;

    public MyStack(){
        elements = new int[0];
    }

    public void push(int element){
        int [] newArr = new int[elements.length + 1];
        for (int i = 0; i <elements.length ; i++) {
            newArr[i] = elements[i];
        }
        newArr[elements.length] = element;
        elements = newArr;
    }

    //取出元素
    public int pop(){
        if(elements.length==0){
            throw new RuntimeException("stack is empty");
        }
        //取出数组的最后一个元素
        int element = elements[elements.length-1];

        int [] newArr = new int[elements.length-1];
        for (int i = 0; i <elements.length-1 ; i++) {
            newArr[i] = elements[i];
        }
        elements = newArr;
        return element;
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
