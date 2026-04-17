package com.mahmud.service;

import com.mahmud.util.IdFormatter;

public class IdService {

  private final SequenceGenerator generator = new SequenceGenerator();

  public String getNextOrderId() throws Exception {
    long seq = generator.getNext(SequenceType.ORDER);
    return IdFormatter.orderId(seq);
  }

  public String getNextUserId() throws Exception {
    long seq = generator.getNext(SequenceType.USER);
    return IdFormatter.userId(seq);
  }

  public String getNextInvoiceId() throws Exception {
    long seq = generator.getNext(SequenceType.INVOICE);
    return IdFormatter.invoiceId(seq);
  }
}
