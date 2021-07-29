package br.com.zup.casadocodigo.model;

import br.com.zup.casadocodigo.model.dto.NovoClienteDTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Email
    @Column(unique=true)
    private String email;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @Column(unique=true)
    private String documento;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cidade;

    @NotNull
    @ManyToOne
    private Pais pais;

    @ManyToOne
    private Estado estado;

    @NotBlank
    private String telefone;

    @NotBlank
    private String cep;

    public Cliente(NovoClienteDTO dto, Pais pais, Estado estado) {
        this.email = dto.getEmail();
        this.nome = dto.getNome();
        this.sobrenome = dto.getSobrenome();
        this.documento = dto.getDocumento();
        this.endereco = dto.getEndereco();
        this.complemento = dto.getComplemento();
        this.cidade = dto.getCidade();
        this.pais = pais;
        this.estado = estado;
        this.telefone = dto.getTelefone();
        this.cep = dto.getCep();
    }

    @Deprecated
    public Cliente() {
    }

}
