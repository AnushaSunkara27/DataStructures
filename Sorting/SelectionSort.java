package Sorting;

import java.util.Arrays;

public class SelectionSort {
    
    public static void selectionSort(int[] array) {
        for(int i=0; i< array.length; i++) {
            int minIndex = i;
            for(int j=i+1; j< array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if(i != minIndex) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }

    public static void selectionSort2(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n; i++) {
            int minIndex = i;

            for(int j=i+1; j<n; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String [] args) {
        int[] array = {4,2,6,5,1,3};
        selectionSort2(array);
        System.out.println(Arrays.toString(array));
    }
}
