package dsa_questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstOccurenceIndex {
    public static void main(String[] args) {

        // you want a Java program that takes an array and stores the first occurrence index of each element in a Map.

        int [] arr = {4, 2, 7, 2, 4, 9, 7, 1};

        Map<Integer,Integer> map = new LinkedHashMap<>();

        // trverse the arry and store the value in hashmap if the element is unoique 
        for(int i=0;i<arr.length;i++)
        {
            if(!map.containsKey(arr[i]))
            {
                map.put(arr[i],i);
            }
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            System.out.println(entry.getKey()+" "+ entry.getValue());
        }

        System.out.println("---------------------");

        // Another method 

        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> mpp = new HashMap<>();

        mpp.put(0,1);
        System.out.println(map.put(0,2));

        for(int i=0;i<arr.length;i++)
        {
            if(set.add(arr[i]))
            {
                mpp.put(arr[i],i);
            }

        }
         for(Map.Entry<Integer,Integer> entry: mpp.entrySet())
        {
            System.out.println(entry.getKey()+" "+ entry.getValue());
        }
        




    }
}
