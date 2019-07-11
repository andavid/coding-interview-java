package _53;

public class MissingNumber {
  /**
   * 一个长度为n的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n之内。
   * 在范围0~n内的n个数字有且只有一个数字不在该数组中，请找出。
   *
   * 用二分查找法找到数组中第一个数值不等于下标的数字。
   */
  public static int getMissingNumber(int[] data) {
    int low = 0;
    int high = data.length - 1;
    while (low <= high) {
      int mid = low + (high - low)/2;
      if (data[mid] == mid) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    int[] data1 = {0,1,2,3,4,5}; //6
    int[] data2 = {0,1,3,4,5}; //2
    int[] data3 = {1,2}; //0
    System.out.println(getMissingNumber(data1));
    System.out.println(getMissingNumber(data2));
    System.out.println(getMissingNumber(data3));
  }
}
