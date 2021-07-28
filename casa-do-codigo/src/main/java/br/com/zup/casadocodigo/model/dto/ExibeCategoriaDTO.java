package br.com.zup.casadocodigo.model.dto;

import br.com.zup.casadocodigo.model.Categoria;

public class ExibeCategoriaDTO {

    private Long id;
    private String nome;

    public ExibeCategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
