package com.example.petapp;

import java.io.Serializable;

public class Usuario implements Serializable {

    private Integer id;
    private String nome;
    private String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario:" +
                "id=" + id +
                "- nome='" + nome + '\'' +
                ':';
    }
}
