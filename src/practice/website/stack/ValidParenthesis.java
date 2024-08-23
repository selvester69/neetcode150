package practice.website.stack;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                st.push(c);
            } else {
                if (!st.isEmpty() && ((st.peek() == '(' && c == ')') || (st.peek() == '{' && c == '}')
                        || (st.peek() == '[' && c == ']'))) {
                    st.pop();
                } else {
                    st.push(c);
                }
            }

        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        ValidParenthesis obj = new ValidParenthesis();
        System.out.println("(]) " + obj.isValid("(])"));
        System.out.println("([{}]) " + obj.isValid("([{}])"));
        System.out.println("[(]) " + obj.isValid("[(])"));
    }

}
