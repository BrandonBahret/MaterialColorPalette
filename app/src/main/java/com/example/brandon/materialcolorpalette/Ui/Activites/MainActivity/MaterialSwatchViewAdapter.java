package com.example.brandon.materialcolorpalette.Ui.Activites.MainActivity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.brandon.materialcolorpalette.Data.MaterialPalette;
import com.example.brandon.materialcolorpalette.Data.MaterialSwatch;
import com.example.brandon.materialcolorpalette.R;
import com.example.brandon.materialcolorpalette.Ui.Activites.MaterialSwatchActivity.MaterialSwatchActivity;

/**
 * Created by Brandon on 4/19/2017.
 * Adapter class for SwatchLauncherView
 */

public class MaterialSwatchViewAdapter extends RecyclerView.Adapter {

    //region (Member attributes)
    private MaterialPalette mMaterialPalette;
    private Context mContext;
    //endregion

    MaterialSwatchViewAdapter(Context context, MaterialPalette materialPalette) {
        mMaterialPalette = materialPalette;
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.swatch_view_layout, parent, false);

        setMargins(view, 16, 16, 16, 16);

        return new MaterialSwatchViewHolder(view);
    }

    private static void setMargins(View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                MaterialSwatch swatch = mMaterialPalette.get(adapterPosition);
                MaterialSwatchActivity.startActivity(mContext, swatch);
            }
        };

        ((MaterialSwatchViewHolder) holder).bindItem
                (mMaterialPalette.get(position), clickListener);
    }

    @Override
    public int getItemCount() {
        return mMaterialPalette.getSize();
    }
}
