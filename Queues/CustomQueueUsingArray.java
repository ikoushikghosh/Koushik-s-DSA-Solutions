package org.koushik.dsa.queues;

import java.util.Arrays;

/**
 * A custom implementation of a queue using an array.
 * This implementation supports basic queue operations: enqueue, dequeue, and peek,
 * with a fixed capacity defined at the time of instantiation.
 * The queue follows the First-In-First-Out (FIFO) principle.
 *
 * The following operations are supported:
 *
 * - {@link #enqueue(int)}: Adds an element to the back of the queue.
 *   If the queue is full, it will not add the element and print an error message.
 *
 * - {@link #dequeue()}: Removes an element from the front of the queue.
 *   If the queue is empty, it will return -1 and print an error message.
 *
 * - {@link #peek()}: Returns the element at the front of the queue without removing it.
 *   If the queue is empty, it will return -1 and print an error message.
 *
 * - {@link #printQueue()}: Prints the current state of the queue, including its size and elements.
 *
 * The queue uses a circular array for storage, allowing efficient use of the allocated space.
 *
 * @author Koushik
 */
public class CustomQueueUsingArray {
    private int size;

    private final int[] array;

    private int frontIdx;

    private int backIdx;

    public CustomQueueUsingArray(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
        this.frontIdx = 0;
        this.backIdx = 0;
    }

    public void enqueue(int item) {
        if(size == array.length) {
            System.out.printf("Queue is full, reached max array size: %d%n", array.length);
            return;
        }
        if(size < array.length && backIdx >= array.length) {
            backIdx = backIdx % array.length;
        }
        array[backIdx++] = item;
        size++;
    } // TC: O(1) & SC: O(1)

    public int dequeue() {
        if(size == 0) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            size--;
            if(frontIdx >= array.length) {
                frontIdx = frontIdx % array.length;
            }
            int value = array[frontIdx];
            array[frontIdx++] = 0;
            return value;
        }
    } // TC: O(1) & SC: O(1)

    public int peek() {
        if(size == 0) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            if(frontIdx >= array.length) {
                frontIdx = frontIdx % array.length;
            }
            return array[frontIdx];
        }
    } // TC: O(1) & SC: O(1)

    public void printQueue() {
        System.out.printf("The queue of size = %d, where frontIdx: %d, backIdx: %d, is: %s%n", size, frontIdx, backIdx, Arrays.toString(array));
    }
}
