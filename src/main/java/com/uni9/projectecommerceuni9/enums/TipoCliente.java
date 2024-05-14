package com.uni9.projectecommerceuni9.enums;

public enum TipoCliente {

    CLIENTE_PJ("PJ"),
    CLIENTE_PF("PF");

    private String tipoDeCliente;

    TipoCliente(String tipoDeCliente){
        this.tipoDeCliente = tipoDeCliente;
    }

    public String getTipoCliente(){
        return tipoDeCliente;
    }
}
