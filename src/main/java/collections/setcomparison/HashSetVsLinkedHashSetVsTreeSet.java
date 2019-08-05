package collections.setcomparison;

import model.Order;

import java.util.*;

public class HashSetVsLinkedHashSetVsTreeSet {
    public static void main(String... main){
        HashSet<String> fruitsStore = new HashSet<String>();
        LinkedHashSet<String> fruitMarket = new LinkedHashSet<String>();
        TreeSet<String> fruitBuzz = new TreeSet<String>();



        for(String fruit: Arrays.asList("mango", "apple", "banana")){
            fruitsStore.add(fruit);
            fruitMarket.add(fruit);
            fruitBuzz.add(fruit);
        }

        //no ordering in HashSet – elements stored in random order
        System.out.println("Ordering in HashSet :" + fruitsStore);

        //insertion order or elements – LinkedHashSet storeds elements as insertion
        System.out.println("Order of element in LinkedHashSet :" + fruitMarket);

        //should be sorted order – TreeSet stores element in sorted order
        System.out.println("Order of objects in TreeSet :" + fruitBuzz);

    }
}
