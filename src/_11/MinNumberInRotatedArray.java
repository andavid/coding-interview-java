package _11;

public class MinNumberInRotatedArray {
  /**
   * 把一个数组最开始的若干个元素搬到末尾成为数组的旋转。
   * 如1,2,3,4,5=>3,4,5,1,2；0,1,1,1,1=>1,1,1,0,1；0,1,1,1,1=>1,0,1,1,1。
   * 求一个原本递增的数组旋转后的最小数字。
   */
  public static int min(int[] data) {
    if (data == null || data.length == 0) {
      return -1;
    }

    int left = 0;
    int right = data.length - 1;
    while (left < right) {
      int mid = left + (right - left)/2;
      if (data[left] < data[right]) {
        return data[left];
      } else if (data[left] > data[right]) {
        // 前面部分是较大的递增序列，后面是较小的递增序列
        if (data[left] <= data[mid]) {
          // left 到 mid 是递增的，最小值在 mid + 1 到 right 之间
          left = mid + 1;
        } else {
          // left 到 mid 不是递增的，最小值在 left 到 mid 之间
          right = mid;
        }
      } else {
        if (data[left] < data[mid]) {
          left = mid + 1;
        } else if (data[left] > data[mid]) {
          right = mid;
        } else {
          // 左右中三个值都相等，查找范围缩小一步
          left = left + 1;
          right = right - 1;
        }
      }
    }

    return data[right];
  }

  public static void main(String[] args) {
    int[] data1 = {3,4,5,1,2};
    int[] data2 = {1,0,1,1,1};
    int[] data3 = {1,1,1,0,1};
    System.out.println(min(data1));
    System.out.println(min(data2));
    System.out.println(min(data3));
  }
}
