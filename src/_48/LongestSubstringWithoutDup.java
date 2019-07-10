package _48;

public class LongestSubstringWithoutDup {
  /**
   * 输入一个字符串（只包含a~z的字符），求其最长不含重复字符的子字符串的长度。
   * 例如对于arabcacfr，最长不含重复字符的子字符串为acfr，长度为4。
   *
   * dp[i]表示以下标为i的字符结尾不包含重复字符的最长子字符串长度。
   * dp[i] = 下标 i 和前面 dp[i-1] 个字符不重复的长度。
   * 由于每次可以根据 dp 的前一个状态推导出后一个状态，因此可以省略 dp 数组，使用一个变量即可。
   */
  public static int longestSubstringWithoutDup(String str) {
    if (str == null || str.length() == 0) {
      return 0;
    }

    int dp = 1;
    int max = 1;

    for (int i = 1; i < str.length(); i++) {
      int j = i - 1;
      for (; j >= i - dp; j--) {
        if (str.charAt(i) == str.charAt(j)) {
          break;
        }
      }
      dp = i - j;
      if (dp > max) {
        max = dp;
      }
    }

    return max;
  }

  public static void main(String[] args) {
    System.out.println(longestSubstringWithoutDup("arabcacfr"));
    System.out.println(longestSubstringWithoutDup("abcdefaaa"));
  }
}
