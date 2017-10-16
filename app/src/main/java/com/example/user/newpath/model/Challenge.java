package com.example.user.newpath.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jussi on 10/4/17.
 */

public class Challenge {

    private static Challenge challenge;

    @SerializedName("more")
    private String mais;
    @SerializedName("value")
    private String valor;
    @SerializedName("where")
    private String local;
    @SerializedName("label")
    private String label;
    @SerializedName("time")
    private String tempo;
    @SerializedName("status")
    private String status;
    @SerializedName("title")
    private String titulo;
    @SerializedName("validation")
    private String validacao;
    @SerializedName("categoria")
    private String categoria;
    @SerializedName("descripton")
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
