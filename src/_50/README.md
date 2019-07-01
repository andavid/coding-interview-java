# 面试题 50：第一个只出现一次的字符

## 问题一描述

在字符串中找出第一个只出现一次的字符。如输入abaccdeff，则输出b。

## 问题一分析

假设字符是 ASCII 编码的字符。可以申请一个长度为 256 的 int 数组作为哈希表，占用空间 1kB，用它来记录字符出现的次数。第一遍扫描字符串，修改对应字符的出现的次数；第二遍扫描，当遇到在数组中对应值为 1 的字符，即得到所求，时间复杂度 o(n)。

## [问题一代码实现][src1]

```java
char firstNotRepeatingChar(String str) {
  int[] count = new int[256];
  for (char ch : str.toCharArray()) {
    count[ch]++;
  }
  for (char ch : str.toCharArray()) {
    if (count[ch] == 1) {
      return ch;
    }
  }
  return '?';
}
```

## 问题二描述

实现一个函数，找出字符流中第一个只出现一次的字符。例如，当从字符流 google 中只读出前两个字符 go 时，第一个只出现一次的字符是 g；当读完 google 时，第一个只出现一次的字符是 l。

## 问题二分析

可以使用一个队列，保存只出现一次的字符。队列的队头就是第一个只出现一次的字符。

## [问题二代码实现][src2]

```java
public class FirstNotRepeatingCharInStream {
  private Queue<Character> queue;
  public static final char DEFAULT_CHAR = '?';

  public FirstNotRepeatingCharInStream() {
    queue = new LinkedList<>();
  }

  public void insert(char ch) {
    if (queue.isEmpty()) {
      queue.offer(ch);
    } else if (queue.contains(ch)) {
      queue.remove(ch);
    } else {
      queue.offer(ch);
    }
  }

  public char find() {
    if (queue.isEmpty()) {
      return DEFAULT_CHAR;
    } else {
      return queue.peek();
    }
  }
}
```

[src1]: https://github.com/andavid/coding-interview-java/blob/master/src/_50/FirstNotRepeatingChar.java
[src2]: https://github.com/andavid/coding-interview-java/blob/master/src/_50/FirstNotRepeatingCharInStream.java
