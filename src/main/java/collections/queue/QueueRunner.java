package collections.queue;

import model.Order;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueRunner {
    public static void main(String... args){
        // has functions of a queue but items are in placed in natural ordered (Not in order they are inserted in)
        // its similar to TreeSet which take a Comparator when using your own objects.
        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("One");
        priorityQueue.add("Two");
        priorityQueue.add("Three");
        System.out.println(priorityQueue);
        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.remove());
        }
    }
}
