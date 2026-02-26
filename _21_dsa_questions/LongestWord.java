package dsa_questions;

import java.util.Arrays;
import java.util.Comparator;

public class LongestWord {
    public static void main(String[] args) {
        // Find the longest word in a string 

        String s = "i love programming";
        String[] words = s.split(" ");

        String longesty = Arrays.stream(words).sorted(Comparator.comparingInt(String::length).reversed()).findFirst().get();
        System.out.println(longesty);


        String longest="";

        for(String word : words)
        {
            if(word.length() > longest.length())
            {
                longest=word;
            }
        }
        System.out.println(longest);

    }
}
