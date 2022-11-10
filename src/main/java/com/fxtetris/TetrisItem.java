package com.fxtetris;

import com.javafx2dengine.ShapeObject;
import javafx.scene.paint.Color;


public class TetrisItem extends ShapeObject {
    public boolean isRotate;
    public Color color;

    TetrisItem(){
        super();
        this.isRotate = true;
    }
    TetrisItem(String name, int id, boolean rotate){
        super(name, id);
        this.isRotate = rotate;
    }
}
