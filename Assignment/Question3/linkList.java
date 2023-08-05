package Assignment.Question3;
import java.util.*;

public class linkList {
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>();

        l1.add(20);
        l1.add(60);
        l1.add(40);
        l1.add(50);
        l1.add(10);
        l1.add(30);
        l1.addLast(100); // Add Element in last of linkedlist
        l1.addFirst(1); // Add Element To First 


        for(int i = 0; i<l1.size();i++){
            System.out.println(l1.get(i)); // Printing Elem.
        }
    }
}
