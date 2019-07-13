package _55;

import structure.TreeNode;

// 平衡二叉树
// 输入一棵二叉树的根结点，判断该树是不是平衡二叉树。如果某二叉树中
// 任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
public class BalancedBinaryTree {
  public static boolean isBalanced1(TreeNode root) {
    if (root == null) {
      return true;
    }

    int left = treeDepth(root.left);
    int right = treeDepth(root.right);
    int diff = left - right;
    if (diff > 1 || diff < -1) {
      return false;
    }

    return isBalanced1(root.left) && isBalanced1(root.right);
  }

  public static boolean isBalanced2(TreeNode root) {
    int[] depth = new int[]{0};
    return isBalanced(root, depth);
  }

  public static boolean isBalanced(TreeNode root, int[] depth) {
    if (root == null) {
      depth[0] = 0;
      return true;
    }

    int[] left = new int[]{0};
    int[] right = new int[]{0};

    if (isBalanced(root.left, left) && isBalanced(root.right, right)) {
      int diff = left[0] - right[0];
      if (diff <= 1 && diff >= -1) {
        depth[0] = 1 + ((left[0] > right[0]) ? left[0] : right[0]);
        return true;
      }
    }

    return false;
  }

  public static int treeDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = treeDepth(root.left);
    int right = treeDepth(root.right);
    return (left > right) ? left + 1 : right + 1;
  }

  public static void main(String[] args) {
    //            1
    //         /      \
    //        2        3
    //       /\
    //      4  5
    //        /
    //       6
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.right.left = new TreeNode(6);
    System.out.println(isBalanced1(root));
    System.out.println(isBalanced2(root));
  }
}
