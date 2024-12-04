package com.example.listview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Item extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrada);  // El layout que muestra los ítems
    }

    // Clase ItemData que representa cada elemento
    public static class ItemData {
        private int imagenResId;
        private String titulo;
        private String datos;
        private boolean opcionSeleccionada;

        // Constructor
        public ItemData(int imagenResId, String titulo, String datos, boolean opcionSeleccionada) {
            this.imagenResId = imagenResId;
            this.titulo = titulo;
            this.datos = datos;
            this.opcionSeleccionada = opcionSeleccionada;
        }

        // Getters
        public int getImagenResId() {
            return imagenResId;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getDatos() {
            return datos;
        }

        public boolean isOpcionSeleccionada() {
            return opcionSeleccionada;
        }
    }
}