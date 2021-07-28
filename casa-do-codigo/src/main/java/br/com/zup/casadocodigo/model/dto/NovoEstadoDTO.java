package br.com.zup.casadocodigo.model.dto;

import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.validator.Exist;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoEstadoDTO {

    @NotBlank
    private String nome;

    @NotNull
    @Exist(domainClass = Pais.class, message = "O País desejado não existe.")
    private Long idPais;

    public String getNome() {
        return nome;
    }

    public Long getIdPais() {
        return idPais;
    }
}
