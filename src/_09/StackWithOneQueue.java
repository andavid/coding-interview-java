package _09;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithOneQueue {
  static class MyStack<T> {
    private Queue<T> queue = new LinkedList<>();

    public void push(T data) {
      queue.offer(data);
      int size = queue.size();
      for (int i = 0; i < size - 1; i++) {
        queue.offer(queue.poll());
      }
    }

    public T pop() {
      if (queue.isEmpty()) {
        return null;
      }
      return queue.poll();
    }
  }

  public static void main(String[] args) {
    MyStack<Integer> myStack = new MyStack<>();
    System.out.println(myStack.pop());
    myStack.push(1);
    myStack.push(2);
    myStack.push(3);
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    myStack.push(4);
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
    System.out.println(myStack.pop());
  }
}
