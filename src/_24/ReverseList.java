package _24;

import structure.ListNode;

public class ReverseList {
  public static ListNode<Integer> reverseList(ListNode<Integer> head) {
    ListNode<Integer> pre = null;
    ListNode<Integer> cur = head;

    while (cur != null) {
      ListNode<Integer> post = cur.next;
      cur.next = pre;
      pre = cur;
      cur = post;
    }

    return pre;
  }

  public static ListNode<Integer> reverseListRecursively(ListNode<Integer> head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode<Integer> node = reverseListRecursively(head.next);
    head.next.next = head;
    head.next = null;
    return node;
  }

  public static void main(String[] args) {
    ListNode<Integer> head = new ListNode<>(1);
    head.next= new ListNode<>(2);
    head.next.next = new ListNode<>(3);
    System.out.println(head);

    head = reverseList(head);
    System.out.println(head);

    head = reverseListRecursively(head);
    System.out.println(head);
  }
}
