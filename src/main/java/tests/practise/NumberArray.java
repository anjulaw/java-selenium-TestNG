package tests.practise;

import java.util.*;

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

    /**
     *
     * @param arr
     * This method prints duplicate values in the array
     */

    public static void printDuplicates(int[] arr){
        List<Integer> withOutDuplicate = new ArrayList<>();

        for(int i = 0; i < arr.length;i++){
            for(int j = i+1; j<arr.length ; j++){
                if(arr[i] == arr[j]){
                    withOutDuplicate.add(arr[i]);
                }
            }
        }

        if(withOutDuplicate.size() == 0){
            System.out.println("No duplicate found");
        }else {
            for(int x: withOutDuplicate){
                System.out.println(x);
            }
        }
    }

    /**
     *
     * @param arr
     * This method remove the duplicate numbers using Set
     */

    public static void removeDuplicatesWithSet(int[] arr){
        Set<Integer> number = new HashSet<>();
        for(int i: arr){
            number.add(i);
        }

        for(int j : number){
            System.out.println(j);
        }
    }

    /**
     *
     * @param numArray
     * This method sort array in descending order and print the Odd numbers
     */

    public static void printOddNumbersInArray(int[] numArray){

        for(int i = 0 ; i < numArray.length -1 ;i++){
            for(int j = i +1; j < numArray.length;j++){
                if(numArray[i]< numArray[j]){
                    int temp = numArray[i];
                    numArray[i] = numArray[j];
                    numArray[j] = temp;
                }
            }
        }

        for(int i = 0 ; i < numArray.length -1; i++){
            if(numArray[i]%2 != 0){
                System.out.println(numArray[i]);
            }
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
       */

        int[] arr = {3, 1, 4, 2, 5,6,4,2};
//        sortArray(arr);
        printDuplicates(arr);
        System.out.println("========================");
        removeDuplicatesWithSet(arr);

    }
}
