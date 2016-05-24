package com.example.mislugares;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.mislugares.Models.Lugar;

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
                    public void onRatingChanged(RatingBar ratingBar, float valor, boolean fromUser) {
                        lugar.setValoracion(valor);
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.vista_lugar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.accion_compartir:
                return true;
            case R.id.accion_llegar:
                return true;
            case R.id.accion_editar:
                Intent i = new Intent(VistaLugarActivity.this, EdicionLugarActivity.class);
                i.putExtra("id", id);
                startActivity(i);
                return true;
            case R.id.accion_borrar:
                borrarLugar((int) id);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void borrarLugar(final int id) {
        new AlertDialog.Builder(this)
                .setTitle("Borrar Lugar")
                .setMessage("Desea borrar este lugar?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        MainActivity.lugares.borrar(id);
                        finish();
                    }})
                .setNegativeButton("No", null)
                .show();

    }
}