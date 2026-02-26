package Strings._03_ValidParenthesis;

import java.util.Stack;

public class ValidSpecialParenthesis {
    public static boolean ValidSpecialParenthesisStack (){
        String s = "((*(*)))";

        int n = s.length();
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') open.push(i);
            else if (c == '*') star.push(i);
            else {
                if (!open.isEmpty()) open.pop();
                else if (!star.isEmpty()) star.pop();
                else return false;
            }
        }

        // String s = "*((*((()))";  edge case
        while (!open.isEmpty() && !star.isEmpty()) {
            if (open.pop() > star.pop()) return false;
        }
        return open.isEmpty();
    }

    public static boolean ValidSpecialParenthesisHighLow(){
        String s = "*()()()";
        int n = s.length();
        int h=0;
        int l=0;

        for(int i=0;i<n;i++){
            if(s.charAt(i) == '('){
                l++;
                h++;
            }
            else if(s.charAt(i) == ')'){
                l--;
                h--;
            }
            else{
                l--;
                h++;
            }
            if(h<0)  return false;
            if(l<0) l=0;
        }
        return true;
    }

    static void main() {
        System.out.println(ValidSpecialParenthesisStack());
        System.out.println(ValidSpecialParenthesisHighLow());
    }
}
