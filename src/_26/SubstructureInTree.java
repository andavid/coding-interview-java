package _26;

import structure.TreeNode;

// 面试题26：树的子结构
// 题目：输入两棵二叉树A和B，判断B是不是A的子结构。

public class SubstructureInTree {
  public static boolean hasSubtree(TreeNode s, TreeNode t) {
    if (t == null) {
      return true;
    }
    if (s == null) {
      return false;
    }
    if (s.val == t.val) {
      if (isMatch(s, t)) {
        return true;
      }
    }
    return hasSubtree(s.left, t) || hasSubtree(s.right, t);
  }

  public static boolean isMatch(TreeNode s, TreeNode t) {
    if (t == null) {
      return true;
    }
    if (s == null) {
      return false;
    }
    if (s.val == t.val && isMatch(s.left, t.left) && isMatch(s.right, t.right)) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    //                  8                8           2
    //              /       \           / \         / \
    //             8         7         9   2       4   3
    //           /   \
    //          9     2
    //               / \
    //              4   7
    TreeNode root1 = new TreeNode(8);
    root1.left = new TreeNode(8);
    root1.right = new TreeNode(7);
    root1.left.left = new TreeNode(9);
    root1.left.right = new TreeNode(2);
    root1.left.right.left = new TreeNode(4);
    root1.left.right.right = new TreeNode(7);

    TreeNode root2 = new TreeNode(8);
    root2.left = new TreeNode(9);
    root2.right = new TreeNode(2);

    TreeNode root3 = new TreeNode(2);
    root3.left = new TreeNode(4);
    root3.right = new TreeNode(3);

    System.out.println(hasSubtree(root1, root2));
    System.out.println(hasSubtree(root1, root3));
  }
}
