package _03;

import java.util.HashSet;
import java.util.Set;

public class DuplicationInArray {

  public static int getDuplication(int[] data) {
    if (data == null || data.length < 2) {
      return -1;
    }

    Set<Integer> set = new HashSet<>();
    for (int item : data) {
      if (set.contains(item)) {
        return item;
      }
      set.add(item);
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] data = {2,3,1,0,2,5,3};
    System.out.println(getDuplication(data));
  }

}