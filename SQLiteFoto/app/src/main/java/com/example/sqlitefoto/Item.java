package com.example.sqlitefoto;

import android.graphics.Bitmap;

public class Item {
    Bitmap imagen;

    public Item(Bitmap imagen)
    {
        this.imagen = imagen;
    }
    public Bitmap getImagen()
    {
        return imagen;
    }
}