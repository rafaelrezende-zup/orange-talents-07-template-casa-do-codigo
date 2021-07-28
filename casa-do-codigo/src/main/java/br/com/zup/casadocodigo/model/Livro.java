package br.com.zup.casadocodigo.model;

import br.com.zup.casadocodigo.model.dto.NovoLivroDTO;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(unique=true)
    private String titulo;

    @NotBlank
    private String resumo;

    private String sumario;

    @NotNull
    @DecimalMin(value = "20.0")
    private BigDecimal preco;

    @NotNull
    @Min(value = 100)
    private Integer nPag;

    @NotBlank
    @Column(unique=true)
    private String isbn;

    private LocalDate dataPublicacao;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Autor autor;

    public Livro(NovoLivroDTO dto, Categoria categoria, Autor autor) {
        this.titulo = dto.getTitulo();
        this.resumo = dto.getResumo();
        this.sumario = dto.getSumario();
        this.preco = dto.getPreco();
        this.nPag = dto.getnPag();
        this.isbn = dto.getIsbn();
        this.dataPublicacao = dto.getDataPublicacao();
        this.categoria = categoria;
        this.autor = autor;
    }

    @Deprecated
    public Livro() {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getSumario() {
        return sumario;
    }
}
