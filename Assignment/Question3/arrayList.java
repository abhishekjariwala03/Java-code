package Assignment.Question3;
import java.util.*;

public class arrayList {
    public static void main(String args[]){
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();

        // Adding values in a1 arraylist

        a1.add(5);
        a1.add(10);
        a1.add(50);
        a1.add(55);

        // Adding values in a2 arraylist

        a2.add(200);
        a2.add(300);
        a2.add(400);
        a2.add(500);

        a1.addAll(a2); // Adding a2 element to a1

        // Print all element of the array
        for(int i =0; i<a1.size();i++){
            System.out.println(a1.get(i));
        }

        a1.remove(0);
        System.out.println("After Removing element");
         for(int i =0; i<a1.size();i++){
            System.out.println(a1.get(i));
        }

    }
}
