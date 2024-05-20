package com.uni9.projectecommerceuni9.enums;

public enum StatusPedido {
  EM_ABERTO("EM ABERTO"),
  FINALIZADO("FINALIZADO");

  private String statusPedido;

  StatusPedido(String statusPedido) {
    this.statusPedido = statusPedido;
  }

  public String getStatusPedido() {
    return statusPedido;
  }
}
