package com.nowcoder.algorithm;

import java.util.Arrays;

/**
 * 排序算法 之 快速排序
 *
 */

public class QuickSort {

    public static void main(String[] args) {
        int [] arr = new int[] {8,4,6,8,0,99,3};
//        quickSort(arr,0,arr.length-1);
//        selectSort(arr);
        bubbleSort(arr);
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

    //选择排序
    public static void selectSort(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length ; j++) {
                int temp;
                if(arr[i]<arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //冒泡
    public static void bubbleSort(int [] arr){
        int temp;
        for (int i = 0; i < arr.length; i++) {
            boolean swap = true; //true 为没有交换元素，没有元素交换了 代表已经排好序 没必要再循环
            for (int j = 0; j < arr.length-1-i; j++) { // -i 每次都会将最值冒泡移动到最右侧
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = false;
                }
            }
            if(swap)break;
            System.out.println(Arrays.toString(arr));
        }
    }

}
