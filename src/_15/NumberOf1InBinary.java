package _15;

public class NumberOf1InBinary {
  private static int numberOf1(int n) {
    int count = 0;
    while (n != 0) {
      n = n & (n-1);
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println(numberOf1(9));
    System.out.println(numberOf1(-3));
  }
}
