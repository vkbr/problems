package com.vkbr.lc2020.april;

import java.util.Stack;

public class MinStack {

  public static void run() {
    MinStack s = new MinStack();
    s.push(-2);
    s.push(0);
    s.push(-3);
    System.out.println(s.getMin());
    s.pop();
    System.out.println(s.top());
    System.out.println(s.getMin());
  }

  class Node {
    int val, min;
    public Node(int val, int min) {
      this.val = val;
      this.min = min;
    }
  }

  Stack<Node> minStack;

  /** initialize your data structure here. */
  public MinStack() {
    minStack = new Stack<>();
  }

  public void push(int x) {
    int min = minStack.size() == 0 || x < minStack.peek().min ? x : minStack.peek().min;
    String s = "sdfs";
    minStack.add(new Node(x, min));
  }

  public void pop() {
    if (minStack.size() > 0)
      minStack.pop();
  }

  public int top() {
    return minStack.peek().val;
  }

  public int getMin() {
    return minStack.peek().min;
  }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */