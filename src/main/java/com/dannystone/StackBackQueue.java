package com.dannystone;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: daniel
 * @creed: keep it simple and stupid !
 * @Time: 2019/11/12 10:04 PM
 */
public class StackBackQueue {
    public static class MyQueue {
        Stack<Integer> stack, reverseStack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new Stack<>();
            reverseStack = new Stack<>();

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            while (stack.empty() && !reverseStack.empty()) {
                Integer pop = reverseStack.pop();
                stack.push(pop);
            }
            stack.push(x);

        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {

            while (!stack.empty()) {
                Integer pop = stack.pop();
                reverseStack.push(pop);
            }
            return reverseStack.pop();

        }

        /**
         * Get the front element.
         */
        public int peek() {
            while (!stack.empty()) {
                Integer pop = stack.pop();
                reverseStack.push(pop);
            }
            return reverseStack.peek();

        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.empty() && reverseStack.empty();
        }
    }
    public static void main(String[] args){
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.peek();
        myQueue.pop();

    }

}
