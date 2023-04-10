package com.karabulut.javastring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class JavaStringApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaStringApplication.class, args);

        // return count of different chars. Only A and B chars are supported
        countOfDifferentCharsFirstWay("AAABAB");//2
        countOfDifferentCharsSecondWay("AAAAAAAAB");//7
        countOfDifferentCharsSecondWay("BB");//2

        // return reverse of string
        returnReverseOfString("Google");

        //swap First And Last CharsIf Word Contains `S`
        swapFirstAndLastCharsIfWordContains_S("coensio");

    }

    private static int countOfDifferentCharsFirstWay(String text) {
        int countOfA = 0, countOfB = 0, result1 = 0;

        // First Way
        Map<Character, Integer> charFreq = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (charFreq.containsKey(c)) {
                charFreq.put(c, charFreq.get(c) + 1);
            } else {
                charFreq.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : charFreq.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            result1=Math.abs(result1)-entry.getValue();
        }
        result1 = result1<0 ? result1*-1 : result1;

        return result1;
    }

    private static int countOfDifferentCharsSecondWay(String text) {
        int countOfA = 0, countOfB = 0, result2 = 0;

        countOfA = StringUtils.countOccurrencesOf(text, "A");
        countOfB = StringUtils.countOccurrencesOf(text, "B");
        result2 =  Math.abs(countOfA - countOfB);

        //  System.out.println("countOfDifferentChars => "+ countOfA + " " + countOfB + " " + "result1 : " + result1 + " " + "result2 : " + result2);'
        return result2;
    }

    private static void returnReverseOfString(String text) {
        String result1 = "", result2="";

        // First Way
        for (int i=0; i<text.length(); i++) { result1 = text.charAt(i)+result1; }

        //Second Way
        result2 = new StringBuilder(text).reverse().toString();

        //result
        System.out.println("returnReverseOfString => result1:" + result1 + " result2:" + result2);
    }


    private static String swapFirstAndLastCharsIfWordContains_S(String text) {
        String result = "";
        if(text.contains("s")){
            String firstChar = text.substring(0,1);
            String lastChar = text.substring(text.length()-1,text.length());
            result = lastChar + text.substring(1,text.length()-1) + firstChar;
        }

        System.out.println("returnReverseOfString => result:" + result);
        return result;
    }


}
