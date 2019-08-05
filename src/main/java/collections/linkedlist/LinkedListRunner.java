package collections.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class LinkedListRunner {
    public static void main(String...ags){
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Mirza"); // O(1)  (for ArrayList it could be up to O(n) because ArrayList uses arrays internally)
        linkedList.add("Toseef"); // O(1)
        System.out.println(linkedList);
        ((LinkedList<String>) linkedList).remove("Mirza"); //O (1) biggest benefit of LinkedList - for ArrayList its up to O(n)
        System.out.println(linkedList);
    }
}
