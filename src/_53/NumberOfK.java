package _53;

public class NumberOfK {
  /**
   * 统计一个数字在排序数组中出现的次数。
   *
   * 使用二分查找，找到第一个和最后一个出现该数字的索引相减加一就是出现的次数。
   */
  public static int getNumberOfK(int[] data, int value) {
    int first = searchFirst(data, value);
    if (first == -1) {
      return 0;
    }
    int last = searchLast(data, value);
    return last - first + 1;
  }

  public static int searchFirst(int[] data, int value) {
    if (data == null || data.length == 0) {
      return -1;
    }

    int low = 0;
    int high = data.length - 1;

    while (low <= high) {
      int mid = low + (high - low)/2;
      if (data[mid] < value) {
        low = mid + 1;
      } else if (data[mid] > value) {
        high = mid - 1;
      } else {
        if (mid == 0 || data[mid - 1] != value) {
          return mid;
        } else {
          high = mid - 1;
        }
      }
    }

    return -1;
  }

  public static int searchLast(int[] data, int value) {
    if (data == null || data.length == 0) {
      return -1;
    }

    int low = 0;
    int high = data.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (data[mid] < value) {
        low = mid + 1;
      } else if (data[mid] > value) {
        high = mid - 1;
      } else {
        if (mid == data.length - 1 || data[mid + 1] != value) {
          return mid;
        } else {
          low = mid + 1;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] data1 = {1,2,3,3,3,3,5,6};
    int[] data2 = {1,2,3,3,3,3,4,5};
    int[] data3 = {3,3,3,3,3,3,3,3};
    System.out.println(getNumberOfK(data1,4));
    System.out.println(getNumberOfK(data2,3));
    System.out.println(getNumberOfK(data3,3));
  }
}
