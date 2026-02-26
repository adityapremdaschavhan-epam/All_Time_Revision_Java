package dsa_questions;

public class CheckStringRotationAnother {
    public static void main(String[] args) {
        
        String s1 = "abcd";
        String s2 = "cdab";

        // this approach fails when there are duplicate methods
//        char first = s1.charAt(0);
//        for(int i=0;i<s2.length();i++){
//            if(s2.charAt(i) == first) {
//
//            }
//        }


        // Brute forec
        if(s1.length() != s2.length()){
            System.out.println("Not rotation");
            return;
        }

        String temp = s1;

        for(int i=0;i<s1.length();i++){
            temp = temp.substring(1) + temp.charAt(0);

            if(temp.equals(s2)){
                System.out.println("Rotation");
                return;
            }
        }

        System.out.println("Not rotation");




        // Optimized 
        //  if(s1.length() != s2.length()){
        //     System.out.println("Not rotation");
        //     return;
        // }

        // String s3 = s1+s1;

        // if(s3.contains(s2))
        // {
        //     System.out.println(true);
        // }else{
        //     System.out.println(false);
        // }

    }
}
