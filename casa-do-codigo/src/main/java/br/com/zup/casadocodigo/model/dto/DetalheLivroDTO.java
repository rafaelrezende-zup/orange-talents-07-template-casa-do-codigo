package br.com.zup.casadocodigo.model.dto;

import br.com.zup.casadocodigo.model.Livro;

import java.math.BigDecimal;

public class DetalheLivroDTO {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer nPag;
    private String isbn;
    private DetalheAutorDTO autor;

    public DetalheLivroDTO(Livro livro) {
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.nPag = livro.getnPag();
        this.isbn = livro.getIsbn();
        this.autor = new DetalheAutorDTO(livro.getAutor());
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getnPag() {
        return nPag;
    }

    public String getIsbn() {
        return isbn;
    }

    public DetalheAutorDTO getAutor() {
        return autor;
    }
}
