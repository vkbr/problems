package com.vkbr;

public class ListNode {
  int val;
  ListNode next;
  private ListNode l;

  ListNode(int val) {
    this.val = val;
    this.next = null;
    this.l = this;
  }

  public String toString() {
    StringBuilder str = new StringBuilder("[");
    ListNode n = this;
    while (n != null) {
      str.append(n.val);
      str.append(n.next == null ? "" : "->");
      n = n.next;
    }
    str.append("]");

    return str.toString();
  }

  public void print() {
    System.out.print(this.toString());
  }

  ListNode add(ListNode n) {
    l.next = n;
    this.l = n;

    return n;
  }
}
