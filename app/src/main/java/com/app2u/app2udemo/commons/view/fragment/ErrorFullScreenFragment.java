package com.app2u.app2udemo.commons.view.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app2u.app2udemo.R;
import com.app2u.app2udemo.commons.di.ApplicationComponent;
import com.app2u.app2udemo.features.artistlist.view.viewmodel.ListViewModel;

public class ErrorFullScreenFragment extends BaseFragment {
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_error_full_screen;
    }

    @Override
    protected ListViewModel getViewModel() {
        return null;
    }

    public static Fragment newInstance() {
        return new ErrorFullScreenFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    protected void bindViews(View view) {

    }

    @Override
    protected void initViews() {

    }


}
