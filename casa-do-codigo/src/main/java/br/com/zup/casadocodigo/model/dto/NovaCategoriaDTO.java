package br.com.zup.casadocodigo.model.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NovaCategoriaDTO {

    @NotNull
    @NotEmpty
    private String nome;

    public String getNome() {
        return nome;
    }
}
