package dsa_questions;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1,5,7,-1,5};
        int sum = 6;

        // map(num,freq)
        Map<Integer,Integer> map = new HashMap<>();
        int count =0;

        for(int num : arr)
        {
            int need = sum-num;

            if(map.containsKey(need))
            {
                count+=map.get(need);
            }
            map.put(num,map.getOrDefault(map, 0)+1);
        }
        System.out.println("Pairs ="+count);

    }
}
