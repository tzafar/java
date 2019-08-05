package collections.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapRunner {
    public static void main(String... args){
        Map<Integer, String> map = new LinkedHashMap<>(); //order of element insertion is guaranteed.
        map.put(1,"Toseef");
        map.put(0,"Mirza");
        System.out.println(map);
    }
}
