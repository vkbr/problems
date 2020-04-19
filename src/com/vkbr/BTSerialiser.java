package com.vkbr;

import com.vkbr.util.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class BTSerialiser {
  public static void run() {
    BTSerialiser bt = new BTSerialiser();

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.right.left = new Node(4);
    root.right.right = new Node(5);

    System.out.println(bt.serialize(bt.deserialize("1")));
  }

  public String serialize(Node root) {
    ArrayList<Node> vals = new ArrayList();
    int cur = 0;
    int lastNonNull = root != null ? 1 : 0;

    vals.add(root);

    while (cur <= lastNonNull) {
      if (vals.get(cur) == null) {
        vals.add(null);
        vals.add(null);
      } else {
        Node t = vals.get(cur).left;
        vals.add(t);
        if (t != null) {
          lastNonNull = vals.size();
        }

        t = vals.get(cur).right;
        vals.add(t);
        if (t != null) {
          lastNonNull = vals.size();
        }
      }
      cur++;
    }

    List<String> serialized = vals
      .stream()
      .map(n -> n == null ? "Null" : String.valueOf(n.val))
      .collect(Collectors.toList())
      .subList(0, lastNonNull);

    return String.join(",", serialized);
  }

  public Node deserialize(String data) {
    if (data.isEmpty()) {
      return null;
    }
    List<Node> inputs = Arrays
      .stream(data.split(","))
      .map(s -> s.equals("Null") ? null : Integer.valueOf(s))
      .map(i -> i == null ? null : new Node(i))
      .collect(Collectors.toList());

    int len = inputs.size();
    Node root = inputs.get(0);
    Node t;

    for (int i=0; i < len / 2; i++) {
      t = inputs.get(i);
      int j = i * 2;
      if (t != null) {
        t.left = j+1 < len ? inputs.get(j+1) : null;
        t.right = j+2 < len ? inputs.get(j+2) : null;
      }
    }

    return root;
  }
}
