package _30;

import java.util.Stack;

public class MinInStack {
  static class MinStack {
    private int min;
    private Stack<Integer> stack;

    public MinStack() {
      min = Integer.MAX_VALUE;
      stack = new Stack<>();
    }

    public void push(Integer data) {
      if (data <= min) {
        stack.push(min);
        min = data;
      }
      stack.push(data);
    }

    public int pop() {
      int ret = stack.pop();
      if (ret == min) {
        min = stack.pop();
      }
      return ret;
    }

    public int min() {
      return min;
    }
  }

  public static void main(String[] args) {
    MinStack stack = new MinStack();
    stack.push(3);
    stack.push(4);
    stack.push(2);
    stack.push(1);
    System.out.println(stack.min());
    stack.pop();
    System.out.println(stack.min());
    stack.pop();
    System.out.println(stack.min());
    stack.pop();
    System.out.println(stack.min());
    stack.pop();
    System.out.println(stack.min());
  }
}
