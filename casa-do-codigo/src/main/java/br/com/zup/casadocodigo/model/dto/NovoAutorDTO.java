package br.com.zup.casadocodigo.model.dto;

import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorDTO {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @UniqueValue(fieldName = "email", domainClass = Autor.class, message = "Já existe um cadastro com este email.")
    private String email;

    @NotBlank
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
