package com.example.brandon.materialcolorpalette.Data;

import com.example.brandon.materialcolorpalette.Common.MyColorUtils;

import java.io.Serializable;

/**
 * Created by Brandon on 4/19/2017.
 * Data model to represent colors in material swatches.
 */

public class MaterialColor implements Serializable {

    private final String title;
    private final String color;
    private Integer colorAsInteger = null;

    public MaterialColor(String colorTitle, String color) {
        this.title = colorTitle;
        this.color = color;
        this.colorAsInteger = MyColorUtils.parseColor(color);
    }

    public String getTitle() {
        return this.title;
    }

    public String getColor() {
        return this.color.toUpperCase();
    }

    public int getColorAsInteger() {
        if(this.colorAsInteger == null){
            this.colorAsInteger = MyColorUtils.parseColor(this.color);
        }
        return this.colorAsInteger;
    }

}