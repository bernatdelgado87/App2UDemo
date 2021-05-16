package com.app2u.app2udemo.commons.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app2u.app2udemo.features.artistlist.view.viewmodel.ListViewModel;

public abstract class BaseFragment extends Fragment {

    protected abstract int getLayoutResId();

    protected abstract ListViewModel getViewModel();

    protected abstract void bindViews(View view);

    protected abstract void initViews();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        bindViews(view);
        initViews();
        return view;
    }


}
