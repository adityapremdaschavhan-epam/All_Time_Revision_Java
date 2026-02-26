package dsa_questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindDuplicateElement {
    public static void main(String[] args) {
        int arr[] = {4,3,1,2,2};

        // Brute force
        // for(int i=0;i<arr.length;i++)
        // {
        //     for(int j=i+1;j<arr.length;j++)
        //     {
        //         if(arr[i]==arr[j])
        //         {
        //             System.out.println("Duplicate: "+arr[i]);
        //             return;
        //         }
        //     }
        // }
        // System.out.println("No Duplicate");

        // Optimized Hashmap Solution || Hashset
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int num: arr)
//        {
//            map.put(num,map.getOrDefault(num,0)+1);
//        }
//
//        for(Map.Entry<Integer,Integer> entry: map.entrySet())
//        {
//            if(entry.getValue()>1)
//            {
//                System.out.println("Duplicate Element= "+entry.getKey());
//                return;
//            }
//
//        }
//        System.out.println("No Duplicate");

        // Hashset
        Set<Integer> set =new HashSet<>();
        for(int num : arr)
        {
//            if(!set.add(num)) {
//                System.out.println("Duplicate: " + num);
//                return;
//            }
            if(set.contains(num)) {
                System.out.println("Duplicate: " + num);
                return;
            }
            set.add(num);
        }
        System.out.println("NO duplicate");
        
        
    }
}
