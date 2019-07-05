package _58;

public class LeftRotateString {
  /**
   * 实现一个函数完成字符串的左旋转功能。比如，输入 abcdefg 和数字 2，输出为 cdefgab。
   */
  public static String leftRotateString(String str, int k) {
    int n = str.length();
    k = k % n;
    if (k == 0) {
      return str;
    }

    StringBuilder sb = new StringBuilder(str);

    reverse(sb, 0, k - 1);
    reverse(sb, k, n - 1);
    reverse(sb, 0, n - 1);

    return sb.toString();
  }

  public static void reverse(StringBuilder sb, int start, int end) {
    for(int i = start; i <= start + (end - start)/2; i++) {
      char temp = sb.charAt(i);
      sb.setCharAt(i, sb.charAt(end - i + start));
      sb.setCharAt(end - i + start, temp);
    }
  }

  public static void main(String[] args) {
    System.out.println(leftRotateString("abcdefg", 2));
  }
}
