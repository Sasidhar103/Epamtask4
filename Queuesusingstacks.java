package in.sasi;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Queuesusingstacks{
    public static class Node {
        int data;
        Node prev;
        public Node(int data, Node prev) {
            this.data = data;
            this.prev = prev;
        }
    }
    public static class Stack {
        Node head;
        public Stack() {
            head = null;
        }
        
        public void push(int data) {
            Node newHead = new Node(data, head);
            head = newHead;
        }
        
        public int pop() {
            int data = head.data;
            head = head.prev;
            return data;
        }
        
        public int get() {
            return head.data;
        }
        
        public boolean empty() {
            return head == null;
        }
    }
    
    public static class QueueAsStack {
        Stack s1, s2;
        public QueueAsStack() {
            s1 = new Stack();
            s2 = new Stack();
        }
        
        public void enqueue(int data) {
            s1.push(data);
        }
        
        private void transferIfNeeded() {
            if (s2.empty()) {
                while (!s1.empty()) { // transfer everyhting in s1 over to s2
                    s2.push(s1.pop());
                }
            }
        }
        public int dequeue() {
            transferIfNeeded();
            // error if s2 is empty...
            return s2.pop();
        }
        
        public int peek() {
            transferIfNeeded();
            int value = s2.pop();
            s2.push(value);
            return value;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nOps = scanner.nextInt();
        QueueAsStack q = new QueueAsStack();
        for (int i = 0; i < nOps; i++) {
            int op = scanner.nextInt();
            if (op == 1) {
                int val = scanner.nextInt();
                q.enqueue(val);
            } else if (op == 2) {
                q.dequeue();
            } else {
                System.out.println(q.peek());
            }
        }
    }
}