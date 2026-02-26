package dsa_questions;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {

        // Brute force 
        String s = "silente";
        String t = "listene";

        if(s.length() != t.length())
        // {
        //     System.out.println("Not anagram");
        //     return;
        // }

        // char[] a1 = s.toCharArray();
        // char[] a2 = t.toCharArray();

        // Arrays.sort(a1);
        // Arrays.sort(a2);

        // if(Arrays.equals(a1, a2)){
        //     System.out.println("Anagram");
        // }
        // else{
        //     System.out.println("Not Anagram");
        // }

        // Hashmap/Frequency table
        if(s.length()!=t.length())
        {
            System.out.println("Not a anagram");
            return;
        }

        Map<Character,Integer> map = new HashMap<>();

        // Insert the element from string s into the map
        for( char c : s.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }

        // Decrement the value from hashmap if found
        for(char c : t.toCharArray())
        {
            if(!map.containsKey(c))
            {
                System.out.println("Not Anagram");
                return;
            }
            // remove the element 
            map.put(c,map.get(c)-1);

            if(map.get(c)==0)
            {
                map.remove(c);
            }

        }

        if(map.isEmpty())
        {
            System.out.println("Anagram");
        }else{
            System.out.println("Not anagram");
        }
    }
}
