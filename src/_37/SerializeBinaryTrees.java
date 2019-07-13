package _37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import structure.TreeNode;

// 序列化二叉树
// 请实现两个函数，分别用来序列化和反序列化二叉树。
public class SerializeBinaryTrees {
  public static String serialize(TreeNode root) {
    if (root == null) {
      return "[]";
    }

    List<String> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      if (node == null) {
        list.add("null");
        continue;
      } else {
        list.add("" + node.val);
      }

      if (node.left != null) {
        queue.offer(node.left);
      } else {
        queue.offer(null);
      }

      if (node.right != null) {
        queue.offer(node.right);
      } else {
        queue.offer(null);
      }
    }

    // 移除末尾的 null
    for (int i = list.size() - 1; i >= 0; i--) {
      if (list.get(i).equals("null")) {
        list.remove(i);
      } else {
        break;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i < list.size(); i++) {
      sb.append(list.get(i));
      if (i == list.size() - 1) {
        sb.append("]");
      } else {
        sb.append(", ");
      }
    }

    return sb.toString();
  }

  public static TreeNode deserialize(String data) {
    if (data == null || data.equals("[]") || data.length() <= 2) {
      return null;
    }

    String[] strArray = data.substring(1, data.length() - 1).split(",");
    Queue<String> list = new LinkedList<>();
    list.addAll(Arrays.asList(strArray));

    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode root = new TreeNode(Integer.valueOf(list.poll().trim()));
    queue.offer(root);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();

      String leftVal = list.poll();
      if (leftVal == null || leftVal.trim().equals("null")) {
        node.left = null;
      } else {
        TreeNode leftNode = new TreeNode(Integer.valueOf(leftVal.trim()));
        node.left = leftNode;
        queue.offer(leftNode);
      }

      String rightVal = list.poll();
      if (rightVal == null || rightVal.trim().equals("null")) {
        node.right = null;
      } else {
        TreeNode rightNode = new TreeNode(Integer.valueOf(rightVal.trim()));
        node.right = rightNode;
        queue.offer(rightNode);
      }
    }

    return root;
  }

  public static void main(String[] args) {
    //            1
    //          /   \
    //         2     3
    //       /      / \
    //      4      5   6
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);

    System.out.println(root);
    System.out.println(serialize(root));
    System.out.println(deserialize(serialize(root)));
  }
}
