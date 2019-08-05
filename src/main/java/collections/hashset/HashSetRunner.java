package collections.hashset;

import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetRunner {
    public static void main(String... args){
        Set<Integer> integerSet = new LinkedHashSet<>();
        integerSet.add(3);
        integerSet.add(4);
        integerSet.add(2);
        integerSet.add(1);
        System.out.println("Set size: " + integerSet.size());
        System.out.println("The HashSet keeps the order of insertion " + integerSet);


    }
}
