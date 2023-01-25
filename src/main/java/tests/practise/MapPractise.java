package tests.practise;

import java.util.HashMap;
import java.util.Map;

public class MapPractise {

    //get char occurrences in a string
    public static HashMap<Character,Integer> countStringOccurrence(String str){

       HashMap<Character,Integer> charCountMap = new HashMap<>();
       for(int i=0; i<str.length(); i++){
           if(charCountMap.containsKey(str.charAt(i))){
               int count = charCountMap.get(str.charAt(i));
               charCountMap.put(str.charAt(i),++count);
           }else {
               charCountMap.put(str.charAt(i),1);
           }
       }
       return charCountMap;
    }

    public static void main(String[] args) {
        String strToCheck = "waaanjula";

        HashMap<Character,Integer> charCountMap = countStringOccurrence(strToCheck);
        for(Map.Entry<Character,Integer> mapEntry : charCountMap.entrySet()){
            System.out.println(mapEntry.getKey() + " Count is " + mapEntry.getValue());
        }
    }
}
