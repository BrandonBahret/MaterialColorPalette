package com.example.brandon.materialcolorpalette.Ui.Activites.MaterialSwatchActivity;

import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.brandon.materialcolorpalette.Common.MyColorUtils;
import com.example.brandon.materialcolorpalette.Data.MaterialColor;
import com.example.brandon.materialcolorpalette.R;

/**
 * Created by Brandon on 4/19/2017.
 * ViewHolder for SwatchLauncherView
 */

public class MaterialColorViewHolder extends RecyclerView.ViewHolder {

    TextView mTitle;
    TextView mColorText;

    public MaterialColorViewHolder(View itemView) {
        super(itemView);
        mTitle = (TextView) itemView.findViewById(R.id.color_title);
        mColorText = (TextView) itemView.findViewById(R.id.color_string);
    }

    public void bindItem(MaterialColor materialColor) {
        mTitle.setText(materialColor.getTitle());
        mColorText.setText(materialColor.getColor());

        int defaultColor = materialColor.getColorAsInteger();
        itemView.getBackground().setColorFilter(defaultColor, PorterDuff.Mode.SRC);

        if (MyColorUtils.shouldUseDarkForegroundColor(defaultColor)) {
            int textColor = ContextCompat.getColor(mTitle.getContext(), R.color.textColor2);
            mTitle.setTextColor(textColor);
            mColorText.setTextColor(textColor);
        }
    }

}
