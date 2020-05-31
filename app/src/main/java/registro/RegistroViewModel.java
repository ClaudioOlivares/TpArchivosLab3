package registro;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import model.Usuario;

public class RegistroViewModel extends ViewModel {

private Usuario user = new Usuario();


    public void guardar(EditText nombre, EditText apellido, EditText dni, EditText mail, EditText pass, Intent i, Context ctx)
    {
        user.setNombre(nombre.getText().toString());
        user.setApellido(apellido.getText().toString());
        user.setDni(Long.parseLong(dni.getText().toString()));
        user.setMail(mail.getText().toString());
        user.setPassword(pass.getText().toString());

        File carpeta = ctx.getFilesDir();
        File archivo = new File(carpeta,"Login.dat");

        try
        {
            FileOutputStream fo = new FileOutputStream(archivo,false);
            BufferedOutputStream bo = new BufferedOutputStream(fo);
            DataOutputStream dos =  new DataOutputStream(bo);

            dos.writeUTF(user.getMail());
            dos.writeUTF(user.getPassword());
            dos.writeUTF(user.getNombre());
            dos.writeUTF(user.getApellido());
            dos.writeLong(user.getDni());

            bo.flush();
            fo.close();

            Toast.makeText(ctx, "User Guardado", Toast.LENGTH_LONG).show();
            ctx.startActivity(i);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void checkearDatos(EditText nombre, EditText apellido, EditText dni, EditText mail, EditText pass, Intent i,Context ctx)
    {
        File carpeta = ctx.getFilesDir();
        File archivo = new File(carpeta,"Login.dat");

        if(i.getExtras() != null)
        {
            try
            {
                FileInputStream fi = new FileInputStream(archivo);
                BufferedInputStream bi = new BufferedInputStream(fi);
                DataInputStream dis = new DataInputStream(bi);

                mail.setText(dis.readUTF());
                pass.setText(dis.readUTF());
                nombre.setText(dis.readUTF());
                apellido.setText(dis.readUTF());
                dni.setText(Long.toString(dis.readLong()));

            }
            catch (IOException io)
            {


            }


        }
    }
}
