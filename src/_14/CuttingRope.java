package _14;

public class CuttingRope {
  /**
   * 给你一根长度为n的绳子，把绳子剪成m段，求每段绳子长度乘积的最大值。
   * f(n) = max(f(i)*f(n-i)), i=[0,n/2]
   */
  public static int maxCutting(int length) {
    if (length < 2) return 0;
    if (length == 2) return 1;
    if (length == 3) return 2;

    int[] dp = new int[length + 1];
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;

    for (int i = 4; i <= length; i++) {
      int max = 0;
      for (int j = 1; j <= i/2; j++) {
        int temp = dp[j] * dp[i - j];
        if (temp > max) {
          max = temp;
        }
      }
      dp[i] = max;
    }

    return dp[length];
  }

  public static void main(String[] args) {
    for (int i = 2; i < 10; i++) {
      System.out.println("" + i + " -> " + maxCutting(i));
    }
  }
}
