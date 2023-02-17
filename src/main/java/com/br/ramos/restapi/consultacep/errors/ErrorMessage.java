package com.br.ramos.restapi.consultacep.errors;

public class ErrorMessage {

    private String message;
    private int codigo;

    public ErrorMessage() {
    }

    public ErrorMessage(String message, int codigo) {
        this.message = message;
        this.codigo = codigo;
    }
}
