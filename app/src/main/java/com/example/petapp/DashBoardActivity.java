package com.example.petapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        setTitle("DashBoard");
    }

    public void abreCadastroPet(View view) {
        // abrindo a tela de cadastro de pet.
        Intent intent = new Intent(this,CadastroPetActivity.class);
        startActivity(intent);
    }
}