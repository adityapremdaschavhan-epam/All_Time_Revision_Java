package dsa_questions;

import java.util.HashMap;

public class StringBasic {
    public static void main(String[] args) {
        
        String str ="Ved Jaiswal";
        // Printing the string
        for(int i=0;i<str.length();i++)
        {
            System.out.print(str.charAt(i));
        }

        System.out.println("-----------------------");

        //Count Vowels 
        int cnt =0;
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U' )
            {
                cnt++;
            }
        }
        System.out.println("The count of vowels in string are: "+cnt);
        System.out.println("-----------------------");

        // Reverse a string 
        StringBuilder sb = new StringBuilder(str);
        String reversed = sb.reverse().toString();
        System.out.println(reversed);

        System.out.println("Using two pointer");
        char arr[] = str.toCharArray();
        int i=0;
        int j = arr.length-1;
        while(i<j)
        {
            char temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        for(char s: arr)
        {
            System.out.print(s);
        }
        System.out.println();

        System.out.println("-----------------------");

        // Character frequncy 
        String s = "Hello";

        HashMap<Character,Integer> map = new HashMap<>();
        for(int m=0;m<s.length();m++)
        {
            char ch = s.charAt(m);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        System.out.println(map);


        





    }
}
