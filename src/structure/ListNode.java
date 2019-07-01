package structure;

public class ListNode<T> {
  public T val;
  public ListNode<T> next;

  public ListNode(T val) {
    this.val = val;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (ListNode<T> p = this; p != null; p = p.next) {
      sb.append(p.val);
      if (p.next != null) {
        sb.append(",");
      }
    }
    sb.append("]");
    return sb.toString();
  }

}