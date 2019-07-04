package _65;

public class AddTwoNumbers {

  /**
   * 写一个函数，求两个正数之和，要求在函数体内不能使用四则运算符号。
   *
   * 以0011（即3）与0101（即5）相加为例说明
   * 1.两数进行异或：  0011^0101=0110 这个数字其实是把原数中不需进位的二进制位进行了组合
   * 2.两数进行与：    0011&0101=0001 这个数字为1的位置表示需要进位，而进位动作是需要向前一位进位
   * 3.左移一位：      0001<<1=0010
   *
   * 此时我们就完成0011 + 0101 = 0110 + 0010的转换
   *
   * 如此转换下去，直到其中一个数字为0时，另一个数字就是原来的两个数字的和
   */
  public static int add(int a, int b) {
    int sum = a ^ b;
    int carry = (a & b) << 1;

    while (carry != 0) {
      int temp = sum;
      sum = sum ^ carry;
      carry = (temp & carry) << 1;
    }

    return sum;
  }

  public static void main(String[] args) {
    System.out.println(add(3, 5));
    System.out.println(add(3, -5));
  }

}
