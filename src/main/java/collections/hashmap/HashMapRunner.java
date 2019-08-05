package collections.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapRunner {
    public static void main(String... args){
        Map<Integer, String> map = new HashMap<>(); // order is not guaranteed like LinkedHashMap
        map.put(1,"Toseef");
        map.put(0,"Mirza");
        System.out.println(map);
    }
}
