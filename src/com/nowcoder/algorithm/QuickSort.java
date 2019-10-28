package com.nowcoder.algorithm;

import java.util.Arrays;

/**
 * 排序算法 之 快速排序
 *
 */

public class QuickSort {

    public static void main(String[] args) {
        int [] arr = new int[] {8,4,6,8,0,99,3};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[]arr,int start,int end){
        if(start < end){

        //把数组的第0个数组作为标准
        int stard = arr[start];

        //记录需要排序的下标
        int low = start;
        int high = end;
        //循环找比标准数大的数 和 比标准数小的数
        while(low < high){
            //右边数字比标准数大  不需要移动位置
            while(low < high && stard <= arr[high]){
                high--;
            }
            //使用右边的大数字替换左边的数字
            arr[low] = arr[high];
            //如果左边的数字比标准数小
            while(low<high && arr[low]<=stard){
                low++;
            }
            arr[high]=arr[low];
        }
        //把标准数赋给 俩下标相等的时候的位置
        arr[low] = stard;
//        //再次排序
//        //处理所有比标准数小的数字
        quickSort(arr,start,low);
//        //处理所有比标准数大的数字
        quickSort(arr,low+1,end);
    }

    }

}
