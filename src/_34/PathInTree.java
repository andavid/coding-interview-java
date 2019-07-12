package _34;

import java.util.ArrayList;
import java.util.List;

import structure.TreeNode;

// 二叉树中和为某一值的路径
// 输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
// 有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
public class PathInTree {
  public static void findPath(TreeNode root, int expectedSum) {
    if (root == null) {
      return;
    }
    List path = new ArrayList<>();
    findPath(root, path, expectedSum, 0);
  }

  public static void findPath(TreeNode curNode, List path,
                              int expectedSum, int currentSum) {
    path.add(curNode.val);
    currentSum += curNode.val;

    if (curNode.left != null) {
      findPath(curNode.left, path, expectedSum, currentSum);
    }
    if (curNode.right != null) {
      findPath(curNode.right, path, expectedSum, currentSum);
    }

    if (curNode.left == null && curNode.right == null && expectedSum == currentSum) {
      System.out.println(path);
    }

    path.remove(path.size() - 1);
  }

  public static void main(String[] args) {
    //            10
    //          /   \
    //         5     12
    //       /  \
    //      4    7
    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.right = new TreeNode(12);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(7);
    findPath(root, 22);
  }
}
