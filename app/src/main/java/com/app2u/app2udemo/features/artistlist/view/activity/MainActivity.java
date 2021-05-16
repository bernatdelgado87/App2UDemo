package com.app2u.app2udemo.features.artistlist.view.activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.app2u.app2udemo.R;
import com.app2u.app2udemo.commons.view.activity.BaseActivity;
import com.app2u.app2udemo.commons.di.ApplicationComponent;
import com.app2u.app2udemo.features.artistlist.view.viewmodel.ListViewModel;
import com.app2u.app2udemo.features.artistlist.domain.usecase.ListUsecase;
import com.app2u.app2udemo.features.artistlist.view.fragment.HomeFragment;

import javax.inject.Inject;


public class MainActivity extends BaseActivity {
    @Inject
    ListUsecase listUsecase;

    private ListViewModel listViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Fragment fragment = HomeFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.process_activity_fragment_container, fragment)
                .commitNow();
    }

    @Override
    protected void bindViews() {
        super.bindViews();
    }

    @Override
    protected void injectView(ApplicationComponent appComponent) {
        appComponent.inject(this);
    }

    public ListViewModel getListViewModel() {
        if (listViewModel == null) {
            listViewModel = ViewModelProviders.of(this).get(ListViewModel.class);
            listViewModel.setListUsecase(listUsecase);
        }
        return listViewModel;
    }
}