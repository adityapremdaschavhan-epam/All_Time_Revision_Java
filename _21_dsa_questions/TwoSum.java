package dsa_questions;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {2,7,11,15};
        int n = arr.length;
        int target = 9;


        // Brute force
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==target)
                {
                    System.out.println(arr[i] +" " +arr[j]);
                    return;
                }
            }
        }
        System.out.println("No elemnt have addition equal to target");

        // Optimized version 
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){

            int need = target - arr[i];

            if(map.containsKey(need)){
                System.out.println(need + " + " + arr[i]);
                return;
            }

            map.put(arr[i], i); // else we will put it into map 
        }

        System.out.println("No pair found");
    }
}
