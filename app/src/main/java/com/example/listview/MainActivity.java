package com.example.listview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ItemAdapter adapter;
    private ArrayList<Item.ItemData> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa el ListView y el ArrayList
        listView = findViewById(R.id.listView);
        itemList = new ArrayList<>();


        itemList.add(new Item.ItemData(R.drawable.dona, "Dona", "Dona artesanal", false));
        itemList.add(new Item.ItemData(R.drawable.mango, "Mango", "Mango que crece en el arbol", false));
        itemList.add(new Item.ItemData(R.drawable.manzana, "Manzana", "Manzana roja que cerece en los arboles tambien", false));
        itemList.add(new Item.ItemData(R.drawable.pera, "Pera", "Pera verde", false));



        // Configura el adaptador
        adapter = new ItemAdapter(itemList);
        listView.setAdapter(adapter);
    }

    // Adaptador para el ListView
    public class ItemAdapter extends BaseAdapter {

        private ArrayList<Item.ItemData> itemList;
        private LayoutInflater inflater;

        // Constructor
        public ItemAdapter(ArrayList<Item.ItemData> itemList) {
            this.itemList = itemList;
            this.inflater = LayoutInflater.from(MainActivity.this);  // 'MainActivity.this' se refiere al contexto de la actividad
        }

        @Override
        public int getCount() {
            return itemList.size();
        }

        @Override
        public Object getItem(int position) {
            return itemList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.entrada, parent, false); // Asegúrate de que 'entrada.xml' sea el layout correcto
            }

            // Obtener el objeto del ítem
            Item.ItemData itemData = itemList.get(position);

            // Obtener las vistas del layout
            ImageView imageView = convertView.findViewById(R.id.imagen);
            RadioButton radioButton = convertView.findViewById(R.id.boton);
            TextView tituloTextView = convertView.findViewById(R.id.texto_titulo);
            TextView datosTextView = convertView.findViewById(R.id.texto_datos);

            // Establecer los datos del ítem
            imageView.setImageResource(itemData.getImagenResId());
            radioButton.setChecked(itemData.isOpcionSeleccionada());
            tituloTextView.setText(itemData.getTitulo());
            datosTextView.setText(itemData.getDatos());

            return convertView;
        }
    }
}
