package tests.practise;

import java.util.Arrays;
import java.util.Collections;

public class NumberArray {

    public static int differenceMaxMin(Integer[] arr) {

        int max ,min ;
        min = Collections.min(Arrays.asList(arr));

        max = Collections.max(Arrays.asList(arr));

        System.out.println("Smallest number is " + min);
        System.out.println("Highest number is " + max);

        return max - min;
    }

    public static boolean existsHigher(int[] arr, int n) {

        boolean isHigherExist = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= n) {
                isHigherExist = true;
                break;
            }
        }
        return isHigherExist;
    }

    public static void main(String[] args) {
        /*Integer[] numbers = {10, 4, 1, 4, -10, -50, 32, 21};

        System.out.println("Min max difference is " + differenceMaxMin(numbers));*/

        int[] numArray = {4, 3, 3, 3, 2, 2, 2};
//        int[] numArray = new int[4];
        boolean isHigherExist = existsHigher(numArray,4);
        System.out.println(isHigherExist);
    }



}
