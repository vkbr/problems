package com.vkbr.lc2020.april;

import com.vkbr.ListNode;

public class LLMiddle {
  public static void run() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
//    head.next.next.next.next.next = new ListNode(6);

    ListNode mid = LLMiddle.solution(head);
    System.out.println(mid.val);
  }
  public static ListNode solution(ListNode head) {
    ListNode cent = head;
    ListNode lead = head.next;

    if (lead == null) return head;
    if (lead.next == null) return lead;

//    boolean incr = false;

    while (lead != null) {
      lead = lead.next;
//      incr = true;
      if (lead != null) {
//        incr = false;
        lead = lead.next;
      }
      cent = cent.next;
    }

//    if (incr) {
//      cent = cent.next;
//    }

    return cent;
  }
}
