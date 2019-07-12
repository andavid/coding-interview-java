package _28;

import structure.TreeNode;

// 对称的二叉树
// 请实现一个函数，用来判断一棵二叉树是不是对称的。
public class SymmetricalBinaryTree {
  public static boolean isSymmetrical(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isSymmetrical(root.left, root.right);
  }

  public static boolean isSymmetrical(TreeNode r1, TreeNode r2) {
    if (r1 == null && r2 == null) {
      return true;
    }
    if (r1 == null || r2 == null) {
      return false;
    }
    if (r1.val != r2.val) {
      return false;
    }
    return isSymmetrical(r1.left, r2.right) && isSymmetrical(r1.right, r2.left);
  }

  public static void main(String[] args) {
    //            8
    //        6      6
    //       5 7    7 5
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(6);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(7);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(5);
    System.out.println(isSymmetrical(root));
    System.out.println(isSymmetrical(root.left));
  }
}
