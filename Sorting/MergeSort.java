package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length+array2.length];
        int index = 0;
        int i=0;
        int j=0;

        while(i < array1.length && j< array2.length) {
            if(array1[i] < array2[j]) {
                result[index] = array1[i];
                index++;
                i++;
            } else {
                result[index] = array2[j];
                index++;
                j++;
            }
        }

        while(i < array1.length) {
            result[index] = array1[i];
            index++;
            i++;
        }

        while(j < array2.length) {
            result[index] = array2[j];
            index++;
            j++;
        }

        return result;
    }

    public static int[] mergeSort(int[] array) {

        if(array.length == 1) return array;

        int midIndex = array.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int [] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);

    }

    public static void main(String[] args) {
        int[] array1 = {3,1,4,2};

        System.out.println( Arrays.toString(mergeSort(array1)));
    }
}
