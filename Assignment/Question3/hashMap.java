package Assignment.Question3;
import java.util.*;
public class hashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> data = new HashMap<>();

        data.put("Abhi", 21);
        data.put("xyz", 20);
        data.put("abc", 21);
        data.put("abc", 21); // Never takes dublicate values

        System.out.println(data);
        System.out.println(data.isEmpty()); // Check that HashMap is empty or not !
        System.out.println();

        int age = data.get("Abhi");
        System.out.println("Age : " + age);
        System.out.println();

        data.put("Abhi", 20); // Updating Age 
        System.out.println("Data after Updating age : " + data);
        System.out.println();

        data.remove("Abhi"); // Deteting Elem
        System.out.println("Data after Deletion : " + data);
        System.err.println();


    }
}
