package collections.set;

import java.util.HashSet;
import java.util.Set;

public class SetRunner {
    public static void main(String... args){
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(1);
        integerSet.add(1);
        integerSet.add(3);
        integerSet.add(7);
        integerSet.add(4);
        integerSet.add(2);
        integerSet.add(6);
        integerSet.add(5);
        System.out.println("Set size: " + integerSet.size());
        System.out.println("The Set doesn't keep the order of insertion " + integerSet.toString());
    }
}
