package _32;

import java.util.Stack;

import structure.TreeNode;

// 之字形打印二叉树
// 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺
// 序打印，第二行按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，
// 其他行以此类推。
public class PrintTreesInZigzag {
  public static void printInZigzag(TreeNode root) {
    if (root == null) {
      return;
    }

    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();
    stack1.push(root);

    while (!stack1.empty() || !stack2.empty()) {
      if (!stack1.empty()) {
        while (!stack1.empty()) {
          TreeNode node = stack1.pop();
          System.out.print(node.val);
          System.out.print('\t');

          if (node.left != null) {
            stack2.push(node.left);
          }
          if (node.right != null) {
            stack2.push(node.right);
          }
        }
      } else {
        while (!stack2.empty()) {
          TreeNode node = stack2.pop();
          System.out.print(node.val);
          System.out.print('\t');

          if (node.right != null) {
            stack1.push(node.right);
          }
          if (node.left != null) {
            stack1.push(node.left);
          }
        }
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    //            1
    //          /   \
    //         2     3
    //       /  \   / \
    //      4    5 6   7
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    printInZigzag(root);
  }
}
