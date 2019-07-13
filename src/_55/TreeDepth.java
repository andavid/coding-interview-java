package _55;

import java.util.LinkedList;
import java.util.Queue;

import structure.TreeNode;

// 二叉树的深度
// 输入一棵二叉树的根结点，求该树的深度。从根结点到叶结点依次经过的
// 结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
public class TreeDepth {
  public static int treeDepthRecursively(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = treeDepthRecursively(root.left);
    int right = treeDepthRecursively(root.right);
    return (left > right) ? left + 1 : right + 1;
  }

  public static int treeDepthIteratively(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int depth = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      depth++;
    }

    return depth;
  }

  public static void main(String[] args) {
    //            1
    //         /     \
    //        2        3
    //       /\         \
    //      4  5         6
    //        /
    //       7
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.right.left = new TreeNode(7);
    root.right = new TreeNode(3);
    root.right.right = new TreeNode(6);
    System.out.println(treeDepthRecursively(root)); // 4
    System.out.println(treeDepthIteratively(root));
  }
}
