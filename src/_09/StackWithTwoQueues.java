package _09;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueues {
  /**
   * 用两个队列，实现栈的从队尾插入元素 push() 和从队尾抛出元素 pop()
   *
   * 选一个不为空的队列进行插入，初始都为空，随便选一个。
   * 弹出时将不为空的队列元素（除最后一个元素）依次取出放到另一个队列中，将最后那一个元素取出返回。
   */
  static class MyStack<T> {
    private Queue<T> queue1 = new LinkedList<>();
    private Queue<T> queue2 = new LinkedList<>();

    public void push(T data) {
      if (!queue2.isEmpty()) {
        queue2.offer(data);
      } else {
        queue1.offer(data);
      }
    }

    public T pop() {
      if (!queue2.isEmpty()) {
        int size = queue2.size();
        for (int i = 0; i < size - 1; i++) {
          queue1.offer(queue2.poll());
        }
        return queue2.poll();
      } else if (!queue1.isEmpty()) {
        int size = queue1.size();
        for (int i = 0; i < size - 1; i++) {
          queue2.offer(queue1.poll());
        }
        return queue1.poll();
      }
      return null;
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
