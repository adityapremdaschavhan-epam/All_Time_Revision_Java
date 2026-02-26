package dsa_questions;

import java.util.HashMap;

public class FirstNonRepeatingElement {
    public static void main(String[] args) {
        int arr[] = {2,3,4,2,3,5};

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : arr)
        {
            map.put(num, map.getOrDefault(num,0)+1);
        }

        // We will traverse the array check which element will have 1 occurenec
        for(int nums : arr)
        {
            if(map.get(nums)==1)
            {
                System.out.println("Non repeating first character: "+nums);
                return;
            }
            
        }
        System.out.println("There is no non repeating character");

        
    }
    
}
