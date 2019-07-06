package _58;

public class ReverseWordsInSentence {
  /**
   * 输入一个英文句子，翻转单词顺序，单词内字符不翻转，标点符号和普通字母一样处理。
   * 例如输入输入“I am a student.”，则输出“student. a am I”。
   *
   * 首先字符串整体翻转，得到“.tneduts a ma I”；
   * 然后以空格作为分隔符进行切分，对于切分下来的每一部分再进行翻转，
   * 得到“student. a am I”。
   */
  public static String reverse(String str) {
    StringBuilder sb = new StringBuilder(str);
    reverse(sb, 0, sb.length() - 1);

    int start = 0;
    int end = sb.indexOf(" ");
    while (start < sb.length() && end != -1) {
      reverse(sb, start, end - 1);
      start = end + 1;
      end = sb.indexOf(" ", start);
    }

    if (start < sb.length()) {
      reverse(sb, start, sb.length() - 1);
    }

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
    System.out.println(reverse("I am a student."));
  }

}
