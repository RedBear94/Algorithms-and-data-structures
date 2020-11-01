package hw2;

import hw2.myqueue.Deque;
import hw2.myqueue.PriorityQueue;
import hw2.myqueue.Queue;
import hw2.mystack.Stack;
import hw2.mystack.StackImpl;

public class Test {

    public static void main(String[] args) {
        //testStack();
        //testQueue();
        TestDeque();
    }

    private static void testStack() {
        Stack<Integer> stack = new StackImpl<>(5);

        System.out.println("Add value 1: " + addToStack(stack, 1));
        System.out.println("Add value 2: " + addToStack(stack, 2));
        System.out.println("Add value 3: " + addToStack(stack, 3));
        System.out.println("Add value 4: " + addToStack(stack, 4));
        System.out.println("Add value 5: " + addToStack(stack, 5));
        System.out.println("Add value 6: " + addToStack(stack, 6));

        System.out.println("Stack size: " + stack.size());
        System.out.println("Stack top: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static boolean addToStack(Stack<Integer> stack, int value) {
        if (!stack.isFull()) {
            stack.push(value);
            return true;
        }
        return false;
    }

    private static void testQueue() {
//        Queue<Integer> queue = new QueueImpl<>(5);
        Queue<Integer> queue = new PriorityQueue<>(5);
        System.out.println(queue.insert(3));
        System.out.println(queue.insert(5));
        System.out.println(queue.insert(1));
        System.out.println(queue.insert(2));
        System.out.println(queue.insert(6));
        System.out.println(queue.insert(4));

        System.out.println("Queue peek: " + queue.peekHead());
        System.out.println("Queue size: " + queue.size());
        System.out.println("Queue is full: " + queue.isFull());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    private static void TestDeque() {
        Deque<Integer> deque = new Deque<>(7);
        System.out.println(deque.appendLeft(6)); // 6
        System.out.println(deque.appendLeft(5)); // 56
        System.out.println(deque.appendLeft(4)); // 456
        System.out.println(deque.appendRight(3)); // 4563
        System.out.println(deque.appendRight(2)); // 45632
        System.out.println(deque.appendRight(1)); // 456321
        System.out.println(deque.appendLeft(8)); // 8456321
        while (!deque.isEmpty()) {
            System.out.println(deque.popLeft()); // 8456321
            //System.out.println(deque.popRight()); // 1236548
        }
        System.out.println();
    }
}
