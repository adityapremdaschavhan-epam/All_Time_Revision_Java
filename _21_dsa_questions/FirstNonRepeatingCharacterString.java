package dsa_questions;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterString {
    public static void main(String[] args) {
        String s = "aabbcedd";

        // brute force
        // for(int i=0;i<s.length();i++)
        // {
        //     boolean isUnique = true;
        //     for(int j=0;j<s.length();j++)
        //     {
        //         if(i!=j && s.charAt(i)==s.charAt(j))
        //         {
        //             isUnique=false;
        //             break;
        //         }
        //     }
        //     if(isUnique)
        //     {
        //     System.out.println("First Non repeating char is: "+s.charAt(i));
        //     return;
        //     }
        // }
        // System.out.println("No element found");


        // Hashmap 

//         Map<Character,Integer> map = new HashMap<>();
//
//         // count frequency
//         for(char c: s.toCharArray())
//         {
//             map.put(c,map.getOrDefault(c,0)+1);
//         }
//
//         // find first with freq 1
//         for(char c : s.toCharArray())
//         {
//             if(map.get(c)==1)
//             {
//                 System.out.println("First no repeating is: "+c);
//                 return;
//             }
//
//         }
//         System.out.println("No elment found ");


        // Most optimized is the freq array
        int [] freq = new int[26];

        for(char c: s.toCharArray())
        {
            freq[c-'a']++;
        }

        for(char c : s.toCharArray())
        {
            if(freq[c-'a']==1)
            {
                System.out.println("First non repeating character is :"+c);
                break;
            }
        }
    }
}
