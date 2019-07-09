package _41;

import java.util.Collections;
import java.util.PriorityQueue;

public class StreamMedian {
  /**
   * 求数据流中的中位数。
   * 如果长度为奇数，求中间的那个数；如果长度为偶数，求中间两个数的均值。
   *
   * 使用一个大顶堆保存前半部分数据，一个小顶堆保存后半部分数据。
   * 保证两个堆的数据个数相同，或者大顶堆比小顶堆个数多一。
   * 中位数为两个堆顶的均值，或者大顶堆的堆顶。
   */
  public static class MedianFinder {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public void addNum(int num) {
      maxHeap.offer(num);
      minHeap.offer(maxHeap.poll());
      if (maxHeap.size() < minHeap.size()) {
        maxHeap.offer(minHeap.poll());
      }
    }

    public double findMedian() {
      if (maxHeap.size() == minHeap.size()) {
        return (maxHeap.peek() + minHeap.peek()) * 0.5;
      } else {
        return maxHeap.peek();
      }
    }
  }

  public static void main(String[] args) {
    MedianFinder medianFinder = new MedianFinder();
    medianFinder.addNum(1);
    medianFinder.addNum(2);
    medianFinder.addNum(3);
    medianFinder.addNum(4);
    System.out.println(medianFinder.findMedian());
    medianFinder.addNum(5);
    System.out.println(medianFinder.findMedian());
  }
}
