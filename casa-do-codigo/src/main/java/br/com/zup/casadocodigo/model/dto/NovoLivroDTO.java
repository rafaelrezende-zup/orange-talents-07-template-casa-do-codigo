package br.com.zup.casadocodigo.model.dto;

import br.com.zup.casadocodigo.model.Autor;
import br.com.zup.casadocodigo.model.Categoria;
import br.com.zup.casadocodigo.model.Livro;
import br.com.zup.casadocodigo.validator.Exist;
import br.com.zup.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroDTO {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
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
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataPublicacao;

    @NotNull
    @Exist(domainClass = Categoria.class, message = "A Categoria desejada não existe.")
    private Long idCategoria;

    @NotNull
    @Exist(domainClass = Autor.class, message = "O Autor desejado não existe.")
    private Long idAutor;

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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }
}
