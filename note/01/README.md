# 面试题 1：赋值运算符函数

## 问题描述

为自定义类添加赋值运算符函数。

## 问题分析

* 对于传入的参数，不应该被修改，使用 final 修饰。
* 判断传入的参数和当前的实例是不是同一个实例，如果是同一个，或者两个实例的值相等，则不进行赋值操作，直接返回。
* 返回值最好为 this，这样可以使赋值链接起来。

## [代码实现][src]

```java
public MyString assign(final MyString another) {
  if (this == another || this.data.equals(another.data)) {
    return this;
  } else {
    this.data = another.data;
    return this;
  }
}
```

[src]: https://github.com/andavid/coding-interview-java/blob/master/src/_01/AssignmentOperator.java
