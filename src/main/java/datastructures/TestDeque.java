package datastructures;

import java.util.ArrayDeque;
import java.util.Deque;

public class TestDeque {
    public static void main(String... args){
        //Deque is a double ended queue
        Deque<String> deque = new ArrayDeque<>();
        deque.add("First Element");
        deque.add("Second element");
        System.out.println(deque.peek());
        deque.addFirst("Third Element");
        System.out.println(deque.peek());
    }
}
