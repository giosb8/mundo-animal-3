package com.senai.infob.mundoanimal.models;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JCheckBox;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="Postagem")
public class Postagem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="titulo")
    private String titulo;

    @Column(name="descricao")
    private String descricao;

    @Column(name="localizacao")
    private String localizacao;//jjjj

    @Column(name="tel_contato")
    private String telContato;

    @Lob
    @Column(name="imagem")
    private byte[] imagem;

    @Column(name="data_hora")
    private LocalDate dataHora;

    @Column(name="paginas")
    private Boolean paginas;


    // @ManyToMany
    // @JoinTable(
    //     name = "postagem_usuario",
    //     joinColumns = @JoinColumn(name = "postagem_id", referencedColumnName = "id"),
    //     inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    // )
    // private List<Postagem> postagem;

    
    public Postagem() {
    }


    public Postagem(Integer id, String titulo, String descricao, String localizacao, String telContato, byte[] imagem,
            LocalDate dataHora, Boolean paginas) {
        id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.telContato = telContato;
        this.imagem = imagem;
        this.dataHora = dataHora;
        this.paginas = paginas;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getLocalizacao() {
        return localizacao;
    }


    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }


    public String getTelContato() {
        return telContato;
    }


    public void setTelContato(String telContato) {
        this.telContato = telContato;
    }


    public byte[] getImagem() {
        return imagem;
    }


    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }


    public LocalDate getDataHora() {
        return dataHora;
    }


    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }


    public Boolean getPaginas() {
        return paginas;
    }


    public void setPaginas(Boolean paginas) {
        this.paginas = paginas;
    }
}