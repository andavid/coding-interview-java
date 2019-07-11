package _52;

import structure.ListNode;

public class FirstCommonNodesInLists {
  public static ListNode<Integer> findFirstCommonNode(ListNode<Integer> head1, ListNode<Integer> head2) {
    ListNode<Integer> node1 = head1;
    ListNode<Integer> node2 = head2;
    int size1 = 0, size2 = 0;

    while (node1 != null) {
      node1 = node1.next;
      size1++;
    }

    while (node2 != null) {
      node2 = node2.next;
      size2++;
    }

    node1 = head1;
    node2 = head2;

    while (size1 > size2) {
      node1 = node1.next;
      size1--;
    }

    while (size2 > size1) {
      node2 = node2.next;
      size2--;
    }

    while (node1 != null) {
      if (node1 == node2) {
        break;
      } else {
        node1 = node1.next;
        node2 = node2.next;
      }
    }

    return node1;
  }

  public static void main(String[] args) {
    // 1->2->3->6->7
    //    4->5↗
    ListNode<Integer> node1 = new ListNode<>(1);
    ListNode<Integer> node2 = new ListNode<>(2);
    ListNode<Integer> node3 = new ListNode<>(3);
    ListNode<Integer> node4 = new ListNode<>(4);
    ListNode<Integer> node5 = new ListNode<>(5);
    ListNode<Integer> node6 = new ListNode<>(6);
    ListNode<Integer> node7 = new ListNode<>(7);
    node1.next = node2;
    node2.next = node3;
    node3.next = node6;
    node4.next = node5;
    node5.next = node6;
    node6.next = node7;
    ListNode<Integer> commonNode = findFirstCommonNode(node1, node4);
    System.out.println(commonNode.val);
  }
}
