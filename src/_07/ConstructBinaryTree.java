package _07;

import java.util.HashMap;

import structure.BinaryTree;
import structure.TreeNode;

public class ConstructBinaryTree {
  public static HashMap<Integer, Integer> inMap = new HashMap<>();

  public static TreeNode construct(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null || preorder.length != inorder.length) {
      return null;
    }

    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
    }

    return helper(preorder, 0, 0, inorder.length - 1);
  }

  public static TreeNode helper(int[] preorder, int preIndex, int inStart, int inEnd) {
    if (preIndex > preorder.length - 1 || inStart > inEnd) {
      return null;
    }

    TreeNode root = new TreeNode(preorder[preIndex]);
    int inIndex = inMap.get(root.val);
    int leftTreeSize = inIndex - inStart;

    root.left = helper(preorder, preIndex + 1, inStart, inIndex - 1);
    root.right = helper(preorder, preIndex + leftTreeSize + 1, inIndex + 1, inEnd);

    return root;
  }

  public static void main(String[] args) {
    int[] pre = {1, 2, 4, 5, 3};
    int[] in = {4, 2, 5, 1, 3};
    TreeNode root = construct(pre, in);
    System.out.println(BinaryTree.preorderIteratively(root));
    System.out.println(BinaryTree.inorderIteratively(root));
  }

}
