package _56;

public class NumberAppearOnce {

  /**
   * 一个整数数组里除了两个数字出现一次，其他数字都出现两次。
   * 请找出这两个数字。要求时间复杂度为o(n)，空间复杂度为o(1)。
   *
   * 实例分析(以2,4,3,6,3,2,5,5为例)：
   * 相关数字的二进制表示为：
   *     2 = 0010       3 = 0011       4 = 0100
   *     5 = 0101       6 = 0110
   *
   * 步骤1 全体异或：2^4^3^6^3^2^5^5 = 4^6 = 0010
   * 步骤2 确定位置：对于0010，从右数的第二位为1，因此可以根据倒数第2位是否为1进行分组
   * 步骤3 进行分组：分成[2,3,6,3,2]和[4,5,5]两组
   * 步骤4 分组异或：2^3^6^3^2 = 6，4^5^5 = 4，因此结果为4，6。
   */
  public static int[] findNumsAppearOnce1(int[] data) {
    int[] result = new int[2];

    int temp = 0;
    for (int item : data) {
      temp ^= item;
    }

    // 只保留最右边一位 1，其余位置为 0
    temp = (temp & (temp-1)) ^ temp;

    for (int item : data) {
      if ((item & temp) == 0) {
        result[0] ^= item;
      } else {
        result[1] ^= item;
      }
    }

    return result;
  }

  /**
   * 在一个整数数组中除了一个数字只出现一次外，其他数字都出现三次。找出那个出现一次的数字。
   *
   * 异或操作可以看成两个数字的每一个二进制位对应进行加法后对2取模后的结果。
   * 按照这种思路，对于出现三次的数字，改成对3取模即可。
   *
   * 1. 申请一个长度为32(因为int占32bit)的int型数组，用于记录整型数字每一位出现1的次数。
   * 2. 将每个数字计入到数组中。
   * 3. 数组每一个元素对 3 取模。
   * 4. 把数组转成 32 位的整数，就是那个出现一次的数字。
   */
  public static int findNumsAppearOnce2(int[] data) {
    int[] bitSum = new int[32];
    for (int item : data) {
      for (int i = 31; i >= 0 && item != 0; i--) {
        if ((item & 1) != 0) {
          bitSum[i]++;
        }
        item = item >> 1;
      }
    }

    int result = 0;
    for (int i = 0; i < 32; i++) {
      result = result << 1;
      result += bitSum[i] % 3;
    }

    return result;
  }

  public static void main(String[] args) {
    int[] data1 = {2,4,3,6,3,2,5,5};
    int[] result = findNumsAppearOnce1(data1);
    System.out.println(result[0]);
    System.out.println(result[1]);

    int[] data2 = {10,4,5,3,5,4,3,3,4,5};
    System.out.println(findNumsAppearOnce2(data2));
  }
}
