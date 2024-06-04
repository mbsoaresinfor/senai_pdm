package com.example.petapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RetornoAulaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retorno_aula);
    }

    public void somar(View view) {
        EditText valor1 = findViewById(R.id.editTextValor1);
        EditText valor2 = findViewById(R.id.editTextValor2);
        TextView resultado = findViewById(R.id.textViewResultado);
        Integer soma = new Integer(0);
        try{
            Integer valor1Numerico = Integer.parseInt(valor1.getText().toString());
            Integer valor2Numerico = Integer.parseInt(valor2.getText().toString());
            soma = valor1Numerico + valor2Numerico;
            resultado.setText(soma.toString());

        }catch(Exception e){
          // tratamento do erro.
            Toast.makeText(this,"Ocorreu um erro ao realizar a soma",Toast.LENGTH_LONG).show();
        }

    }

    public void subtrair(View view) {
        EditText valor1 = findViewById(R.id.editTextValor1);
        EditText valor2 = findViewById(R.id.editTextValor2);
        TextView resultado = findViewById(R.id.textViewResultado);
        Integer subtrair = new Integer(0);
        try{
            Integer valor1Numerico = Integer.parseInt(valor1.getText().toString());
            Integer valor2Numerico = Integer.parseInt(valor2.getText().toString());
            subtrair = valor1Numerico - valor2Numerico;
            resultado.setText(subtrair.toString());

        }catch(Exception e){
            // tratamento do erro.
            Toast.makeText(this,"Ocorreu um erro ao realizar a subtração.",Toast.LENGTH_LONG).show();
        }
    }
}