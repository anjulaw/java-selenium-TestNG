package tests.practise;

import java.util.*;

public class NumberList {

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long maxSum = 0L , minSum = 0L;

        int numbersInList = arr.size();

        Collections.sort(arr);

        for(int a: arr){
            System.out.println(a);
        }

        for(int i = 0; i< numbersInList-1 ; i++){
            minSum = minSum + arr.get(i);
        }

        for(int j = numbersInList-1; j>0;j--){
            System.out.println(arr.get(j));
            maxSum = maxSum + Long.valueOf(arr.get(j));
        }

        System.out.println(minSum + " " + maxSum);

    }


    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        int count = 1;
        Collections.sort(candles);

        for(int i = candles.size() -1; i> 0; i--){
            if(candles.get(i).equals(candles.get(i -1))){
                count ++;
            }else {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        /*List<Integer> numList = new ArrayList<>(Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625));
        miniMaxSum(numList);*/

        List<Integer> candleList = new ArrayList<>(Arrays.asList(10,10,10,10,10,10,10,10,10,10,10,10,10));
        int candleCount = birthdayCakeCandles(candleList);
        System.out.println("List size " + candleList.size());
        System.out.println(candleCount);
    }


}
