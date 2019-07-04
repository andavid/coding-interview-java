package _05;

public class ReplaceSpaces {
  /**
   * 实现一个函数，把字符串中的每个空格都替换成“%20”，
   * 已知原位置后面有足够的空余位置，要求改替换过程发生在原来的位置上。
   *
   * 计算替换后的字符串的长度，从后往前替换
   */
  public static void replaceBlank(char[] data, int length) {
    int newLen = length;
    for (int i = 0; i < length; i++) {
      if (data[i] == ' ') {
        newLen += 2;
      }
    }

    for (int indexOld = length - 1, indexNew = newLen - 1;
         indexOld >= 0 && indexOld != indexNew;
         indexOld--, indexNew--) {
      if (data[indexOld] == ' ') {
        data[indexNew--] = '0';
        data[indexNew--] = '2';
        data[indexNew] = '%';
      } else {
        data[indexNew] = data[indexOld];
      }
    }
  }

  public static void main(String[] args) {
    char[] predata = "we are happy.".toCharArray();
    int length = predata.length;

    char[] data = new char[30];
    for (int i = 0; i < length; i++) {
      data[i] = predata[i];
    }

    replaceBlank(data, length);
    System.out.println(data);
  }
}
