package _06;

import java.util.Stack;

import structure.ListNode;

public class PrintListInReversedOrder {

  public static void printReversinglyRecursively(ListNode<Integer> node) {
    if (node == null) {
      return;
    }
    printReversinglyIteratively(node.next);
    System.out.println(node.val);
  }

  public static void printReversinglyIteratively(ListNode<Integer> node) {
    Stack<Integer> stack = new Stack<>();
    while (node != null) {
      stack.push(node.val);
      node = node.next;
    }
    while (!stack.empty()) {
      System.out.println(stack.pop());
    }
  }

  public static void main(String[] args) {
    ListNode<Integer> root = new ListNode<Integer>(1);
    root.next = new ListNode<Integer>(2);
    root.next.next = new ListNode<Integer>(3);

    printReversinglyRecursively(root);
    printReversinglyIteratively(root);
  }

}