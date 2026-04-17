package com.mahmud;

import com.mahmud.service.IdService;

public class App {
  public static void main(String[] args) {
    IdService service = new IdService();

    try {
      System.out.println(service.getNextOrderId());
      System.out.println(service.getNextOrderId());
      System.out.println(service.getNextUserId());
      System.out.println(service.getNextInvoiceId());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
