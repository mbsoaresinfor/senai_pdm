package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RevisaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revisao);
    }

    public void mostraMensagem(View view) {
        EditText nome = findViewById(R.id.editTextNome);
        EditText idade = findViewById(R.id.editTextTextIdade);
        String nomeString = nome.getText().toString();
        String idadeString = idade.getText().toString();

        if(nomeString.equals("seu_nome")
                && idadeString.equals("20")){
            Toast.makeText(this, R.string.mensagem_sucesso,
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, R.string.mensagem_error,
                    Toast.LENGTH_SHORT).show();
        }

    }
}