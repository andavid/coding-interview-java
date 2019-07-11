package _50;

import java.util.LinkedList;
import java.util.Queue;

public class FirstCharacterInStream {

  private Queue<Character> queue;
  public static final char DEFAULT_CHAR = '?';

  public FirstCharacterInStream() {
    queue = new LinkedList<>();
  }

  public void insert(char ch) {
    if (queue.isEmpty()) {
      queue.offer(ch);
    } else if (queue.contains(ch)) {
      queue.remove(ch);
    } else {
      queue.offer(ch);
    }
  }

  public char find() {
    if (queue.isEmpty()) {
      return DEFAULT_CHAR;
    } else {
      return queue.peek();
    }
  }

  public static void main(String[] args) {
    FirstCharacterInStream instance = new FirstCharacterInStream();
    String str = "google";
    for (char ch : str.toCharArray()) {
      instance.insert(ch);
      System.out.println(instance.find());
    }
  }

}