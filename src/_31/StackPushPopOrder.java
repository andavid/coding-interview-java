package _31;

import java.util.Stack;

public class StackPushPopOrder {
  /**
   * 输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是否为该栈的弹出序序列。
   * 假设压入栈的所有数字均不相等。
   * 例如，压入序列为(1,2,3,4,5)，序列(4,5,3,2,1)是它的弹出序列，而(4,3,5,1,2)不是。
   */
  public static boolean isPopOrder(int[] pushSeq, int[] popSeq) {
    if (pushSeq == null || popSeq == null || pushSeq.length != popSeq.length) {
      return false;
    }

    Stack<Integer> stack = new Stack<>();
    int pushSeqIndex = 0, popSeqIndex = 0;
    while (popSeqIndex < popSeq.length) {
      if (stack.empty() || stack.peek() != popSeq[popSeqIndex]) {
        if (pushSeqIndex < pushSeq.length) {
          stack.push(pushSeq[pushSeqIndex++]);
        } else {
          return false;
        }
      } else {
        stack.pop();
        popSeqIndex++;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    int[] push = {1,2,3,4,5};
    int[] pop1 = {4,5,3,2,1};
    int[] pop2 = {4,3,5,1,2};
    System.out.println(isPopOrder(push,pop1));
    System.out.println(isPopOrder(push,pop2));
  }
}
