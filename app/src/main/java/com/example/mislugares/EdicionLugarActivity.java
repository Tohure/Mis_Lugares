package com.example.mislugares;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.mislugares.Models.Lugar;



public class EdicionLugarActivity extends AppCompatActivity{

    private long id;
    private Lugar lugar;

    private EditText nombre;
    private Spinner tipo;
    private EditText direccion;
    private EditText telefono;
    private EditText url;
    private EditText comentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edicion_lugar);

        Bundle extras = getIntent().getExtras();
        id = extras.getLong("id", -1);
        lugar = MainActivity.lugares.elemento((int) id);

        nombre = (EditText) findViewById(R.id.nombre);
        assert nombre != null;
        nombre.setText(lugar.getNombre());

        direccion = (EditText) findViewById(R.id.direccion);
        assert direccion != null;
        direccion.setText(lugar.getDireccion());

        telefono = (EditText) findViewById(R.id.telefono);
        assert telefono != null;
        telefono.setText(Integer.toString(lugar.getTelefono()));

        url = (EditText) findViewById(R.id.url);
        assert url != null;
        url.setText(lugar.getUrl());

        comentario = (EditText) findViewById(R.id.comentario);
        assert comentario != null;
        comentario.setText(lugar.getComentario());

    }
}