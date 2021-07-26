package br.com.zup.casadocodigo.model.dto;

import br.com.zup.casadocodigo.model.Autor;

public class AutorDTO {

    private final Long id;
    private final String nome;
    private final String email;
    private final String descricao;

    public AutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
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
}
