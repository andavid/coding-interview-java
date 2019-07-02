package _22;

import structure.ListNode;

public class KthNodeFromEnd {
  public static ListNode<Integer> findKthToTail(ListNode<Integer> head, int k) {
    if (head == null || k <= 0) {
      return null;
    }

    ListNode<Integer> dummy = new ListNode<Integer>(0);
    dummy.next = head;
    ListNode<Integer> slow = dummy;
    ListNode<Integer> fast = dummy;

    for (int i = 0; fast != null && i < k; i++) {
      fast = fast.next;
    }

    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }

    return (slow == dummy) ? null : slow;
  }

  public static void main(String[] args) {
    ListNode<Integer> head = new ListNode<>(1);
    head.next= new ListNode<>(2);
    head.next.next = new ListNode<>(3);
    System.out.println(findKthToTail(head,1).val);
    System.out.println(findKthToTail(head,2).val);
    System.out.println(findKthToTail(head,3).val);
    System.out.println(findKthToTail(head,4));
  }
}