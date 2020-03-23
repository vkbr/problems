package com.vkbr.util;

public class Test {
  public static void assertAndPrint(String source, String toEquals) {
    System.out.println(source + " -> " + toEquals);
    assert source.equals(toEquals);
  }
}
