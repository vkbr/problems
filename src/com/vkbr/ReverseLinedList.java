package com.vkbr;

public class ReverseLinedList {
  static boolean test() {
    ReverseLinedList rev = new ReverseLinedList();

    ListNode l = new ListNode(1);
    l.add(new ListNode(2))
      .add(new ListNode(3))
      .add(new ListNode(4))
      .add(new ListNode(5));
    String expected = "[5->4->3->2->1]";
    ListNode res = rev.reverseList(l);

    if (!res.toString().equals(expected)) {
      System.out.printf("Expected %s, got %s\n", expected, res.toString());
      return false;
    } else {
      System.out.printf("reverse(%s) == %s\n", l.toString(), res.toString());
    }

    return true;
  }

  public ListNode reverseList(ListNode head) {
    ListNode current, prev, temp;
    current = head.next;
    prev = head;

    prev.next = null;

    while(true) {
      temp = current.next;
      current.next = prev;
      prev = current;
      if (temp == null) {
        break;
      } else {
        current = temp;
      }
    };

    return current;
  }
}


