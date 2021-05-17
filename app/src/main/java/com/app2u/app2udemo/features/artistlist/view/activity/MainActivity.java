package com.app2u.app2udemo.features.artistlist.view.activity;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.app2u.app2udemo.R;
import com.app2u.app2udemo.commons.view.activity.BaseActivity;
import com.app2u.app2udemo.commons.di.ApplicationComponent;
import com.app2u.app2udemo.commons.view.uicomponents.ProcessToolbar;
import com.app2u.app2udemo.features.artistlist.view.viewmodel.ArtistViewModel;
import com.app2u.app2udemo.features.artistlist.domain.usecase.ListUsecase;
import com.app2u.app2udemo.features.artistlist.view.fragment.HomeFragment;

import javax.inject.Inject;


public class MainActivity extends BaseActivity {
    @Inject
    ListUsecase listUsecase;

    private ArtistViewModel artistViewModel;
    private ProcessToolbar processToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        bindViews();
        initFragment();
    }

    private void initFragment () {
        Fragment fragment = HomeFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.process_activity_fragment_container, fragment)
                .commitNow();
    }

    private void bindViews() {
        processToolbar = findViewById(R.id.toolbar);
    }

    @Override
    protected void injectView(ApplicationComponent appComponent) {
        appComponent.inject(this);
    }

    public ArtistViewModel getArtistViewModel() {
        if (artistViewModel == null) {
            artistViewModel = ViewModelProviders.of(this).get(ArtistViewModel.class);
            artistViewModel.setListUsecase(listUsecase);
        }
        return artistViewModel;
    }

    public void initBackButton() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            if (isTaskRoot()) {
                processToolbar.setVisibility(View.GONE);
            } else {
                processToolbar.getBackButton().setVisibility(View.VISIBLE);
                processToolbar.setVisibility(View.VISIBLE);
            }
        } else {
            processToolbar.setVisibility(View.VISIBLE);
            processToolbar.getBackButton().setVisibility(View.VISIBLE);
        }
        processToolbar.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public ProcessToolbar getProcessToolbar() {
        return processToolbar;
    }

}