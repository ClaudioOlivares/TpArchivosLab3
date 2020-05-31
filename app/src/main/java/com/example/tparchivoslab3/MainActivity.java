package com.example.tparchivoslab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import registro.RegistroActivity;

public class MainActivity extends AppCompatActivity {
    private EditText mail,password;
    private File carpeta,archivo;
    private ViewModelMain vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos();
    }

    public void  login(View v)
    {
        Intent i = new Intent(this,RegistroActivity.class);
        i.putExtra("extra","login");
        vm.leer(this,mail,password,i);

    }

    public void registrar(View v)
    {

        Intent i = new Intent(this, RegistroActivity.class);
        vm.pantallaRegistro(i,this);

    }

    public void datos()
    {
        mail = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPass);
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelMain.class);


    }


}
