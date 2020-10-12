package collections;

import java.util.PriorityQueue;

public class Queue_In_Action_9 {
    public static void main(String args[]){
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.offer("first");
        pq.offer("second");
        pq.offer("third");
        System.out.printf("%s ", pq);
        System.out.println();

        System.out.printf("%s ", pq.peek());
        System.out.println();

        pq.poll();
        System.out.printf("%s ", pq);





    }
}
