package Assignment.Question3;
import java.util.*;
public class priorityQueue {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        pq.add("Abhi");
        pq.add("Jariwala");
        pq.add("xyz");
        pq.add("abc");

        System.out.println(pq.peek()); // Peek elem at the head
        System.out.println("After Peek Elem : "+pq);

        System.out.println(pq.poll()); // Remove elem from head
        System.out.println("After Poll Elem : "+pq);

        Iterator<String> it = pq.iterator();
        System.out.println();

        while(it.hasNext()){
            System.out.println(it.next());
        }

        // System.out.println(pq);

    }
}
