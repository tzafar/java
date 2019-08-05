package collections.TreeSet;

import model.Order;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetRunner {
    public static void main(String... args){
        Comparator<Order> comparator =  (d, s) -> Integer.compare(d.getId(),s.getId());
        TreeSet<Order> fruitBazz = new TreeSet<>(comparator);
        Order o1 = new Order();
        o1.setId(22);

        fruitBazz.add(o1);

        Order o2 = new Order();
        o2.setId(11);

        fruitBazz.add(o2);

        System.out.println("TreeSet sorts elements on insertion based on comparator to you give it: " + fruitBazz.first().getId() + "  " + fruitBazz.last().getId());
    }
}
