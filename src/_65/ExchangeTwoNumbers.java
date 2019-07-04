package _65;

public class ExchangeTwoNumbers {
  /**
   * 不使用新的变量完成交换两个原有变量的值。
   */
  public static void main(String[] args) {
    int a = 3, b = 5;
    System.out.println("before swap: a = " + a + ", b = " + b);

    a = a ^ b;
    b = a ^ b;
    a = a ^ b;

    System.out.println("after  swap: a = " + a + ", b = " + b);
  }
}
