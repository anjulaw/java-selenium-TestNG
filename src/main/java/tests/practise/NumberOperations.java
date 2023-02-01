package tests.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOperations {

    public static int operate(int num1, int num2, String operator) {

        int answer;

        switch (operator){
            case "+":
                answer =  num1 + num2;
                    break;
            case "-":
                answer =  num1 - num2;
                break;
            case "*":
                answer = num1 * num2;
                break;
            case "/":
                answer = num1 / num2;
                break;
            case "%":
                answer = num1 % num2;
                break;
            default:
                answer =  num1 + num2;
        }
        return answer;
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int positiveCount = 0, negativeCount = 0, zeroCount = 0;
        for(int num: arr){
            if(num > 0){
                positiveCount = positiveCount + 1;
            }else if(num < 0){
                negativeCount = negativeCount + 1;;
            }else{
                zeroCount = zeroCount + 1;
            }
        }
        System.out.println(String.format("%.6f",(double) positiveCount/arr.size()));
        System.out.println(String.format("%.6f",(double) negativeCount/arr.size()));
        System.out.println(String.format("%.6f",(double) zeroCount/arr.size()));
    }

    public static void staircase(int n) {
        // Write your code here
        int x = n-1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (x > j) {
                    System.out.print(" ");
                }
                else {
                    System.out.print("#");
                }
            }
            x -= 1;
            System.out.println();
        }
    }

    public static void main(String[] args) {

//        System.out.println(operate(100,8,"%"));

        /*List<Integer> numList = new ArrayList<>(Arrays.asList(-4, 3, -9, 0, 4, 1));
        plusMinus(numList);*/

        staircase(5);

    }
}
