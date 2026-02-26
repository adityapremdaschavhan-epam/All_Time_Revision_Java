package dsa_questions;

import java.util.HashMap;
import java.util.Map;

public class CountFrequencyOfNumbers {

    public static void main(String[] args) {
       
    int arr[] = {1,2,2,3,1};
       
        
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int num :arr)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println("key is " + entry.getKey() + " frequency is "
                    + entry.getValue() + " entry is  is "
                    + entry);
        }
    }
}

