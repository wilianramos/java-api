package com.br.ramos.restapi.consultacep;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/v1")
public class EnderecoController {
    @GetMapping("/consulta-endereco")
    public ResponseEntity consultaCep(@RequestBody EnderecoRequest request) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<CepResultDto> response =
                restTemplate.getForEntity(
                        String.format("https://viacep.com.br/ws/%s/json/", request.getCep()),
                        CepResultDto.class);

        final CepResultDto consulta = response.getBody();
        if (response.getStatusCode() != HttpStatus.OK || consulta.getErro() == true) {
            return new ResponseEntity("CEP não encontrado!!", HttpStatus.NOT_FOUND);
        }

        final EnderecoResponse result = new EnderecoResponse();

        result.setCep(consulta.getCep());
        result.setRua(consulta.getLogradouro());
        result.setComplemento(consulta.getComplemento());
        result.setBairro(consulta.getBairro());
        result.setCidade(consulta.getLocalidade());
        result.setEstado(consulta.getUf());

        return ResponseEntity.ok(result);
    }

}
