package Stacks_Queues.Implementation;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> queue = new LinkedList<>();

    void push (int item) {
        queue.add(item);

        for (int i = 0; i < queue.size() - 1; i++)
            queue.add(queue.remove());
    }

    int pop () {
        return queue.remove();
    }

    int top() {
        if (queue.peek() == null)
            return -1;
        return queue.peek();
    }

    int size() {
        return queue.size();
    }
}
