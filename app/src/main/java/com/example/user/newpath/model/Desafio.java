package com.example.user.newpath.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Desafio {

    @SerializedName("challenges")
    public ArrayList<ItensChallenge> challenges;


    public ArrayList<ItensChallenge> getChallenges() {
        return challenges != null ? challenges:new ArrayList<ItensChallenge>();
    }

    public void setChallenges(ArrayList<ItensChallenge> challenges) {
        this.challenges = challenges;
    }


}
