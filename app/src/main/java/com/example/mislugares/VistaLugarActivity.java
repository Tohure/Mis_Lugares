package com.example.mislugares;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class VistaLugarActivity extends AppCompatActivity {
    private long id;
    private Lugar lugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_lugar);
        Bundle extras = getIntent().getExtras();
        id = extras.getLong("id", -1);
        lugar = MainActivity.lugares.elemento((int) id);

        TextView nombre = (TextView) findViewById(R.id.nombre);
        assert nombre != null;
        nombre.setText(lugar.getNombre());

        ImageView logo_tipo = (ImageView) findViewById(R.id.logo_tipo);
        assert logo_tipo != null;
        logo_tipo.setImageResource(lugar.getTipo().getRecurso());

        TextView tipo = (TextView) findViewById(R.id.tipo);
        assert tipo != null;
        tipo.setText(lugar.getTipo().getTexto());

        TextView direccion = (TextView) findViewById(R.id.direccion);
        assert direccion != null;
        direccion.setText(lugar.getDireccion());

        TextView telefono = (TextView) findViewById(R.id.telefono);
        assert telefono != null;
        telefono.setText(Integer.toString(lugar.getTelefono()));

        TextView url = (TextView) findViewById(R.id.url);
        assert url != null;
        url.setText(lugar.getUrl());

        TextView comentario = (TextView) findViewById(R.id.comentario);
        assert comentario != null;
        comentario.setText(lugar.getComentario());

        TextView fecha = (TextView) findViewById(R.id.fecha);
        assert fecha != null;
        fecha.setText(DateFormat.getDateInstance().format(new Date(lugar.getFecha())));

        TextView hora = (TextView) findViewById(R.id.hora);
        assert hora != null;
        hora.setText(DateFormat.getTimeInstance().format(new Date(lugar.getFecha())));

        RatingBar valoracion = (RatingBar) findViewById(R.id.valoracion);
        assert valoracion != null;
        valoracion.setRating(lugar.getValoracion());
        valoracion.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar,
                                                float valor, boolean fromUser) {
                        lugar.setValoracion(valor);
                    }
                });
    }
}