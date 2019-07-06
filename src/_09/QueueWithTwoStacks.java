package _09;

import java.util.Stack;

public class QueueWithTwoStacks {
  /**
   * 用两个栈，实现队列的从队尾插入元素 offer() 和从队头抛出元素 poll()
   *
   * 使用两个栈，in 负责插入，out 负责弹出。
   * 如果 out 不为空，直接弹出。
   * 如果 out 为空，将 in 的元素依次弹出并存放到 out 中，之后对 out 进行弹出操作。
   */
  static class MyQueue<T> {
    private Stack<T> in = new Stack<>();
    private Stack<T> out = new Stack<>();

    public void offer(T data) {
      in.push(data);
    }

    public T poll() {
      if (out.empty()) {
        while (!in.empty()) {
          out.push(in.pop());
        }
      }
      if (!out.empty()) {
        return out.pop();
      }
      return null;
    }
  }

  public static void main(String[] args) {
    MyQueue<Integer> myQueue = new MyQueue<>();
    System.out.println(myQueue.poll());
    myQueue.offer(1);
    myQueue.offer(2);
    myQueue.offer(3);
    System.out.println(myQueue.poll());
    System.out.println(myQueue.poll());
    myQueue.offer(4);
    System.out.println(myQueue.poll());
    System.out.println(myQueue.poll());
    System.out.println(myQueue.poll());
  }
}
