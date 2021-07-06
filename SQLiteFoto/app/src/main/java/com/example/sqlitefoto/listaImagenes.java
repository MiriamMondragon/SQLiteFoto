package com.example.sqlitefoto;

import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqlitefoto.transacciones.Transacciones;

import java.util.ArrayList;

public class listaImagenes extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_imagenes);

        GridView simpleGridView = (GridView) findViewById(R.id.simpleGridView);

        SQLiteConexion help = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        ArrayList<Item> listaImagenes = new ArrayList<>();
        Cursor c= help.getAll();
        int i=0;
        if(c.getCount()>0)
        {
            c.moveToFirst();
            while(c.isAfterLast()==false)
            {

                byte[] bytes=c.getBlob(c.getColumnIndex(Transacciones.blobImagen));

                Item item = new Item(BitmapFactory.decodeByteArray(bytes, 0, bytes.length));
                listaImagenes.add(item);
                c.moveToNext();
                i++;
            }

            Adaptador myAdapter=new Adaptador(this,R.layout.grid_view_items,listaImagenes);
            simpleGridView.setAdapter(myAdapter);
        }
    }
}