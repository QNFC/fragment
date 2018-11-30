package com.framgia.bang.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.framgia.bang.fragment.R;
import com.framgia.bang.ui.adapter.AdapterViewpager;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,
        BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView mNavigationView;
    private Toolbar mToolbar;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
    }

    private void addControls() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mViewPager = findViewById(R.id.vp_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        AdapterViewpager viewpager = new AdapterViewpager(getSupportFragmentManager());
        mViewPager.setAdapter(viewpager);

        mNavigationView = findViewById(R.id.btm_main);
        mNavigationView.setOnNavigationItemSelectedListener(this);
        mViewPager.addOnPageChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case AdapterViewpager.Tabitem.MUSIC:
                mNavigationView.getMenu().getItem(AdapterViewpager.Tabitem.MUSIC).setChecked(true);
                break;
            case AdapterViewpager.Tabitem.MOVIE:
                mNavigationView.getMenu().getItem(AdapterViewpager.Tabitem.MOVIE).setChecked(true);
                break;
            case AdapterViewpager.Tabitem.GAME:
                mNavigationView.getMenu().getItem(AdapterViewpager.Tabitem.GAME).setChecked(true);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_music:
                mViewPager.setCurrentItem(AdapterViewpager.Tabitem.MUSIC);
                break;
            case R.id.menu_movie:
                mViewPager.setCurrentItem(AdapterViewpager.Tabitem.MOVIE);
                break;
            case R.id.menu_game:
                mViewPager.setCurrentItem(AdapterViewpager.Tabitem.GAME);
                break;
        }
        return true;
    }
}
