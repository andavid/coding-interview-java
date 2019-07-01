package _18;

import structure.ListNode;

public class DeleteDuplicatedNode {

  public static ListNode<Integer> deleteDuplication(ListNode<Integer> head) {
    if (head == null) {
      return null;
    }

    ListNode<Integer> dummy = new ListNode<Integer>(0);
    dummy.next = head;

    ListNode<Integer> pre = dummy;
    ListNode<Integer> cur = head;
    ListNode<Integer> post = cur.next;
    boolean isDuplicate = false;

    while (post != null) {
      if (post.val == cur.val) {
        isDuplicate = true;
        post = post.next;
      } else if (isDuplicate && post.val != cur.val) {
        pre.next = post;
        // 删除从 cur 到 post 中间的所有节点
        while (cur != post) {
          ListNode<Integer> p = cur;
          cur = cur.next;
          p.next = null;
          p = null;
        }
        post = post.next;
        isDuplicate = false;
      } else {
        pre = cur;
        cur = post;
        post = post.next;
      }
    }

    if (isDuplicate) {
      pre.next = null;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode<Integer> head = new ListNode<Integer>(1);
    head.next= new ListNode<>(1);
    head.next.next = new ListNode<>(2);
    head.next.next.next = new ListNode<>(2);
    head.next.next.next.next = new ListNode<>(2);
    head.next.next.next.next.next = new ListNode<>(3);
    System.out.println(head);
    head = deleteDuplication(head);
    System.out.println(head);
  }

}