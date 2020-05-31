package com.example.tparchivoslab3;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import model.Usuario;

public class ViewModelMain extends ViewModel
{
    private Usuario user = new Usuario();


    public void leer(Context context, EditText mail, EditText password,Intent i)
    {
       File carpeta = context.getFilesDir();
       File archivo = new File(carpeta,"Login.dat");

        try {
            FileInputStream fi = new FileInputStream(archivo);
            BufferedInputStream bi = new BufferedInputStream(fi);
            DataInputStream dis = new DataInputStream(bi);


            String email = null;

            if ((email = dis.readUTF())!= null)
            {
                user.setMail(email);
                user.setPassword(dis.readUTF());

                if(user.getMail().equals(mail.getText().toString()) &&(user.getPassword().equals(password.getText().toString()) ))
                {

                    context.startActivity(i);
                }
                else
                {
                    Toast.makeText(context, "Ingrese datos validos", Toast.LENGTH_LONG).show();

                }
            }
            else
            {

            }



        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "Debe Registrarse Primero2", Toast.LENGTH_LONG).show();
        }

    }

    public void pantallaRegistro(Intent i,Context ctx)
    {
        ctx.startActivity(i);
    }
}
