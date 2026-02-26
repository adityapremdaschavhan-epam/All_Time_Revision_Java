package Strings._01_character_frequency;

import java.util.HashMap;
import java.util.Map;

public class template {

    public void templates(){

        // frequency array version
        String s = "abed";
        int[] freq = new int[26];

        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // map versions

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
    }







}
