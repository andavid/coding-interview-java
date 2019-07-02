package _25;

import structure.ListNode;

public class MergeSortedLists {
  public static ListNode<Integer> merge(ListNode<Integer> head1, ListNode<Integer> head2) {
    if (head1 == null) {
      return head2;
    }

    if (head2 == null) {
      return head1;
    }

    if (head1.val < head2.val) {
      head1.next = merge(head1.next, head2);
      return head1;
    } else {
      head2.next = merge(head1, head2.next);
      return head2;
    }
  }

  public static void main(String[] args) {
    ListNode<Integer> head1 = new ListNode<>(1);
    head1.next= new ListNode<>(3);
    head1.next.next = new ListNode<>(5);
    head1.next.next.next = new ListNode<>(7);

    ListNode<Integer> head2 = new ListNode<>(2);
    head2.next= new ListNode<>(4);
    head2.next.next = new ListNode<>(6);
    head2.next.next.next = new ListNode<>(8);

    System.out.println(head1);
    System.out.println(head2);

    ListNode<Integer> head = merge(head1,head2);
    System.out.println(head);
  }
}
