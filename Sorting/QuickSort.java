package Sorting;

import java.util.Arrays;

public class QuickSort {
    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }


    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;

        for(int i=pivotIndex+1; i< array.length; i++) {
            if(array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }
        swap(array, pivotIndex, swapIndex);
        return swapIndex;
    }

    private static void quickSort(int[] array, int left, int right) {
        if(left < right) {
            int pivotIndex = pivot(array, left, right);
            quickSort(array, left, pivotIndex-1);
            quickSort(array, pivotIndex+1, right);
        }
    }

    public static void main(String[] args) {
        int[] myArray = {4,6,1,7,3,2,5};

        quickSort(myArray, 0, 6);
        System.out.println(Arrays.toString(myArray));
    }
}
