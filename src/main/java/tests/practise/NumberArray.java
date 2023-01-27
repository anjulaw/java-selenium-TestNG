package tests.practise;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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

    public static int[] removeDuplicates(int[] numArray){

        int[] numArrNoDuplicate = new int[numArray.length];

        int j = 0;
        for(int i = 0; i<numArray.length - 1; i++){
            if(numArray[i] != numArray[i+1]){
                numArrNoDuplicate[j++] = numArray[i];
            }
        }

        numArrNoDuplicate[j++] = numArray[numArray.length -1];

        for(int i = 0;i<j; i++){
            numArray[i] = numArrNoDuplicate[j];
        }

        return numArrNoDuplicate;
    }

    public static void sortArray(int[] numArray){
        for(int i =0; i<numArray.length -1 ; i++){
            for(int j = i + 1; j<numArray.length - 1; j++){
                if(numArray[i]>numArray[j]){
                    int temp = numArray[i];
                    numArray[i] = numArray[j];
                    numArray[j] = temp;
                }
            }
        }

        for(int i:numArray){
            System.out.println(i + "\t");
        }
    }

    public static void main(String[] args) {
        /*Integer[] numbers = {10, 4, 1, 4, -10, -50, 32, 21};
        System.out.println("Min max difference is " + differenceMaxMin(numbers));*/
       /* int[] numArray = {4, 3, 3, 3, 2, 2, 2};
//        int[] numArray = new int[4];
        boolean isHigherExist = existsHigher(numArray,4);
        System.out.println(isHigherExist);*/

        /*int[] numArr = {10,20,20,30,40,50};

        int[] numArr1 = removeDuplicates(numArr);

        for(int x: numArr1){
            System.out.println(x);
        }*/

        int[] arr = {3, 1, 4, 2, 5};
        sortArray(arr);

        // Convert the array to a set
        /*Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }*/

        // Convert the set back to an array
        //int[] uniqueArr = set.stream().mapToInt(Integer::intValue).toArray();
        //System.out.println(Arrays.toString(uniqueArr));
        // Print set
        /*for(int i: set){
            System.out.println(i);
        }*/

    }
}
