package br.com.zup.casadocodigo.model.dto;

import br.com.zup.casadocodigo.model.Autor;

public class DetalheAutorDTO {

    private String nome;
    private String descricao;

    public DetalheAutorDTO(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
