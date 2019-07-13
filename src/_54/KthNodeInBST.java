package _54;

import java.util.Stack;

import structure.TreeNode;

// 二叉搜索树的第 k 个结点
// 给定一棵二叉搜索树，请找出其中的第 k 大的结点。
public class KthNodeInBST {
  public static TreeNode kthNode(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack();
    TreeNode p = root;
    int count = 0;

    while (p != null || !stack.empty()) {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      p = stack.pop();
      count++;
      if (count == k) {
        return p;
      }
      p = p.right;
    }

    return null;
  }

  public static void main(String[] args) {
    //          5
    //        /   \
    //       3      7
    //      / \    / \
    //     2   4  6   8
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(8);
    System.out.println(kthNode(root, 3).val); //4
    System.out.println(kthNode(root, 6).val); //7
    System.out.println(kthNode(root, 8)); //null
  }
}
