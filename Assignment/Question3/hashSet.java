package Assignment.Question3;
import java.util.*;
public class hashSet {
    public static void main(String[] args) {
        HashSet<String> cars = new HashSet<>();

        cars.add("Mustang");
        cars.add("BMW");
        cars.add("Benz");
        cars.add("Audi");

        // System.out.println(cars); // Printing HashSet elem.

        // Printing Element using normal for each loop
        for(String car : cars){
            System.out.println(car);
        }

        System.out.println("\n");
        System.out.println("Printing Element Using Iterator");
        System.out.println("\n");

        //Printing element using Iteratr
        Iterator<String> I1 = cars.iterator();

        while(I1.hasNext()){
            System.out.println(I1.next());
        }
    }
}
