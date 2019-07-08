package _40;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLeastNumbers {
  /**
   * 找出 n 个整数中最小的 k 个数。
   * 例如输入 4,5,1,6,2,7,3,8，则最小的 4 个数字是 1,2,3,4。
   *
   * 维护一个长度为 k 的最大堆。
   */
  public static int[] getLeastNumbers(int[] data, int k) {
    if (data == null || data.length == 0 || k <= 0) {
      return new int[0];
    }

    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < data.length; i++) {
      if (i < k) {
        queue.offer(data[i]);
      } else {
        if (data[i] < queue.peek()) {
          queue.poll();
          queue.offer(data[i]);
        }
      }
    }

    int[] result = new int[k];
    for (int i = k - 1; i >= 0; i--) {
      result[i] = queue.poll();
    }

    return result;
  }

  public static void main(String[] args) {
    int[] data = {4,5,1,6,2,7,3,8};
    int[] result = getLeastNumbers(data, 4);
    System.out.println(Arrays.toString(result));
  }
}
