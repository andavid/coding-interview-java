# 面试题 3：数组中重复的数

## 问题描述

在一个长度为 n 的数组中，所有数字的取值范围都在 [0,n-1]，但不知道有几个数字重复或重复几次，找出其中任意一个重复的数字。

## 问题分析

借助哈希表，遍历一次数组即可找到重复的数字。

## [代码实现][src]

```java
public static int getDuplication(int[] data) {
  if (data == null || data.length < 2) {
    return -1;
  }

  Set<Integer> set = new HashSet<>();
  for (int item : data) {
    if (set.contains(item)) {
      return item;
    }
    set.add(item);
  }

  return -1;
}
```

[src]: https://github.com/andavid/coding-interview-java/blob/master/src/_03/DuplicationInArray.java
