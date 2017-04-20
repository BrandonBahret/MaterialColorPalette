package com.example.brandon.materialcolorpalette.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Brandon on 4/19/2017.
 * Data model to represent swatches in the material palette
 */

public class MaterialSwatch implements Serializable {

    private String title;
    private MaterialColor defaultColor;
    private List<MaterialColor> colors;

    public String getTitle() {
        return this.title;
    }

    public List<MaterialColor> getColors() {
        return this.colors;
    }

    public MaterialColor getDefaultColor() {
        return defaultColor;
    }

}
