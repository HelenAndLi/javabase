package pers.helen.javabasic.queue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * PriorityQueue优先队列示例
 */
public class PriorityQueueDemo {

    public static void main(String[] args){
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(9);
        queue.add(3);
        queue.add(2);
        queue.add(6);
        queue.add(5);
        System.out.println("queue:" + queue);
        System.out.println("queue.size(): " + queue.size());
        System.out.println("queue.peek(): " + queue.peek());
        System.out.println("after peek(), queue.size(): " + queue.size());
        System.out.println("queue.poll(): " + queue.poll());
        System.out.println("after poll(), queue.size(): " + queue.size());
        queue.offer(1);
        System.out.println("after offer(), queue.size(): " + queue.size());
        System.out.println("queue:" + queue);
        Comparator comparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2){
                return o1 - o2;
            }
        };
        queue = new PriorityQueue<>(comparator);
        queue.add(9);
        queue.add(3);
        queue.add(2);
        queue.add(6);
        queue.add(5);
        System.out.println("after comparator, queue:" + queue);
        System.out.println();
        System.out.println("queue.poll():");
        while(!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }
}
