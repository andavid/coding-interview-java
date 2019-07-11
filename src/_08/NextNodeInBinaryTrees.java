package _08;

public class NextNodeInBinaryTrees {
  /**
   * 给定二叉树和其中一个节点，找到中序遍历序列的下一个节点。
   * 树中的节点除了有左右孩子指针，还有一个指向父节点的指针。
   *
   * 1. 如果当前节点有右孩子，下一个节点为右子树最左边的节点
   * 2. 如果当前节点没有右孩子，判断与其父亲节点的关系
   *   2.1 如果当前节点没有父亲节点，不存在下一个节点
   *   2.1 如果当前节点是其父亲节点的左孩子，下一个节点为其父亲节点
   *   2.2 如果当前节点是其父亲节点的右孩子，将父亲节点作为新的当前节点，回到 2
   */
  public static TreeNode getNext(TreeNode node) {
    if (node == null) {
      return null;
    }

    if (node.right != null) {
      node = node.right;
      while (node.left != null) {
        node = node.left;
      }
      return node;
    }

    while (node.father != null) {
      if (node.father.left == node) {
        return node.father;
      }
      node = node.father;
    }

    return null;
  }

  public static void main(String[] args) {
    //            1
    //          // \\
    //         2     3
    //       // \\
    //      4     5
    //    inorder -> 42513
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.father = root;
    root.right = new TreeNode(3);
    root.right.father = root;
    root.left.left = new TreeNode(4);
    root.left.left.father = root.left;
    root.left.right = new TreeNode(5);
    root.left.right.father = root.left;

    System.out.println(getNext(root.left.left).val); // 2
    System.out.println(getNext(root.left).val); // 5
    System.out.println(getNext(root.left.right).val); // 1
    System.out.println(getNext(root).val); // 3
    System.out.println(getNext(root.right)); // null
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode father;

    public TreeNode(int val) {
      this.val = val;
    }
  }
}
