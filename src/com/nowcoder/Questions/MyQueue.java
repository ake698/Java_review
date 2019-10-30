package com.nowcoder.Questions;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;

/**
 * 俩个栈实现一个队列
 */

public class MyQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop(){
        if (stack1.isEmpty()){
            throw new EmptyStackException();
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        Integer result = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        System.out.println(result);
        return result;
    }


    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
        myQueue.pop();
    }


}
