package br.com.zup.casadocodigo.model;

import br.com.zup.casadocodigo.model.dto.NovoEstadoDTO;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @ManyToOne
    private Pais pais;

    public Estado(NovoEstadoDTO dto, Pais pais) {
        this.nome = dto.getNome();
        this.pais = pais;
    }

    @Deprecated
    public Estado() {
    }

}
