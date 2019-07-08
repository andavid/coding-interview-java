package _21;

import java.util.Arrays;

public class ReorderArray {
  /**
   * 实现一个函数来调整数组中的数字，使得所有奇数位于数组的前半部分，偶数位于后半部分。
   *
   * 使用双指针从两端往中间扫描
   */
  public static void reorder(int[] data) {
    if (data == null || data.length < 2) {
      return;
    }

    int left = 0;
    int right = data.length - 1;

    while (left < right) {
      while (left < right && !isEven(data[left])) {
        left++;
      }
      while (left < right && isEven(data[right])) {
        right--;
      }
      if (left < right) {
        int temp = data[left];
        data[left] = data[right];
        data[right] = temp;
      }
    }
  }

  public static boolean isEven(int value) {
    return (value&1) == 0;
  }

  public static void main(String[] args) {
    int[] data = {1,2,3,4,5,7,7};
    reorder(data);
    System.out.println(Arrays.toString(data));
  }
}
