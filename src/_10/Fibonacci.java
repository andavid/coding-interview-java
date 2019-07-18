package _10;

// 斐波那契数列
// 写一个函数，输入 n，求斐波那契（Fibonacci）数列的第 n 项。
public class Fibonacci {
  public static long fibonacci1(int n) {
    if (n <= 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    return fibonacci1(n - 1) + fibonacci1(n - 2);
  }

  public static long fibonacci2(int n) {
    if (n <= 0) {
      return 0;
    }

    if (n == 1) {
      return 1;
    }

    long oneStepBefore = 1;
    long twoStepsBefore = 0;
    long result = 1;

    for (int i = 2; i <= n; i++) {
      result = oneStepBefore + twoStepsBefore;
      twoStepsBefore = oneStepBefore;
      oneStepBefore = result;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(fibonacci1(13));
    System.out.println(fibonacci2(13));
  }
}
