package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

public class RemoverPetActivity extends AppCompatActivity {

    List<Pet> listaPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remover_pet);
        setTitle(R.string.remover_pet);
        listaPet = (List<Pet>) getIntent().getSerializableExtra("lista");
    }
}