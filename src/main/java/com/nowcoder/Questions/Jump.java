package com.nowcoder.Questions;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 注意可先跳再走再跳 或者 先走再跳再走
 *

 这一题就是延续斐波那契数列的思路，青蛙跳1级台阶有1种跳法，2级台阶有2种跳法
 3级台阶时可以从1级台阶跳上来也可以从2级台阶跳上来，即等于1级台阶的跳法加2级台阶的跳法
 因此n级台阶共有n-2级台阶跳法数+n-1级台阶跳法数
 n   f1   f2  sum   n代表阶数  f1 n-1阶   f2 n-2阶  sum 代表n阶需要的次数
 3   2    1    3
 4   3    2    5
 5   5    3    8
 6   8    5    13
 */

public class Jump {
    int count = 0;
    public int JumpFloor(int target) {

        if(target==1){
            return 1;
        }
        JumpFunc(target);
        System.out.println(count);
        return count;
    }

    public void JumpFunc(int target){

        if(target==0){
            count++;
            return;
        }
        if(target<0){
            return;
        }
        JumpFunc(target-1);
        JumpFunc(target-2);
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        jump.JumpFloor(7);
        System.out.println(jump.anthorMehtod(7));
    }


    public int anthorMehtod(int target){
        if(target == 1 )return 1;
        if(target == 2)return 2;
        int f1 = 2,f2 = 1,sum=0;  //f1 n-1阶次数   f2 n-2阶次数
        for (int i = 3; i <=target; i++) {
            sum = f1+f2;
            f2 = f1;
            f1 = sum;
        }
        return sum;
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * @param target
     * @return
     */
    public int JumpFloor2(int target) {

        if(target==1){
            return 1;
        }
        JumpFunc2(target);
        System.out.println(count);
        return count;
    }

    public void JumpFunc2(int target){

        if(target==0){
            count++;
            return;
        }
        if(target<0){
            return;
        }
        for (int i = 1; i <=target; i++) {
            JumpFunc2(target);
        }
    }


}
