package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroPetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pet);
        setTitle("Cadastro Pet");
    }

    public void cadastrar(View view) {
        // buscando os campos da tela.
        EditText nome = findViewById(R.id.editTextTextNomeDog);
        EditText idade = findViewById(R.id.editTextTextIdadeDog);
        String nomeTexto = nome.getText().toString();
        String idadeTexto = idade.getText().toString();

        if(nomeTexto.isEmpty() || idadeTexto.isEmpty()){
            Toast.makeText(this,"Todos os campos devem ser preenchidos",Toast.LENGTH_LONG).show();
            return;
        }

        Toast.makeText(this,"Sucesso no cadastro",Toast.LENGTH_LONG).show();
        // limpeza dos campos da tela.
        nome.setText("");
        idade.setText("");
    }
}