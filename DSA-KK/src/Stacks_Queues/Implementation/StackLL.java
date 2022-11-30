package Stacks_Queues.Implementation;

public class StackLL {

    private StackNode top;
    int size;
    private static class StackNode {
        private int val;
        private StackNode next;

        StackNode(int val) {
            this.val = val;
        }
    }

    StackLL () {
        this.top = null;
        this.size = 0;
    }

    public void push(int item) {
        StackNode temp = new StackNode(item);
        temp.next = top;
        top = temp;
        System.out.printf("Element %d pushed to stack\n", item);
        size++;
    }

    public int pop() {
        if (top == null)
            return -1;
        int popped = top.val;
        top = top.next;
        return popped;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        StackNode temp = top;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        StackLL list = new StackLL();
        list.push(2);
        list.push(34);
        list.push(45);
        list.push(12);
        list.push(89);

        list.display();

        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());

        list.display();
    }
}
