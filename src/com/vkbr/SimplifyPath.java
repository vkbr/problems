package com.vkbr;

import com.vkbr.util.Test;

import java.util.ArrayList;

public class SimplifyPath {
  private String source = "https://leetcode.com/problems/simplify-path/";
  public static void run() {
    SimplifyPath sp = new SimplifyPath();

    Test.assertAndPrint(sp.solve("/home/"), "/home");
    Test.assertAndPrint(sp.solve("/a/./b/../../c/"), "/c");
    Test.assertAndPrint(sp.solve("/a/../../b/../c//.//"), "/c");
    Test.assertAndPrint(sp.solve("/a//b////c/d//././/.."), "/a/b/c");
  }
  public String solve(String path) {
    String[] dirs = path.split("/");
    ArrayList<String> res = new ArrayList();

    for (String s: dirs) {
      if (s.isEmpty() || s.equals(".")) {
        // no op
      } else if (s.equals("..")) {
        int siz = res.size();
        if (siz > 0)
          res.remove(siz - 1);
      } else {
        res.add(s);
      }
    }

    return "/" + String.join("/", res);
  }
}
