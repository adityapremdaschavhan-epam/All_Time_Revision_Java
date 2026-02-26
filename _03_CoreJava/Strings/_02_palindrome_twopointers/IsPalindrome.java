package Strings._02_palindrome_twopointers;

public class IsPalindrome {
    static boolean isPalindrome(String s){
        String s1 = "Madam";
        s= s.toLowerCase();

        // brute
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        System.out.println("Using string builder " + s.equals(sb.toString()));

        // better
        int l=0;int r=s.length()-1;
        while(l<=r) {
            if(s.charAt(l++) != s.charAt(r--)) System.out.println(false);
        }
        return true;
    }

//    static void main() {
//        isPlaindrome();
//    }
}
