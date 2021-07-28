package br.com.zup.casadocodigo.model.dto;

import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovoPaisDTO {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "Já existe um país com este nome.")
    private String nome;

    public String getNome() {
        return nome;
    }
}
