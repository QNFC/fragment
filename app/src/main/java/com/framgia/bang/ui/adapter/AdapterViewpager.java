package com.framgia.bang.ui.adapter;

import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.framgia.bang.ui.fragment.MainFragment;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.framgia.bang.ui.adapter.AdapterViewpager.Tabitem.GAME;
import static com.framgia.bang.ui.adapter.AdapterViewpager.Tabitem.MOVIE;
import static com.framgia.bang.ui.adapter.AdapterViewpager.Tabitem.MUSIC;

public class AdapterViewpager extends FragmentStatePagerAdapter {
    private static int TAB_NUM = 3;
    public static final String KEY = "KEY";

    public AdapterViewpager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        MainFragment fragment = new MainFragment();
        Bundle bundle = new Bundle();
        switch (position) {
            case MUSIC:
                bundle.putInt(KEY, MUSIC);
                fragment.setArguments(bundle);
                return fragment;
            case MOVIE:
                bundle.putInt(KEY, MOVIE);
                fragment.setArguments(bundle);
                return fragment;
            case GAME:
                bundle.putInt(KEY, GAME);
                fragment.setArguments(bundle);
                return fragment;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return TAB_NUM;
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.TYPE)
    @IntDef({ MUSIC, MOVIE, GAME })
    public @interface Tabitem {
        int MUSIC = 0;
        int MOVIE = 1;
        int GAME = 2;
    }
}
