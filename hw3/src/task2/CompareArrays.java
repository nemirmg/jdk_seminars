package task2;

import java.util.Arrays;

public class CompareArrays {
    public static <T> boolean compareArrays(T[] arr1, T[] arr2) {
//        return Arrays.deepEquals(arr1, arr2);
        if (arr1.length == arr2.length) {
            for (int i = 0; i < arr1.length; i++) {
                if (!arr1[i].getClass().equals(arr2[i].getClass())) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
