package _32;

import java.util.LinkedList;
import java.util.Queue;

import structure.TreeNode;

// 不分行从上往下打印二叉树
// 从上往下打印出二叉树的每个结点，同一层的结点按照从左到右的顺序打印。
public class PrintTreeFromTopToBottom {
  public static void printFromTopToBottom(TreeNode root) {
    if (root == null) {
      return;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      System.out.print(node.val);
      System.out.print('\t');

      if (node.left != null) {
        queue.offer(node.left);
      }
      if (node.right != null) {
        queue.offer(node.right);
      }
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

    printFromTopToBottom(root);
  }
}
