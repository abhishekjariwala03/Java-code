package Assignment.Question3;
import java.util.*;
public class treeSet {
    public static void main(String[] args) {
        TreeSet<Integer> num = new TreeSet<>(); // By default accending Order

        num.add(20);
        num.add(50);
        num.add(10);
        num.add(5);

        for(int e : num){
            System.out.println(e);
        }

        System.out.println("Enter Number To Check it is in TreeSet or Not : ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if(num.contains(input)){
            System.out.println("Yes");
        }else{
            System.out.println("False");
        }

        sc.close(); // Closed sc for not Resource leak
    }
}
