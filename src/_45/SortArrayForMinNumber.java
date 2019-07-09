package _45;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortArrayForMinNumber {
  /**
   * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，使其为所有可能的拼接结果中最小的一个。
   * 例如输入 {3,32,321}，则输出 321323。
   *
   * 使用自定义的排序规则对数组进行排序。
   */
  public static String printMinNumber(int[] data) {
    if (data == null || data.length == 0) {
      return "";
    }

    List<Integer> list = new ArrayList<>();
    for (int item : data) {
      list.add(item);
    }

    list.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return (o1 + "" + o2).compareTo(o2 + "" + o1);
      }
    });

    StringBuilder sb = new StringBuilder();
    for (int item : list) {
      sb.append(item);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    int[] data = {3, 32, 321};
    System.out.println(printMinNumber(data));
  }
}
