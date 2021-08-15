package queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();  // Queue의 구현체로 LinkedList 사용. LinkedList에는 Queue 관련 기능이 구현되어 있음
        System.out.println(queue.isEmpty() + "/" + queue.size());

        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.offer("D");
        queue.offer("E");

        System.out.println(queue.isEmpty() + "/" + queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.isEmpty() + "/" + queue.size());

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.isEmpty() + "/" + queue.size());
        System.out.println(queue.poll());
    }
}
