package stack;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        if ( s.isEmpty() ) return true;
        char[] parenthesis = s.toCharArray();
        if ( parenthesis.length % 2 == 1 ) return false;
        Stack<Character> parr = new Stack<>();

        for ( Character item : parenthesis ) {

            if ( item == '(' ) {
                parr.push(')');
            } else if ( item == '{' ) {
                parr.push('}');
            } else if ( item == '[' ) {
                parr.push(']');
            } else if ( parr.isEmpty() || parr.pop() != item ) {
                return false;
            }
        }

        return parr.isEmpty();
    }
}
