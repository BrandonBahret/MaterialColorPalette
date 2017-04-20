package com.example.brandon.materialcolorpalette.Ui.Activites.MainActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.RawRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;

import com.example.brandon.materialcolorpalette.Common.MyRawResourcesUtils;
import com.example.brandon.materialcolorpalette.Data.MaterialPalette;
import com.example.brandon.materialcolorpalette.R;
import com.example.brandon.materialcolorpalette.Ui.Activites.AboutActivity;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    //region (Member attributes)
    MaterialPalette mMaterialPalette;

    RecyclerView mRecyclerView;
    MaterialSwatchViewAdapter mAdapter;
    //endregion

    //region Methods responsible for handling the activity lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMaterialPalette = loadPaletteFromJson(R.raw.color_palette);

        mRecyclerView = (RecyclerView) findViewById(R.id.palette_container);
        int numberOfColumns = calculateNoOfColumns(this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(MainActivity.this, numberOfColumns);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new MaterialSwatchViewAdapter(MainActivity.this, mMaterialPalette);
        mRecyclerView.setAdapter(mAdapter);
    }

    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (displayMetrics.widthPixels / context.getResources().getDimension(R.dimen.material_swatch_launcher_icon_size));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //endregion -- end --

    //region Methods responsible for handling events
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.about)
            AboutActivity.startActivity(MainActivity.this);

        return super.onOptionsItemSelected(item);
    }
    //endregion -- end --

    private MaterialPalette loadPaletteFromJson(@RawRes int rawId) {
        String colorPaletteJson = MyRawResourcesUtils.fetchResource
                (MainActivity.this, rawId);

        return new Gson().fromJson(colorPaletteJson, MaterialPalette.class);
    }

}
