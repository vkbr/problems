package com.vkbr;

public class Util {
  public static void assertAndPrint(String source, String toEquals) {
    System.out.println(source + " -> " + toEquals);
    assert source.equals(toEquals);
  }
}
