package com.example.petapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.Serializable;
import java.util.List;

public class ActivityA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_a);
    }

    public void abrirActivityB(View view) {

        Intent intent = new Intent(this,ActivityB.class);

        // cria o bundle para passar as variaveis para CadastroPetActivity
        Bundle bundle = new Bundle();
        bundle.putString("conteudo","INFORMATICA");

        intent.putExtras(bundle);
        startActivityForResult(intent,Constantes.REQ_ACTIVITY_A);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == Constantes.REQ_ACTIVITY_A &&
                resultCode == Constantes.RET_ACTIVITY_A){
            String valor = (String) data.getExtras().get("conteudo");
            Log.d("pet",valor.toString());
        }
    }
}