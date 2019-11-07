package com.nowcoder.Questions;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

     示例:

     给定 nums = [2, 7, 11, 15], target = 9

     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2,6,7,1,8,5,4};
//        twoSumMethod1(arr,9);
        System.out.println(twoSumMethod2(arr,9));
    }

    //俩数之和
    public static void twoSumMethod1(int [] arr,int target){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]+arr[j]==target){
                    System.out.println(i+"--"+j);
                }
            }
        }
    }

    public static int[] twoSumMethod2(int [] nums,int target) {
            HashMap<Integer,Integer> mymap = new HashMap<Integer,Integer>();
            for(int i=0;i<nums.length;i++){
                mymap.put(nums[i],i);
            }
            for(int i=0;i<nums.length;i++){
                if(mymap.containsKey(target-nums[i]) && mymap.get(target-nums[i])!=i){
                    return new int[]{i,mymap.get(target-nums[i])};
                }
            }
            return null;

        }
    }


