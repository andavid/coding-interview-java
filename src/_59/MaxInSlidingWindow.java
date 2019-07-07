package _59;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxInSlidingWindow {
  /**
   * 给定一个数组和滑动窗口的大小，请找出所有滑动窗口的最大值。
   * 例如，输入数组{2,3,4,2,6,2,5,1}和数字3，
   * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}。
   */
  public static int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || k <= 0 || k > nums.length) {
      return new int[0];
    }

    Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    int i = 0;
    for (; i < k; i++) {
      queue.offer(nums[i]);
    }

    int[] result = new int[nums.length - k + 1];
    int index = 0;
    result[index++] = queue.peek();

    for (; i < nums.length; i++) {
      queue.remove(nums[i - k]);
      queue.offer(nums[i]);
      result[index++] = queue.peek();
    }

    return result;
  }

  public static void main(String[] args) {
    int[] data = {2, 3, 4, 2, 6, 2, 5, 1};
    int[] result = maxSlidingWindow(data, 3);
    System.out.println(Arrays.toString(result));
  }
}
