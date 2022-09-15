package Linked_List;

public class L2_DoublyDemo {
    public static void main(String[] args) {
        Doubly_LL list = new Doubly_LL();

        list.insertFirst(3);
        list.insertFirst(5);
        list.insertFirst(9);
        list.insertFirst(8);
        list.insertFirst(4);

        list.insertLast(99);
        list.insertFirst(3);

        list.insert(20, 3);

        list.display();

//        System.out.println(list.deleteFirst());
//
//        list.display();
//
//        System.out.println(list.deleteLast());
//
//        list.display();
//
//        System.out.println(list.delete(3));
//
//        list.display();
    }
}
