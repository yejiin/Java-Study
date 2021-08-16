package linkedlist;

public class SinglyLinkedListTest {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        list.addLastNode("A");
        System.out.println(list.getLastNode());
        list.printList();

        list.addLastNode("B");
        list.printList();

        list.addFirstNode("C");
        list.printList();

        list.insertAfterNode(list.getNode("C"), "D");
        list.printList();

        Node target = list.getNode("B");
        System.out.println(list.getPreviousNode(target));

        list.deleteNode("D");
        list.printList();

        list.deleteNode("C");
        list.printList();

        list.deleteNode("B");
        list.printList();

        list.deleteNode("A");
        list.printList();
    }
}
