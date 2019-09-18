package com.vkbr;

import java.util.ArrayList;

public class InsertInterval {
  public static void print(int[] inv) {
    System.out.printf("\n[%d,%d]", inv[0], inv[1]);
  }
  public static boolean test() {
    InsertInterval ins = new InsertInterval();

    int[][] inp1 = new int[][]{
      new int[]{1,3},
      new int[]{6,9},
    };
    int[] int2 = new int[]{2,5};
    int[][] expect = new int[][]{
      new int[]{1,5},
      new int[]{6,9},
    };

    System.out.print("Out: {");
    for (int[] i:inp1) InsertInterval.print(i);
    System.out.print("\n}, {");
    InsertInterval.print(int2);
    System.out.print("} == {");
    for (int[] i:expect) InsertInterval.print(i);
    System.out.print("}");

    return true;
  }
  public int[][] insert(int[][] intervals, int[] newInterval) {
    int lowerIndex = 0;
    int leng = intervals.length;
    int higherIndex = leng - 1;
    boolean mergeLower = false;
    boolean mergeHigher = false;

    for (int i=0; i<leng; i++) {
      int[] interval = intervals[i];

      if (interval[0] < newInterval[0]) {
        lowerIndex = i;
      }
    }

    if (lowerIndex < leng && intervals[lowerIndex][1] > newInterval[0]) {
      mergeLower = true;
    }

    if (lowerIndex < higherIndex && intervals[lowerIndex + 1][0] < newInterval[1]) {
      mergeHigher = true;
    }

    ArrayList<int[]> res = new ArrayList();
    for (int i=0; i<leng; i++) {
      if (i == lowerIndex) {
        if (!mergeLower) {
          res.add(intervals[i]);
          res.add(newInterval);
        } else {
          res.add(new int[]{ newInterval[0], mergeHigher ? intervals[i + 1][1] : newInterval[1] });
        }
      } else if(i == lowerIndex + 1) {
        if (!mergeHigher) {
          res.add(intervals[i]);
        }
      } else {
        res.add(intervals[i]);
      }
    }

    return (int[][])res.toArray();
  }
}
