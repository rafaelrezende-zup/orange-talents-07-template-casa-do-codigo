package br.com.zup.casadocodigo.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NovoAutorDTO {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @Size(max=400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

}
