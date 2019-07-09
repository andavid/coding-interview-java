package _51;

public class InversePairs {
  /**
   * 输入一个数组，求出这个数组中的逆序对总数。
   * 例如输入{7,5,6,4}，一共有5个逆序对，
   * 分别是（7,6），（7,5），（7,4），（6,4），（5,4）。
   *
   * 采用分治算法，利用二路归并排序实现。
   */
  public static int inversePairs(int[] data){
    if (data == null || data.length < 2) {
      return 0;
    }
    return mergeSort(data, 0, data.length - 1);
  }

  public static int mergeSort(int[] data, int low, int high) {
    int count = 0;
    if (low < high) {
      int mid = low + (high - low)/2;
      count += mergeSort(data, low, mid);
      count += mergeSort(data, mid + 1, high);
      count += merge(data, low, mid, high);
    }
    return count;
  }

  public static int merge(int[] data, int low, int mid, int high) {
    int count = 0;
    int[] temp = new int[high - low + 1];
    int left = low;
    int right = mid + 1;
    int index = 0;

    while (left <= mid && right <= high) {
      if (data[left] > data[right]) {
        // 合并两个有序数组过程中，right 存在逆序对数量为 left 到 mid 的元素数量
        count += mid - left + 1;
        temp[index++] = data[right++];
      } else {
        temp[index++] = data[left++];
      }
    }

    while (left <= mid) {
      temp[index++] = data[left++];
    }

    while (right <= high) {
      temp[index++] = data[right++];
    }

    for (int i = low; i <= high; i++) {
      data[i] = temp[i - low];
    }

    return count;
  }

  public static void main(String[] args) {
    int[] data1 = {7,5,6,4};
    System.out.println(inversePairs(data1));

    int[] data2 = {5,6,7,8,1,2,3,4};
    System.out.println(inversePairs(data2));

    int[] data3 = {4,3,11,15,13,2,8};
    System.out.println(inversePairs(data3));
  }
}
