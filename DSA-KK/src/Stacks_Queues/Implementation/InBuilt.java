package Stacks_Queues.Implementation;

import java.util.*;
import java.util.Queue;
import java.util.Stack;

public class InBuilt {
    public static void main(String[] args) {
        // Stack
        System.out.println("The Stack is: ");
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(89);
        stack.push(4);
        stack.push(100);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        /*
          An extra pop() will throw an EmptyStackException
          System.out.println(stack.pop());
        */

        // Queue
        System.out.println("\nThe Queue is: ");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(6);
        queue.add(10);
        queue.add(90);
        queue.add(74);
        queue.add(40);
        queue.add(3);

        System.out.println("The front element is: " + queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        /*
          An extra remove() will throw an NoSuchElementException
          System.out.println(queue.remove());
        */

        // Deque
        System.out.println("\nThe Deque is: ");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(6);
        deque.add(10);
        deque.add(90);
        deque.add(74);
        deque.add(40);
        deque.add(3);

        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.pop());
        System.out.println(deque.poll());
    }
}