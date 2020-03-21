package com.vkbr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SimplifyPath {
  private String source = "https://leetcode.com/problems/simplify-path/";
  public static void run() {
    SimplifyPath sp = new SimplifyPath();

    Util.assertAndPrint(sp.solve("/home/"), "/home");
    Util.assertAndPrint(sp.solve("/a/./b/../../c/"), "/c");
    Util.assertAndPrint(sp.solve("/a/../../b/../c//.//"), "/c");
    Util.assertAndPrint(sp.solve("/a//b////c/d//././/.."), "/a/b/c");
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
