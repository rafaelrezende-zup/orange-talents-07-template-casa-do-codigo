package br.com.zup.casadocodigo.model;

import br.com.zup.casadocodigo.model.dto.NovaCategoriaDTO;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(unique=true)
    private String nome;

    public Categoria(NovaCategoriaDTO dto) {
        this.nome = dto.getNome();
    }

    @Deprecated
    public Categoria() {
    }

}
