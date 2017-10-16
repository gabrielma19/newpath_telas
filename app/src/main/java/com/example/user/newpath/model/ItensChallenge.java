package com.example.user.newpath.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jussi on 9/21/17.
 */

public class ItensChallenge {


    @SerializedName("time")
    private String time;
    @SerializedName("more")
    private String more;
    @SerializedName("label")
    private String label;
    @SerializedName("title")
    private String title;
    @SerializedName("where")
    private String where;
    @SerializedName("value")
    private String value;
    @SerializedName("categoria")
    private  String categoria;
    @SerializedName("validation")
    private String validation;
    @SerializedName("descripton")
    private String descripton;


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ItensChallenge() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }
}
