package stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] values = {"1", "2", "+", "3", "*", "4", "-"};
        evalRPN(values);
    }

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for ( String token : tokens ) {

            switch ( token ) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "-" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                }
                case "/" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

}

//To convert an infix expression to postfix notation in Java, you can use a stack
// to help with operator precedence and parenthesis handling. Here’s a method that
// converts an infix expression to postfix:


class InfixToPostfix {

    // Method to return precedence of operators
    public static int precedence(char op) {
        switch ( op ) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    // Method to convert infix to postfix
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        // Traverse each character in the infix expression
        for ( int i = 0; i < infix.length(); i++ ) {
            System.out.println(postfix);
            char c = infix.charAt(i);

            // If the character is an operand (numbers, variables)
            if ( Character.isLetterOrDigit(c) ) {
                postfix.append(c);
            }
            // If the character is an opening parenthesis
            else if ( c == '(' ) {
                stack.push(c);
            }
            // If the character is a closing parenthesis
            else if ( c == ')' ) {
                while ( !stack.isEmpty() && stack.peek() != '(' ) {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Pop the '('
            }
            // If the character is an operator
            else if ( c == '+' || c == '-' || c == '*' || c == '/' || c == '^' ) {
                while ( !stack.isEmpty() && precedence(stack.peek()) >= precedence(c) ) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        // Pop all the remaining operators in the stack
        while ( !stack.isEmpty() ) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infix = "a+(b*c-(d/e^f)*g)*h";
        System.out.println("Infix: " + infix);
        String postfix = infixToPostfix(infix);
        System.out.println("Postfix: " + postfix);
    }
}

//Explanation:
//
//        1.	Precedence function: Determines the precedence of operators to decide which operator to process first.
//        2.	Infix to Postfix conversion: We iterate through each character in the infix expression:
//        •	If it’s an operand (a variable or number), we directly append it to the result.
//        •	If it’s an opening parenthesis (, we push it onto the stack.
//        •	If it’s a closing parenthesis ), we pop operators from the stack until we encounter an opening parenthesis, then discard the parentheses.
//        •	For operators, we pop operators from the stack that have higher or equal precedence than the current one, then push the current operator onto the stack.
//        3.	After processing the entire expression, any remaining operators in the stack are popped to form the final postfix expression.
//
//Example:
//
//For the infix expression "a+(b*c-(d/e^f)*g)*h", the output postfix expression would be "abc*def^/g*-h*+".