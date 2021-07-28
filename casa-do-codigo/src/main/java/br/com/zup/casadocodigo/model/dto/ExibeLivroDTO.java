package br.com.zup.casadocodigo.model.dto;

import br.com.zup.casadocodigo.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ExibeLivroDTO {

    private Long id;
    private String titulo;
    private String resumo;
    private BigDecimal preco;
    private Integer nPag;
    private String isbn;
    private LocalDate dataPublicacao;
    private ExibeCategoriaDTO categoria;
    private ExibeAutorDTO autor;

    public ExibeLivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.preco = livro.getPreco();
        this.nPag = livro.getnPag();
        this.isbn = livro.getIsbn();
        this.dataPublicacao = livro.getDataPublicacao();
        this.categoria = new ExibeCategoriaDTO(livro.getCategoria());
        this.autor = new ExibeAutorDTO(livro.getAutor());
    }

    @Deprecated
    public ExibeLivroDTO() {
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public ExibeCategoriaDTO getCategoria() {
        return categoria;
    }

    public ExibeAutorDTO getAutor() {
        return autor;
    }

    public static List<ExibeLivroDTO> toDto(List<Livro> livroList) {
        return livroList.stream().map(ExibeLivroDTO::new).collect(Collectors.toList());
    }
}
