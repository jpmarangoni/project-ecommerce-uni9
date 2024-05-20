package com.uni9.projectecommerceuni9.enums;

public enum StatusCarrinho {
    TEM_CARRINHO("TEM CARRINHO"),
    NAO_TEM_CARRINHO("NAO TEM CARRINHO");

    private String statusCarrinho;

    StatusCarrinho(String statusCarrinho) {
        this.statusCarrinho = statusCarrinho;
    }

    public String getStatusCarrinho() {
        return statusCarrinho;
    }
}
