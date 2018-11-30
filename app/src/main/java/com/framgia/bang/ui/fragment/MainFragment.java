package com.framgia.bang.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.framgia.bang.fragment.R;
import com.framgia.bang.ui.adapter.AdapterViewpager;

public class MainFragment extends Fragment {
    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        mTextView = v.findViewById(R.id.txt_category);
        setTitle();
        return v;
    }

    private void setTitle() {
        int position = getArguments().getInt(AdapterViewpager.KEY);
        switch (position) {
            case AdapterViewpager.Tabitem.MUSIC:
                mTextView.setText(R.string.music);
                break;
            case AdapterViewpager.Tabitem.MOVIE:
                mTextView.setText(R.string.movie);
                break;
            case AdapterViewpager.Tabitem.GAME:
                mTextView.setText(R.string.game);
                break;
        }
    }
}
