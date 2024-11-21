package stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(0);
        minStack.push(2);
        minStack.push(4);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }

    public void push(int val) {

        stack.push(val);

        if ( minStack.isEmpty() || val <= minStack.peek() ) {
            minStack.push(val);
        }


    }

    public void pop() {
        if ( stack.isEmpty() ) return;

        if ( stack.peek().equals(minStack.peek()) ) {
            minStack.pop();
        }
        stack.pop();


    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
