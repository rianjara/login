package io.github.rianjara.app1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    Button registrar_btn_registrar;
    EditText txtNombre, txtApellido, txtUsuario, txtPassword, txtEmail;
    String  nombre, apellido, usuario, password, email;
    Usuario u;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registrar_btn_registrar = (Button)findViewById(R.id.registrar_btn_registrar);
        registrar_btn_registrar.setOnClickListener(this);

        preferences = getSharedPreferences("rianjara", Context.MODE_PRIVATE);
    }

    private Usuario obtenerUsuario(){

        txtNombre = (EditText)findViewById(R.id.registro_txt_nombre);
        txtApellido = (EditText)findViewById(R.id.registro_txt_apellido);
        txtUsuario = (EditText)findViewById(R.id.registro_txt_usuario);
        txtPassword = (EditText)findViewById(R.id.registro_txt_password1);
        txtEmail = (EditText)findViewById(R.id.registro_txt_email);

        nombre = txtNombre.getText().toString();
        apellido = txtApellido.getText().toString();
        usuario = txtUsuario.getText().toString();
        password = txtPassword.getText().toString();
        email = txtEmail.getText().toString();

        u = new Usuario(nombre, apellido, usuario, password, email);
        return u;
    }

    @Override
    public void onClick(View view) {

        SharedPreferences.Editor editor = preferences.edit();

        u = obtenerUsuario();

        editor.putString("nombre", u.getNombre());
        editor.putString("apellido", u.getApellido());
        editor.putString("usuario", u.getUsuario());
        editor.putString("password", u.getPassword());
        editor.putString("email", u.getEmail());
        editor.commit();

        Intent i = new Intent(this, Main.class);
        startActivity(i);
    }
}
