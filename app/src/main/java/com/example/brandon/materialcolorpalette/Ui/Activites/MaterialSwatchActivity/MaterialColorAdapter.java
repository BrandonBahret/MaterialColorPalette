package com.example.brandon.materialcolorpalette.Ui.Activites.MaterialSwatchActivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brandon.materialcolorpalette.Data.MaterialColor;
import com.example.brandon.materialcolorpalette.R;

import java.util.List;

/**
 * Created by Brandon on 4/19/2017.
 * Adapter class for swatches
 */

public class MaterialColorAdapter extends RecyclerView.Adapter<MaterialColorViewHolder> {

    private List<MaterialColor> mColors;

    public MaterialColorAdapter(List<MaterialColor> colors){
        mColors = colors;
    }

    @Override
    public MaterialColorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.material_color_view_layout, parent, false);

        return new MaterialColorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MaterialColorViewHolder holder, int position) {
        holder.bindItem(mColors.get(position));
    }

    @Override
    public int getItemCount() {
        return mColors.size();
    }

}
