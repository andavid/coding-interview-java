package _23;

import structure.ListNode;

public class EntryNodeInListLoop {
  public static ListNode<Integer> meetingNode(ListNode<Integer> head) {
    ListNode<Integer> slow = head;
    ListNode<Integer> fast = head;
    boolean hasCycle = false;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        hasCycle = true;
        break;
      }
    }

    if (!hasCycle) {
      return null;
    }

    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }

  public static void main(String[] args) {
    // 1->2->3->4->5->6
    //       |________|
    ListNode<Integer> head = new ListNode<>(1);
    head.next= new ListNode<>(2);
    ListNode<Integer> node = new ListNode<>(3);
    head.next.next = node;
    node.next = new ListNode<>(4);
    node.next.next = new ListNode<>(5);
    node.next.next.next = new ListNode<>(6);
    node.next.next.next.next = node;
    ListNode<Integer> meet = meetingNode(head);
    if(meet==null) {
      System.out.println("没有环");
    } else {
      System.out.println("环的入口值:" + meet.val);
    }
  }
}