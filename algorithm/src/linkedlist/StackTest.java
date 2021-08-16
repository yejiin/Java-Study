package linkedlist;

public class StackTest {

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(stack.isEmpty());
        stack.push("A");
        System.out.println(stack);
        stack.push("B");
        System.out.println(stack);
        stack.push("C");
        System.out.println(stack);
        System.out.println(stack.isEmpty());

        System.out.println(stack.peek());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
