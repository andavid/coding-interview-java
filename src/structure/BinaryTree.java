package structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
  public static List<Integer> preorderIteratively(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;

    while (p != null || !stack.empty()) {
      while (p != null) {
        list.add(p.val);
        stack.push(p);
        p = p.left;
      }
      p = stack.pop();
      p = p.right;
    }

    return list;
  }

  public static List<Integer> inorderIteratively(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;

    while (p != null || !stack.empty()) {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      p = stack.pop();
      list.add(p.val);
      p = p.right;
    }

    return list;
  }

  public static List<Integer> postorderIteratively(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    TreeNode last = null;

    while (cur != null || !stack.empty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.peek();
      if (cur.right == null || cur.right == last) {
        list.add(cur.val);
        stack.pop();
        last = cur;
        cur = null;
      } else {
        cur = cur.right;
      }
    }

    return list;
  }

  public static void main(String[] args) {
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    node1.left = node2;
    node1.right = node3;
    node2.left = node4;
    node2.right = node5;

    //            1
    //          /   \
    //         2     3
    //        / \
    //       4   5

    System.out.println(preorderIteratively(node1)); // 1,2,4,5,3
    System.out.println(inorderIteratively(node1));  // 4,2,5,1,3
    System.out.println(postorderIteratively(node1));// 4,5,2,3,1
  }
}
