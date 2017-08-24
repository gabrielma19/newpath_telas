package com.example.user.newpath.model;

/**
 * Created by Gabriel Marcos on 16/08/2017.
 */

public class Itens {

    private int cresPessoal;
    private int carreira;
    private int financa;
    private int saude;
    private int amigos;
    private int relFamiliar;
    private int relAfetivo;
    private int divercao;
    private int contColetivo;
    private int espiritualidade;

    public Itens() {
    }

    public Itens(int cresPessoal, int carreira, int financa, int saude, int amigos, int relFamiliar, int relAfetivo, int divercao, int contColetivo, int espiritualidade) {
        this.cresPessoal = cresPessoal;
        this.carreira = carreira;
        this.financa = financa;
        this.saude = saude;
        this.amigos = amigos;
        this.relFamiliar = relFamiliar;
        this.relAfetivo = relAfetivo;
        this.divercao = divercao;
        this.contColetivo = contColetivo;
        this.espiritualidade = espiritualidade;
    }

    public int getCresPessoal() {
        return cresPessoal;
    }

    public void setCresPessoal(int cresPessoal) {
        this.cresPessoal = cresPessoal;
    }

    public int getCarreira() {
        return carreira;
    }

    public void setCarreira(int carreira) {
        this.carreira = carreira;
    }

    public int getFinanca() {
        return financa;
    }

    public void setFinanca(int financa) {
        this.financa = financa;
    }

    public int getSaude() {
        return saude;
    }

    public void setSaude(int saude) {
        this.saude = saude;
    }

    public int getAmigos() {
        return amigos;
    }

    public void setAmigos(int amigos) {
        this.amigos = amigos;
    }

    public int getRelFamiliar() {
        return relFamiliar;
    }

    public void setRelFamiliar(int relFamiliar) {
        this.relFamiliar = relFamiliar;
    }

    public int getRelAfetivo() {
        return relAfetivo;
    }

    public void setRelAfetivo(int relAfetivo) {
        this.relAfetivo = relAfetivo;
    }

    public int getDivercao() {
        return divercao;
    }

    public void setDivercao(int divercao) {
        this.divercao = divercao;
    }

    public int getContColetivo() {
        return contColetivo;
    }

    public void setContColetivo(int contColetivo) {
        this.contColetivo = contColetivo;
    }

    public int getEspiritualidade() {
        return espiritualidade;
    }

    public void setEspiritualidade(int espiritualidade) {
        this.espiritualidade = espiritualidade;
    }
}
