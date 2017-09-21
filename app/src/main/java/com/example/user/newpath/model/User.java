package com.example.user.newpath.model;

import com.example.user.newpath.DAO.FirebaseConfig;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by jussi on 9/5/17.
 */

public class User {
        public String id;
        public String nome;
        public String aniversario;
        public String email;
        public String senha;


        public User() {

        }

        public void salvar(){
            DatabaseReference reference = FirebaseConfig.getFirebase();
            reference.child("user").child(String.valueOf(getId())).setValue(this);
        }

        @Exclude
        public Map<String, Object> toMap(){
            HashMap<String, Object> hashMapUser = new HashMap<>();

            hashMapUser.put("id", getId());
            hashMapUser.put("nome", getNome());
            hashMapUser.put("aniversario", getAniversario());
            hashMapUser.put("email", getEmail());
            hashMapUser.put("senha", getSenha());
            return hashMapUser;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getAniversario() {
            return aniversario;
        }

        public void setAniversario(String aniversario) {
            this.aniversario = aniversario;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }
    }

