package _39;

public class MoreThanHalfNumber {
  /**
   * 找出数组中出现次数超过数组长度一半的数字。
   * 如输入{1,2,3,2,2,2,5,4,2}，则输出2。
   * 问题转化为求数组的中位数。
   * 可以借助快排的分区函数来实现。
   */
  public static int moreThanHalfNum(int[] data) {
    return partition(data, 0, data.length - 1);
  }

  public static int partition(int[] data, int low, int high) {
    int pivot = data[high];
    int i = low;
    for (int j = low; j < high; j++) {
      if (data[j] < pivot) {
        swap(data, i, j);
        i++;
      }
    }
    swap(data, i, high);

    if (i == (data.length - 1)/2) {
      return data[i];
    } else if (i > (data.length - 1)/2) {
      return partition(data, low, i - 1);
    } else {
      return partition(data, i + 1, high);
    }
  }

  public static void swap(int[] data, int i, int j) {
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }

  public static void main(String[] args) {
    int[] data = {1,2,3,2,2,2,5,4,2};
    System.out.println(moreThanHalfNum(data));
  }
}
