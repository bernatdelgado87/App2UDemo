package com.app2u.app2udemo.features.artistlist.view.fragment;

import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app2u.app2udemo.R;
import com.app2u.app2udemo.commons.view.fragment.BaseFragment;
import com.app2u.app2udemo.features.artistlist.view.viewmodel.ListViewModel;
import com.app2u.app2udemo.features.artistlist.domain.model.ApiPhotographerListModel;
import com.app2u.app2udemo.features.artistlist.view.adapter.ArtistListAdapter;
import com.app2u.app2udemo.features.artistlist.view.activity.MainActivity;

public class HomeFragment extends BaseFragment {
    private RecyclerView recyclerViewArtistList;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void bindViews(View view) {
        recyclerViewArtistList = view.findViewById(R.id.recyclerArtistList);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void initViews() {
        initObservers();
        getViewModel().requestList();
    }

    public static Fragment newInstance() {
        return new HomeFragment();
    }


    private void initObservers() {
        // Create the observer which updates the UI.
        final Observer<ApiPhotographerListModel> observer = new Observer<ApiPhotographerListModel>() {
            @Override
            public void onChanged(@Nullable final ApiPhotographerListModel listViewModel) {
                syncroViewsWithData(listViewModel);
            }
        };
        getViewModel().getApiPhotographerMutableLiveData().observe(this, observer);
    }

    private void syncroViewsWithData(@Nullable final ApiPhotographerListModel listViewModel) {
        initArtistListAdapter(listViewModel);
    }

    private void initArtistListAdapter(@Nullable final ApiPhotographerListModel listViewModel) {
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerViewArtistList.setLayoutManager(llm);
        ArtistListAdapter artistListAdapter = new ArtistListAdapter(listViewModel.photographerList, getContext());
        recyclerViewArtistList.setAdapter(artistListAdapter);
    }

    @Override
    protected ListViewModel getViewModel() {
        return ((MainActivity) getActivity()).getListViewModel();
    }

}