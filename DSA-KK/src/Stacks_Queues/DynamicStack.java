package Stacks_Queues;

public class DynamicStack extends Stack {
    public DynamicStack() {
        super(); // It will call Stack()
    }

    public DynamicStack(int size) {
        super(size); // It will call Stack(size)
    }

    @Override
    public boolean push(int item) {
        if (this.isFull()) {
            // Double the Array Size
            int[] temp = new int[data.length * 2];

            // COpy all previous items in new data
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }

            data = temp;
            System.out.println("Size increased!");
        }

        // At this point, we know array is not full
        // Insert Item
        return super.push(item);
    }

    public static void main(String[] args) throws StackException {
        DynamicStack stack = new DynamicStack(5);
        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(89);
        stack.push(2);
        stack.push(89);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
