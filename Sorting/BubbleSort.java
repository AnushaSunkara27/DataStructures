package Sorting;

import java.util.Arrays;

public class BubbleSort {
    
    public static void bubbleSort(int[] arr) {
        for(int i=arr.length-1; i> 0; i--) {
            for(int j=0; j< i; j++) {
                if(arr[j]>arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void bubbleSort2(int [] arr) {
        int n = arr.length;
        boolean swapped = false;

        for(int i=0; i<n-1; i++) {
            for(int j=0; j<n-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            
            // If no two elements were swapped in the inner loop, the array is already sorted
            if(!swapped) {
                break;
            }
        }

    }


    public static void main(String[] args) {
        int[] myArray = {4,2,6,5,1,3};
        bubbleSort2(myArray);

        System.out.println(Arrays.toString(myArray));
    }
}
