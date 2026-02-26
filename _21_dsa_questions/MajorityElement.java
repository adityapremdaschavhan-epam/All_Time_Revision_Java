package dsa_questions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MajorityElement {
    public static void main(String[] args) {
        // Element appearing > n/2 times

        int arr[] = {3,2,1,3,3};
        int n = arr.length;

        Map<Integer,Integer> mpp = new HashMap<>();

        for(int value : arr){
            mpp.put(value,mpp.getOrDefault(value,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: mpp.entrySet())
        {
            if(entry.getValue()>=n/2)
            {
                System.out.println(entry.getKey());
                return;
            }
        }
        System.out.println("No majority element found ");
        




    }
}
