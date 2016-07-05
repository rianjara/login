package io.github.rianjara.app1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    TextView mensaje;
    String nombre, apellido, usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mensaje = (TextView)findViewById(R.id.main_lbl_mensaje);

        SharedPreferences preferences = getSharedPreferences("rianjara", Context.MODE_PRIVATE);

        nombre = preferences.getString("nombre", null);
        apellido = preferences.getString("apellido", null);
        usuario = preferences.getString("usuario", null);

        mensaje.setText(nombre + apellido + usuario);
    }
}
