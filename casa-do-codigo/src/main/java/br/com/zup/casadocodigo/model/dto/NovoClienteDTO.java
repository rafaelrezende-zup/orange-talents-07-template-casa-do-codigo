package br.com.zup.casadocodigo.model.dto;

import br.com.zup.casadocodigo.model.Cliente;
import br.com.zup.casadocodigo.model.Estado;
import br.com.zup.casadocodigo.model.Pais;
import br.com.zup.casadocodigo.validator.Exist;
import br.com.zup.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoClienteDTO {

    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    @Email
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @Exist(domainClass = Pais.class)
    private Long idPais;

    @Exist(domainClass = Estado.class)
    private Long idEstado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
