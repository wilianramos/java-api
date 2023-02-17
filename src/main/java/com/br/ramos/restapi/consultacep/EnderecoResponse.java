package com.br.ramos.restapi.consultacep;

public class EnderecoResponse {

    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    private double frete;

    public double getFrete() {

        double sudeste = 7.85;
        double centroOeste = 12.50;
        double nordeste = 15.98;
        double sul = 17.30;
        double norte = 20.83;

        double frete = 0;

        try{
            switch (estado){
                case "RS":
                case "SC":
                case "PR":
                    frete = sul;
                    break;
                case "SP":
                case "MG":
                case "RJ":
                case "ES":
                case "DF":
                    frete = sudeste;
                    break;
                case "MS":
                case "GO":
                case "MT":
                    frete = centroOeste;
                    break;
                case "TO":
                case "AC":
                case "PA":
                case "AP":
                case "RR":
                case "AM":
                case "RO":
                    frete = norte;
                    break;
                case "MA":
                case "PI":
                case "CE":
                case "RN":
                case "PE":
                case "PB":
                case "SE":
                case "AL":
                case "BA":
                    frete = nordeste;
                    break;

            }
        }
        catch (Exception ex){
            frete = 0;
        }

        return  frete;

    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
