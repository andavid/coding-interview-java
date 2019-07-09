package _42;

public class GreatestSumOfSubarrays {
  /**
   * 数组中一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
   *
   * 如果 i = 0 或者 dp[i-1] <= 0，dp[i] = data[i]；
   * 否则，dp[i] = dp[i-1] + data[i]
   */
  public static int findGreatestSumOfSumArrays(int[] data) {
    if (data == null || data.length == 0) {
      return 0;
    }

    int dp = data[0];
    int max = dp;

    for (int i = 1; i < data.length; i++) {
      if (dp > 0) {
        dp += data[i];
      } else {
        dp = data[i];
      }
      if (dp > max) {
        max = dp;
      }
    }

    return max;
  }

  public static void main(String[] args) {
    int[] data = {1,-2,3,10,-4,7,2,-5};
    System.out.println(findGreatestSumOfSumArrays(data));
  }
}
