package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.Serializable;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        String nome = (String) getIntent().getSerializableExtra("conteudo");
        Log.d("pet","valor recebido: " + nome);
        // retornando os dados para a activity pai
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("conteudo","INFORMATICA_ALTERADA");
        intent.putExtras(bundle);
        setResult(Constantes.RET_ACTIVITY_A , intent);
        finish();
    }
}