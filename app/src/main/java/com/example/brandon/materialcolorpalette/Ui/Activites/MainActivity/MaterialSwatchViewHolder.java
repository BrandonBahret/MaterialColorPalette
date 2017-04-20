package com.example.brandon.materialcolorpalette.Ui.Activites.MainActivity;

import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.brandon.materialcolorpalette.Data.MaterialSwatch;
import com.example.brandon.materialcolorpalette.R;

/**
 * Created by Brandon on 4/19/2017.
 * ViewHolder for SwatchLauncherView
 */

public class MaterialSwatchViewHolder extends RecyclerView.ViewHolder {

    TextView mTitle;

    public MaterialSwatchViewHolder(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.color_title);
    }

    public void bindItem(MaterialSwatch materialSwatch, View.OnClickListener clickListener) {
        mTitle.setText(materialSwatch.getTitle());
        int defaultColor = materialSwatch.getDefaultColor().getColorAsInteger();
        itemView.getBackground().setColorFilter(defaultColor, PorterDuff.Mode.SRC);
        itemView.setOnClickListener(clickListener);
    }

}
