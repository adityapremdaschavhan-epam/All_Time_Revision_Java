package dsa_questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnnagrams {
    public static void main(String[] args) {
         String[] words = {"eat","tea","tan","ate","nat","bat"};

// Sort each word

// Use sorted word as key

// Add original word into list
         HashMap<String, ArrayList<String>> map = new HashMap<>();

         for(String w : words)
         {
            char[] arr = w.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

//            map.putIfAbsent(key, new ArrayList<>());
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(w);
         }
         System.out.println(map.values());
    }
}
