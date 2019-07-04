package _19;

public class RegularExpressionsMatching {
  /**
   * 实现正则表达式中.和*的功能。.表示任意一个字符，*表示他前面的字符的任意次（含0次）。
   * 比如aaa与a.a和ab*ac*a匹配，但与aa.a和ab*a不匹配。
   *
   * 由于*的匹配会涉及到前一个字符，所以要区分模式串的第二个字符是不是*的情况，然后在考虑.的问题。
   */
  public static boolean match(String str, String pattern) {
    if (str == null || pattern == null) {
      return false;
    }
    return matchInternal(str, 0, pattern, 0);
  }

  public static boolean matchInternal(String str, int strIndex, String pattern, int patternIndex) {
    int strLength = str.length();
    int patternLength = pattern.length();

    // 如果匹配串和模式串都匹配结束
    if (patternIndex == patternLength) {
      return (strIndex == strLength);
    }

    // 如果匹配串匹配结束，模式串没有匹配结束，判断模式串第二个字符是不是 *
    if (strIndex == strLength) {
      if (patternIndex+1 < patternLength && pattern.charAt(patternIndex + 1) == '*') {
        return matchInternal(str, strIndex, pattern, patternIndex + 2); // * 匹配 0 次
      } else {
        return false;
      }
    }

    // 匹配串和模式串都没有匹配结束，区分模式串的第二个字符是不是*
    if (patternIndex == patternLength-1 || pattern.charAt(patternIndex + 1) != '*') {
      // 模式串只剩下一个字符，或者模式串的第二个字符不是*
      if (matchOne(str, strIndex, pattern, patternIndex)) {
        // 当前字符匹配成功，继续匹配下一个字符
        return matchInternal(str, strIndex + 1, pattern, patternIndex + 1);
      } else {
        return false;
      }
    } else {
      // 模式串的第二个字符是*
      if (matchOne(str, strIndex, pattern, patternIndex)) {
        return matchInternal(str, strIndex, pattern, patternIndex + 2) // * 匹配 0 次
            || matchInternal(str, strIndex + 1, pattern, patternIndex + 2) // * 匹配 1 次
            || matchInternal(str, strIndex + 1, pattern, patternIndex); // * 匹配 N 次
      } else {
        return matchInternal(str, strIndex, pattern, patternIndex + 2); // * 匹配 0 次
      }
    }
  }

  public static boolean matchOne(String str, int strIndex, String pattern, int patternIndex) {
    return pattern.charAt(patternIndex) == '.' || pattern.charAt(patternIndex) == str.charAt(strIndex);
  }

  public static void main(String[] args) {
    System.out.println(match("aaa", "a.a"));//true
    System.out.println(match("aaa", "ab*ac*a"));//true
    System.out.println(match("aaa", "aa.a"));//false
    System.out.println(match("aaa", "ab*a"));//false
  }
}
