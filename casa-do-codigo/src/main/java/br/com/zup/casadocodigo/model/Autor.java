package br.com.zup.casadocodigo.model;

import br.com.zup.casadocodigo.model.dto.NovoAutorDTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @Email
    @Column(unique=true)
    private String email;

    @NotNull
    @NotEmpty
    @Size(max=400)
    @Column(length=400)
    private String descricao;

    private LocalDateTime dataRegistro;

    public Autor(NovoAutorDTO dto) {
        this.nome = dto.getNome();
        this.email = dto.getEmail();
        this.descricao = dto.getDescricao();
        this.dataRegistro = LocalDateTime.now();
    }

    @Deprecated
    public Autor() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
