package tests.practise;

public class StringPractice {

    public static int countWords(String s) {
        String[] words = s.split(" ");
        return words.length;
    }

    public static String stutter(String word) {

       String subStr1 = word.substring(0,2);
       return subStr1 + "... " + subStr1 + "... " + word + "?";
    }

    public static String nameShuffle(String s) {
        String[] words = s.split(" ");
        String reverseStr = "";
        for(int i = words.length -1; i>=0; i--){
             reverseStr = reverseStr + " " + words[i];
        }
        return reverseStr.trim();
    }

    public static boolean checkEnding(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();
        String endStr = str1.substring((str1Length - str2Length),str1Length);
        return (endStr.equals(str2));
    }

    public static String bomb(String str) {
        String[] words = str.split(" ");
        String result = null;
        for(String s : words){
            if(s.toLowerCase().contains("bomb")){
                result = "DUCK!";
                break;
            }else {
                result = "Relax, there's no bomb.";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "incredible";
//        System.out.println("word count is " + countWords(str));
//        System.out.println(stutter(str));
        String name = "Donald Trump";
//        System.out.println(nameShuffle(name));
//        System.out.println(checkEnding("convention","tio"));
        System.out.println(bomb("This goes boom!!!"));
    }
}
