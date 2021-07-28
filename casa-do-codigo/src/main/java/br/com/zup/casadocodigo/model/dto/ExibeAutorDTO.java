package br.com.zup.casadocodigo.model.dto;

import br.com.zup.casadocodigo.model.Autor;

public class ExibeAutorDTO {

    private Long id;
    private String nome;
    private String email;

    public ExibeAutorDTO(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
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
}
