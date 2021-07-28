package br.com.zup.casadocodigo.model;

import br.com.zup.casadocodigo.model.dto.NovoPaisDTO;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique=true)
    private String nome;

    public Pais(NovoPaisDTO dto) {
        this.nome = dto.getNome();
    }

    @Deprecated
    public Pais() {
    }

}
