package com.example.user.newpath.model;

/**
 * Created by jussi on 10/4/17.
 */

public class Challenge {

    private static Challenge challenge;

    private String mais;
    private String valor;
    private String local;
    private String label;
    private String tempo;
    private String status;
    private String titulo;
    private String validacao;
    private String categoria;
    private String descricao;

    public static Challenge instance(){
        if(challenge != null )
            return challenge;
        else
            challenge = new Challenge();
        return challenge;
    }

    public Challenge() {
    }

    public String getMais() {
        return mais;
    }

    public void setMais(String mais) {
        this.mais = mais;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getValidacao() {
        return validacao;
    }

    public void setValidacao(String validacao) {
        this.validacao = validacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
