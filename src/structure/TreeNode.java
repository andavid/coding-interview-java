package structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }

  @Override
  public String toString() {
    List<String> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(this);

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

    for (int i = list.size() - 1; i >= 0; i--) {
      if (list.get(i).equals("null")) {
        list.remove(i);
      } else {
        break;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append("[");
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
}
