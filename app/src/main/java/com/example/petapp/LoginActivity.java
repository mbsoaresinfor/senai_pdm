package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(R.string.login);
    }

    public void logar(View view) {
        // buscando os componentes do xml para o java.
        EditText login = findViewById(R.id.editTextTextLogin);
        EditText senha = findViewById(R.id.editTextTextSenha);
        String loginTexto = login.getText().toString();
        String senhaTexto = senha.getText().toString();

        if(loginTexto.isEmpty() || senhaTexto.isEmpty()){
            Toast.makeText(this,"usuario ou senha vazio",Toast.LENGTH_LONG).show();
            return;
        }

        if(!loginTexto.equals("admin") || !senhaTexto.equals("123")){
            Toast.makeText(this,"usuario ou senha invalido",Toast.LENGTH_LONG).show();
            return;
        }

        Toast.makeText(this,"Sucesso no login",Toast.LENGTH_LONG).show();

        // abrindo uma nova activity
        Intent intent = new Intent(this,DashBoardActivity.class);
        startActivity(intent);


    }

    public boolean isNumero(String numero){
        try{
            Float.parseFloat(numero);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}