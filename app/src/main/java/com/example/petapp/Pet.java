package com.example.petapp;

import android.content.Intent;

import java.io.Serializable;

    public class Pet implements Serializable {

    public String nome;
    public Integer idade;

    public Integer id;

    @Override
    public String toString(){
        return "Nome: " + nome + ", Idade: " + idade;
    }

}
