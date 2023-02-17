package com.br.ramos.restapi.consultacep;

import javax.validation.constraints.Pattern;

public class EnderecoRequest {

    @Pattern(regexp = "([0-9]{8}|[0-9]{5}?-?[0-9]{3})", message = "CEP inválido")
    private  String cep;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
