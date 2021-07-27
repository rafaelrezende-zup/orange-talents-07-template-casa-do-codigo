package br.com.zup.casadocodigo.model.dto;

import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaDTO {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Já existe um cadastro com este nome.")
    private String nome;

    public String getNome() {
        return nome;
    }
}
