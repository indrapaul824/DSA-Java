package Linked_List;

public class L3_CircularDemo {
    public static void main(String[] args) {
        Circular_LL list = new Circular_LL();

        list.insert(3);
        list.insert(5);
        list.insert(9);
        list.insert(8);
        list.insert(4);

        list.display();

        list.delete(9);

        list.display();

        list.delete(3);

        list.display();
    }
}
