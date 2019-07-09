package _46;

public class TranslateNumbersToStrings {
  /**
   * 给定一个数字，按照如下规则翻译成字符串：
   * 0翻译成“a”，1翻译成“b”...25翻译成“z”。
   * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
   *
   * f(r)表示以r为开始（r最小取0）到最右端所组成的数字能够翻译成字符串的种数。
   * f(r-2) = f(r-1)+g(r-2,r-1)*f(r)
   * 如果r-2，r-1能够翻译成字符，则g(r-2,r-1)=1，否则为0。
   */
  public static int getTranslationCount(int number) {
    if (number < 0) {
      return 0;
    }
    if (number < 10) {
      return 1;
    }

    String str = String.valueOf(number);
    int prev = 0, count = 1;
    for (int i = str.length() - 2; i >= 0; i--) {
      int temp = count ;
      if (Integer.valueOf(str.substring(i, i+2)) < 26) {
        count = count + prev;
      }
      prev = temp;
    }

    return count;
  }

  public static void main(String[] args) {
    System.out.println(getTranslationCount(12258));
  }
}
