package com.vkbr;

import com.vkbr.util.Node;
import com.vkbr.util.Test;

public class BinTreeUpsideDown {

  public static void run() {
    Node rt = new Node(1);
    rt.left = new Node(2);
    rt.right = new Node(3);

    rt.left.left = new Node(4);
    rt.left.right = new Node(5);

    BinTreeUpsideDown bt = new BinTreeUpsideDown();
    Node sol = bt.solve(rt);
    Node.prePrint(sol);
  }

  private Node rt;

  private void op(Node root, Node olParent, Node oldRt) {
    if (root == null) return;

    Node lt = root.left;
    Node rt = root.right;

    root.left = oldRt;
    root.right = olParent;

    if (lt != null)
      op(lt, root, rt);
    else
      this.rt = root;
  }

  public Node solve(Node root) {

    this.op(root, null, null);

    return this.rt;
  }
}
