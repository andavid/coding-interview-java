package _56;

public class NumbersAppearingOnce {
  /**
   * 在一个整数数组中除了一个数字只出现一次外，其他数字都出现三次。找出那个出现一次的数字。
   * <p>
   * 异或操作可以看成两个数字的每一个二进制位对应进行加法后对2取模后的结果。
   * 按照这种思路，对于出现三次的数字，改成对3取模即可。
   * <p>
   * 1. 申请一个长度为32(因为int占32bit)的int型数组，用于记录整型数字每一位出现1的次数。
   * 2. 将每个数字计入到数组中。
   * 3. 数组每一个元素对 3 取模。
   * 4. 把数组转成 32 位的整数，就是那个出现一次的数字。
   */
  public static int findNumberAppearingOnce(int[] data) {
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
    int[] data = {10, 4, 5, 3, 5, 4, 3, 3, 4, 5};
    System.out.println(findNumberAppearingOnce(data));
  }
}
