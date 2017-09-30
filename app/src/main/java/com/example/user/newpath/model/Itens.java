package com.example.user.newpath.model;

import com.example.user.newpath.DAO.FirebaseConfig;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gabriel Marcos on 16/08/2017.
 */

public class Itens {

    private static Itens itens;


    private int saude;
    private String id;
    private int amigos;
    private int financa;
    private int divercao;
    private int carreira;
    private int relAfetivo;
    private int relFamiliar;
    private int cresPessoal;
    private int contColetivo;
    private int espiritualidade;

    public Itens() {
    }

    public static Itens instance(){
        if(itens != null )
            return itens;
        else
            itens = new Itens();
        return itens;
    }

    public void salvarDados(){
        DatabaseReference reference = FirebaseConfig.getFirebase();
        reference.child("repostas").child(String.valueOf(User.instance().getId())).setValue(this);
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> hashMapUser = new HashMap<>();

        hashMapUser.put("id", User.instance().getId());
        hashMapUser.put("saude", getSaude());
        hashMapUser.put("amigos", getAmigos());
        hashMapUser.put("financa", getFinanca());
        hashMapUser.put("divercao", getDivercao());
        hashMapUser.put("carreira", getCarreira());
        hashMapUser.put("relAfetivo", getRelAfetivo());
        hashMapUser.put("relFamiliar", getRelFamiliar());
        hashMapUser.put("cresPessoal", getCresPessoal());
        hashMapUser.put("contColetivo", getContColetivo());
        hashMapUser.put("espiritualidade", getEspiritualidade());
        return hashMapUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
