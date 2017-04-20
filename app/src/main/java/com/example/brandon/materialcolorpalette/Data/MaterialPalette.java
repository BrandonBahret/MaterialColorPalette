package com.example.brandon.materialcolorpalette.Data;

import java.util.List;

/**
 * Created by Brandon on 4/19/2017.
 * A class used so Gson can load all the swatches into one object.
 */

public class MaterialPalette {
    private List<MaterialSwatch> swatches;

    public MaterialPalette(List<MaterialSwatch> swatches){
        this.swatches = swatches;
    }

    public List<MaterialSwatch> getSwatches() {
        return swatches;
    }

    public int getSize() {
        return swatches.size();
    }

    public MaterialSwatch get(int position) {
        return swatches.get(position);
    }

}
