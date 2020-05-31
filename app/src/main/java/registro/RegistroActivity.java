package registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tparchivoslab3.MainActivity;
import com.example.tparchivoslab3.R;

import model.Usuario;

public class RegistroActivity extends AppCompatActivity {

 EditText dni,nombre,mail,apellido,password;
 Intent intent;
 RegistroViewModel vm;
 private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        datos();
        checkeardatos();
    }

    public void guardarDatos(View v)
    {
        Intent i = new Intent(this, MainActivity.class);
     //   Toast.makeText(this, nombre.getText().toString(), Toast.LENGTH_LONG).show();
       vm.guardar(nombre,apellido,dni,mail,password,i,this);


    }
    public void datos()
    {
        intent= getIntent();
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroViewModel.class);
        dni = findViewById(R.id.etDniRegistro2);
        nombre = findViewById(R.id.etNombreRegistro);
        apellido = findViewById(R.id.etApellidoRegistro);
        mail = findViewById(R.id.etMailRegistro);
        password = findViewById(R.id.etPasswordRegistro);
    }

    public void checkeardatos()
    {
        vm.checkearDatos(nombre,apellido,dni,mail,password,intent,this);
    }
}
