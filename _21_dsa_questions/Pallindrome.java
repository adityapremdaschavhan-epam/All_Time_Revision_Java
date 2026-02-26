package dsa_questions;

public class Pallindrome
{
    public static void main(String[] args) {
        String s="madam";

        //  1st approach 
        StringBuilder sb = new StringBuilder(s);
        String res = sb.reverse().toString();

        if(s.equals(res))
        {
            System.out.println("Pallindrome");
        }
        else{
            System.out.println("Not");
        }


        // 2nd Approach 

        int i = 0;
        int j = s.length()-1;
        boolean isPall = true;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                
                isPall=false;
                break;
            }
            else{
                isPall=true;
            }
            i++;
            j--;
        }

        if(isPall)
        {
            System.out.println("Pallindrome");
        }
        else{
            System.out.println("Not pallindrome");
        }

    }
}