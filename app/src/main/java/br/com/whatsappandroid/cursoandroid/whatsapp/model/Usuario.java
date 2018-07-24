package br.com.whatsappandroid.cursoandroid.whatsapp.model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

import br.com.whatsappandroid.cursoandroid.whatsapp.config.ConfiguracaoFirebase;

public class Usuario {

    private String id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(){

    }

    public void salvar(){
        DatabaseReference referenciaFirebase = ConfiguracaoFirebase.getFirebase();
        referenciaFirebase.child("usuarios").child(getId()).setValue(this); //ps: this -> passando o objeto usuario
    }

    @Exclude // não leva em consideração na hora de salvar
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude // não leva em consideração na hora de salvar
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
