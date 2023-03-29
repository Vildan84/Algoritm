package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] arr = new int[]{5, 2, 6, 1, 0, -5, 456, 21, -400, 7, 9, 10};
        sort_heap(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void heap(int[] arr, int i, int length){

        int max = i;
        int right = i*2+1;
        int left = i*2+2;

        if (left < length && arr[left] > arr[max]){
            max = left;
        }

        if (right < length && arr[right] > arr[max]){
            max = right;
        }

        if (i != max){
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            heap(arr, max, length);
        }
    }

    public static void sort_heap(int[] arr){
        int length = arr.length;

        for (int i = length/2 - 1; i >= 0; i--){
            heap(arr, i, length);
        }

        for (int i = length - 1; i >= 0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heap(arr, 0, i);
        }
    }
}