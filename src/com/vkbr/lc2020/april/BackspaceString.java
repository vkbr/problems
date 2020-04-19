package com.vkbr.lc2020.april;

import java.util.Stack;

public class BackspaceString {
  public static boolean backspaceCompare(String S, String T) {
    Stack<Character> s = new Stack<>();
    Stack<Character> t = new Stack<>();

    int i=0;
    int ctr = 0;

    for (i=0; i<S.length(); i++) {
      if (S.charAt(i) == '#') {
        if (ctr > 0) {
          ctr--;
          s.pop();
        }
      } else {
        s.add(S.charAt(i));
        ctr++;
      }
    }

    ctr = 0;
    for (i=0; i<T.length(); i++) {
      if (T.charAt(i) == '#') {
        if (ctr > 0) {
          ctr--;
          t.pop();
        }
      } else {
        ctr++;
        t.add(T.charAt(i));
      }
    }

    if (s.size() != t.size()) return false;

    int siz = s.size();

    while (siz > 0) {
      siz--;
      if (s.pop() != t.pop()) {
        return false;
      }
    }

    return true;
  }
}
