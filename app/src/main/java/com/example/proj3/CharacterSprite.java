package com.example.proj3;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class CharacterSprite {
    private Bitmap image;
    public int x,y,xright,ytop;
    public CharacterSprite(Bitmap bmp){
        image = bmp;
        x = 100;
        y = 100;
    }
    public CharacterSprite(Bitmap bmp,int xloc, int yloc, int xsize, int ysize){
        image = bmp;
        x = xloc;
        y = yloc;
        xright = xloc + xsize;
        ytop = yloc - ysize;

    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(image, x, y, null);
    }

    public void update(int xvel,int yvel){
        y += yvel;
        x += xvel;
    }
}
