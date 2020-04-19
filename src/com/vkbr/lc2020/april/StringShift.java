package com.vkbr.lc2020.april;

public class StringShift {
  public static void run() {
    int[][] shifts = {{0,7},{1,7},{1,0},{1,3},{0,3},{0,6},{1,2}};
    System.out.println(StringShift.solution("wpdhhcj", shifts));
  }

  public static String solution(String s, int[][] shift) {
    int rights = 0;
    int lefts = 0;

    for (int i=0; i<shift.length; i++) {
      int[] si = shift[i];
      if (si[0] == 0)  lefts += si[1];
      else rights += si[1];
    }

    int dir = rights > lefts ? 1 : 0;
    int sh = Math.abs(rights - lefts) % s.length();

    String ls = s.substring(0, sh);
    String rs = s.substring(sh);

    if (dir == 0) {
      return s.substring(sh) + s.substring(0, sh + 1);
    } else {
      return s.substring(s.length() - sh) + s.substring(0, s.length() - sh);
    }
  }
}
