package _27;

import java.util.Stack;

import structure.TreeNode;

// 二叉树的镜像
// 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
public class MirrorOfBinaryTree {
  public static void mirrorRecursively(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      return;
    }

    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;

    mirrorRecursively(root.left);
    mirrorRecursively(root.right);
  }

  public static void mirrorIteratively(TreeNode root) {
    if (root == null) {
      return;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.empty()) {
      TreeNode node = stack.pop();

      TreeNode temp = node.left;
      node.left = node.right;
      node.right = temp;

      if (node.left != null) {
        stack.push(node.left);
      }

      if (node.right != null) {
        stack.push(node.right);
      }
    }
  }

  public static void main(String[] args) {
    //            8
    //        6      10
    //       5 7    9  11
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(6);
    root.right = new TreeNode(10);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(7);
    root.right.left = new TreeNode(9);
    root.right.right = new TreeNode(11);

    System.out.println(root);
    mirrorRecursively(root);
    System.out.println(root);
    mirrorIteratively(root);
    System.out.println(root);
  }
}
