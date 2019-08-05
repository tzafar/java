package collections.treemap;

import model.Order;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapRunner {
    public static void main(String... args){
        //items are sorted on insertion (by key) if the key is a custom object then give it a comparator like this:
        //Map<Order, String> map1 = new TreeMap<>((a,b)-> a.getId() > b.getId() ? a.getId() : b.getId());
        Map<Integer, String> map = new TreeMap<>();
        map.put(4,"Toseef");
        map.put(3,"Mirza");
        map.put(13,"Mirza");
        System.out.println(map);
    }
}
