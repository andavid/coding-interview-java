package _18;

import structure.ListNode;

public class DeleteNodeInList {

  public static ListNode<Integer> deleteNode(ListNode<Integer> head, ListNode<Integer> node) {
    if (head == null) {
      return null;
    }

    if (node == head) {
      ListNode<Integer> next = head.next;
      head = null;
      return next;
    }

    if (node.next != null) {
      ListNode<Integer> next = node.next;
      node.val = next.val;
      node.next = next.next;
      next = null;
    } else {
      ListNode<Integer> p = head;
      while (p.next != node) {
        p = p.next;
      }
      p.next = null;
      node = null;
    }

    return head;
  }

  public static void main(String[] args) {
    ListNode<Integer> head = new ListNode<Integer>(1);
    ListNode<Integer> node2 = new ListNode<Integer>(2);
    ListNode<Integer> node3 = new ListNode<Integer>(3);
    head.next = node2;
    node2.next = node3;

    System.out.println(head);

    head = deleteNode(head, head);
    System.out.println(head);

    head = deleteNode(head, node2);
    System.out.println(head);

    head = deleteNode(head, node3);
    System.out.println(head);

  }

}