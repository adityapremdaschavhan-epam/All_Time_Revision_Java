package Strings._01_character_frequency;

public class firstUniqueCharacter {
    public int firstUniqChar() {
        String s = "aabbcddee";
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
