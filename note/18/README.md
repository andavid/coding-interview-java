# 面试题 18：删除链表的节点

## 在 O(1) 时间内删除单链表的节点

给定单向链表的头指针和一个节点指针，定义一个函数在 O(1) 时间内删除该节点。

## 解题思路

直接删除单链表某一节点，需要 O(n) 时间找到其前继节点，如果想在 O(1) 时间完成删除操作，可以将欲删节点的后一个节点的值拷贝到欲删节点之上，然后删除欲删节点的后一个节点。对于尾节点的删除仍然需要 O(n)，其他节点都是 O(1)，因此均摊时间复杂度是 O(1)，满足要求。

## [代码实现][src1]

```java
ListNode<Integer> deleteNode(ListNode<Integer> head, ListNode<Integer> node) {
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
```

## 删除链表中重复的节点

在一个排序的链表中，如何删除重复的节点？例如 [1,2,2,3,3,3]，删除之后为 [1]。

## [代码实现][src2]

```java
ListNode<Integer> deleteDuplication(ListNode<Integer> head) {
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
```

[src1]: https://github.com/andavid/coding-interview-java/blob/master/src/_18/DeleteNodeInList.java
[src2]: https://github.com/andavid/coding-interview-java/blob/master/src/_18/DeleteDuplicatedNode.java
