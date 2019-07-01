package _50;

public class FirstNotRepeatingChar {

  public static char firstNotRepeatingChar(String str) {
    int[] count = new int[256];
    for (char ch : str.toCharArray()) {
      count[ch]++;
    }
    for (char ch : str.toCharArray()) {
      if (count[ch] == 1) {
        return ch;
      }
    }
    return '?';
  }

  public static void main(String[] args) {
    System.out.println(firstNotRepeatingChar("abaccdeff"));
  }

}