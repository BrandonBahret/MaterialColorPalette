package com.example.brandon.materialcolorpalette.Ui.Activites.MaterialSwatchActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.brandon.materialcolorpalette.Common.MyColorUtils;
import com.example.brandon.materialcolorpalette.Data.MaterialSwatch;
import com.example.brandon.materialcolorpalette.R;

import static com.example.brandon.materialcolorpalette.R.id.toolbar;

public class MaterialSwatchActivity extends AppCompatActivity {

    //region (Member attributes)
    public static final String KEY_SWATCH = "KEY_SWATCH";
    private MaterialSwatch mSwatch;

    private RecyclerView mRecyclerView;
    private Toolbar mToolbar;
    private MaterialColorAdapter mAdapter;
    //endregion

    //region Methods to handle the activity lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swatch);

        mSwatch = (MaterialSwatch) getIntent().getSerializableExtra(KEY_SWATCH);

        mToolbar = (Toolbar) findViewById(toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.swatch_container);

        setSupportActionBar(mToolbar);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MaterialSwatchActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new MaterialColorAdapter(mSwatch.getColors());
        mRecyclerView.setAdapter(mAdapter);

        setUpActivityWithSwatch(mSwatch);

    }

    private void setUpActivityWithSwatch(MaterialSwatch swatch) {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(swatch.getTitle());

            int defaultColor = swatch.getDefaultColor().getColorAsInteger();
            int darkerColor = MyColorUtils.darkenColorBy(defaultColor, 0.15f);
            getWindow().setStatusBarColor(darkerColor);
            actionBar.setBackgroundDrawable(new ColorDrawable(defaultColor));

            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) finish();

        return super.onOptionsItemSelected(item);
    }

    //endregion -- end --

    public static void startActivity(Context context, MaterialSwatch swatch) {
        Intent launchActivity = new Intent(context, MaterialSwatchActivity.class);
        launchActivity.putExtra(KEY_SWATCH, swatch);
        context.startActivity(launchActivity);
    }

}
