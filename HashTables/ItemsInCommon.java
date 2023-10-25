package HashTables;

import java.util.HashMap;

public class ItemsInCommon {
    
    public static boolean findCommonItem(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();

        for(int i: array1) {
            hashMap.put(i, true);
        }

        for(int j: array2) {
            if( hashMap.get(j) != null) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr1= {1,2,3};
        int[] arr2 = {6,4,5};

        System.out.println(findCommonItem(arr1, arr2));
    }
}
