package com.nowcoder.algorithm;

public class BinarySearch {

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,5,7,10,12,20,30};
        //目标元素
        int target = 30;

        int begin = 0;
        int end = arr.length-1;
        int mid = (end+begin)/2;
        int index = -1; //记录目标位置

        while (true){

            if(begin>end)break;

            //判断中间元素是不是要查找的元素
            if(target==arr[mid]){
                index = mid;
                break;
            }else{
                if(arr[mid]>target){
                    end = mid - 1;
                }else{
                    begin = mid + 1;
                }
                mid = (end+begin)/2 ;
            }
        }
        System.out.println(arr[index]);
        System.out.println(index);

    }

}
