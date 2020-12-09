package com.collection;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Shuaihang Xue
 * @date 2020/7/31
 */
public class QueueTest {

    public static void main(String[] args) {
//        useQueuePoll();
//        useQueuePeek();
//        usePriorityQueue();
//        useDeQueue();
        useStack();
    }

    static void useQueuePoll() {
        Queue<String> queue = getSimpleQueue();
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    static void useQueuePeek() {
        Queue<String> queue = getSimpleQueue();
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
        System.out.println(queue.peek());
    }

    /**
     * 队列中的对象要实现Comparable接口用来排序
     */
    static void usePriorityQueue() {
        Queue<String> queue = getSimplePriorityQueue();
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    static void useDeQueue() {
        Deque<String> deque = getNewDeQue();
        deque.offerLast("A");
        deque.offerLast("B");
        deque.offerFirst("C");
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollFirst());
    }

    /**
     * 当我们把Deque作为Stack使用时，注意只调用push()/pop()/peek()方法，不要调用addFirst()/removeFirst()/peekFirst()方法，这样代码更加清晰。
     */
    static void useStack() {
        Deque<String> stack = getNewStack();
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    static Queue<String> getSimpleQueue() {
        Queue<String> queue = new LinkedList<>();
        queue.add("apple");
        queue.add("pear");
        queue.add("banana");
        return queue;
    }

    static Queue<String> getSimplePriorityQueue() {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("apple");
        queue.add("pear");
        queue.add("banana");
        return queue;
    }

    static Deque<String> getNewDeQue() {
        Deque<String> deque = new LinkedList<>();
        return deque;
    }

    static Deque<String> getNewStack() {
        Deque<String> stack = new LinkedList<>();
        stack.push("apple");
        stack.push("pear");
        stack.push("banana");
        return stack;
    }
}
