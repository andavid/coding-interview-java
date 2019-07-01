# 面试题 6：从尾到头打印链表

## 问题描述

输入一个链表的头节点，从尾到头反过来打印出每个节点的值。

## 问题分析

* 不能改变链表的结构。
* 可以用栈或递归来实现。

## [递归实现][src]

```java
void printReversinglyRecursively(ListNode<Integer> node) {
  if (node == null) {
    return;
  }
  printReversinglyIteratively(node.next);
  System.out.println(node.val);
}
```

## [栈实现][src]

```java
void printReversinglyIteratively(ListNode<Integer> node) {
  Stack<Integer> stack = new Stack<>();
  while (node != null) {
    stack.push(node.val);
    node = node.next;
  }
  while (!stack.empty()) {
    System.out.println(stack.pop());
  }
}
```

[src]: https://github.com/andavid/coding-interview-java/blob/master/src/_06/PrintListInReversedOrder.java
