package tests.practise;

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

    public static void main(String[] args) {
        System.out.println(operate(100,8,"%"));
    }
}
