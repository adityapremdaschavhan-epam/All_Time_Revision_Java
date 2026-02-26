package Strings._03_ValidParenthesis;

import java.util.Stack;

public class ValidMutilpleParenthisis {

    public static boolean ValidParenthesisStack() {
        String s = "{([])}";
        int n = s.length();

        Stack<Character> st = new Stack<>();

//        for (char c : s.toCharArray()) {
//
//            if (c == '(' || c == '{' || c == '[') {
//                stack.push(c);
//            } else {
//
//                if (stack.isEmpty()) return false;
//
//                char top = stack.pop();
//
//                if ((c == ')' && top != '(') ||
//                        (c == '}' && top != '{') ||
//                        (c == ']' && top != '[')) {
//                    return false;
//                }
//            }
//        }
//        return stack.isEmpty();
        // logic is like whenever we are getting opening parenthesis
        // store its corresponding closing parenthesis
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='(') st.push(')');
            else if(s.charAt(i)=='{') st.push('}');
            else if(s.charAt(i)=='[') st.push(']');
            else{
                if(st.empty() || st.pop() != s.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }

    static void main() {
        ValidParenthesisStack();
    }
}
