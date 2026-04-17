package com.mahmud.util;

public class IdFormatter {

  // base formatter
  public static String format(String prefix, long value, int padLength) {
    String number = String.valueOf(value);

    if (number.length() < padLength) {
      number = String.format("%0" + padLength + "d", value);
    }

    return prefix + "-" + number;
  }

  // formatting methods based on usecase
  public static String orderId(long value) {
    return format("ORDER", value, 10);
  }

  public static String userId(long value) {
    return format("USER", value, 8);
  }

  public static String invoiceId(long value) {
    return format("INVOICE", value, 12);
  }
}
