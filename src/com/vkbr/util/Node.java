package com.vkbr.util;

import java.util.ArrayList;

public class Node {
  public Node left, right;
  final int val;

  public Node(int val) {
    this.val = val;
  }

  private static void prePrintHelper(Node root, ArrayList<String> order) {
    if (root == null) return;

    order.add(String.valueOf(root.val));
    prePrintHelper(root.left, order);
    prePrintHelper(root.right, order);
  }
  public static void prePrint(Node root) {
    ArrayList<String> order = new ArrayList();

    prePrintHelper(root, order);

    System.out.println(String.join(",", order));
  }
}
