package _33;

// 二叉搜索树的后序遍历序列
// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
public class SquenceOfBST {
  public static boolean verifySquenceOfBST(int[] data) {
    if (data == null || data.length == 0) {
      return false;
    }
    return verifySquenceOfBST(data, 0, data.length - 1);
  }

  public static boolean verifySquenceOfBST(int[] data, int start, int end) {
    if (end - start <= 1) {
      return true;
    }

    int root = data[end];
    int right = start;
    for (int i = start; i < end; i++) {
      if (data[i] > root) {
        right = i;
        break;
      }
    }

    for (int i = right; i < end; i++) {
      if (data[i] < root) {
        return false;
      }
    }

    return verifySquenceOfBST(data, start, right - 1)
        && verifySquenceOfBST(data, right, end - 1);
  }

  public static void main(String[] args) {
    //            8
    //          /   \
    //         6     10
    //       /  \   / \
    //      5    7 9   11
    int[] data1 = {5, 7, 6, 9, 11, 10, 8};
    int[] data2 = {5, 7, 6, 9, 4, 10, 8};
    System.out.println(verifySquenceOfBST(data1));
    System.out.println(verifySquenceOfBST(data2));
  }
}
