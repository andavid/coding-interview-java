package _56;

public class NumbersAppearOnce {

  /**
   * 一个整数数组里除了两个数字出现一次，其他数字都出现两次。
   * 请找出这两个数字。要求时间复杂度为o(n)，空间复杂度为o(1)。
   * <p>
   * 实例分析(以2,4,3,6,3,2,5,5为例)：
   * 相关数字的二进制表示为：
   * 2 = 0010       3 = 0011       4 = 0100
   * 5 = 0101       6 = 0110
   * <p>
   * 步骤1 全体异或：2^4^3^6^3^2^5^5 = 4^6 = 0010
   * 步骤2 确定位置：对于0010，从右数的第二位为1，因此可以根据倒数第2位是否为1进行分组
   * 步骤3 进行分组：分成[2,3,6,3,2]和[4,5,5]两组
   * 步骤4 分组异或：2^3^6^3^2 = 6，4^5^5 = 4，因此结果为4，6。
   */
  public static int[] findNumbersAppearOnce(int[] data) {
    int[] result = new int[2];

    int temp = 0;
    for (int item : data) {
      temp ^= item;
    }

    // 只保留最右边一位 1，其余位置为 0
    temp = (temp & (temp - 1)) ^ temp;

    for (int item : data) {
      if ((item & temp) == 0) {
        result[0] ^= item;
      } else {
        result[1] ^= item;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    int[] data1 = {2, 4, 3, 6, 3, 2, 5, 5};
    int[] result = findNumbersAppearOnce(data1);
    System.out.println(result[0]);
    System.out.println(result[1]);
  }
}
