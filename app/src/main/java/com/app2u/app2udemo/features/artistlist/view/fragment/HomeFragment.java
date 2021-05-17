package com.app2u.app2udemo.features.artistlist.view.fragment;

import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app2u.app2udemo.R;
import com.app2u.app2udemo.commons.view.activity.BaseActivity;
import com.app2u.app2udemo.commons.view.fragment.BaseFragment;
import com.app2u.app2udemo.features.artistlist.domain.model.Photographer;
import com.app2u.app2udemo.features.artistlist.view.viewmodel.ArtistViewModel;
import com.app2u.app2udemo.features.artistlist.view.adapter.ArtistListAdapter;
import com.app2u.app2udemo.features.artistlist.view.activity.MainActivity;

import java.util.List;

public class HomeFragment extends BaseFragment implements ArtistListAdapter.ArtistClickListener {
    private RecyclerView recyclerViewArtistList;
    private RelativeLayout loadingPanel;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void bindViews(View view) {
        recyclerViewArtistList = view.findViewById(R.id.recyclerArtistList);
        loadingPanel = view.findViewById(R.id.loadingPanel);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).initBackButton();
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
        // list observer
        final Observer<List<Photographer>> listObserver = listViewModel -> initArtistListAdapter(listViewModel);
        getViewModel().getApiPhotographerMutableLiveData().observe(this, listObserver);

        // loading observer
        final Observer<Boolean> loadingObserver = isLoading -> showLoading(isLoading);
        getViewModel().getScreenState().getIsLoading().observe(this, loadingObserver);

        // error observer
        final Observer<Boolean> errorObserver = hasErrors -> showError(hasErrors);
        getViewModel().getScreenState().getHasErrors().observe(this, errorObserver);
    }


    private void initArtistListAdapter(@Nullable final List<Photographer> photographers) {
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        recyclerViewArtistList.setLayoutManager(llm);
        ArtistListAdapter artistListAdapter = new ArtistListAdapter(photographers, this, getContext());
        recyclerViewArtistList.setAdapter(artistListAdapter);
    }

    @Override
    protected ArtistViewModel getViewModel() {
        return ((MainActivity) getActivity()).getArtistViewModel();
    }

    private void showLoading(boolean show){
        if (show) {
            loadingPanel.setVisibility(View.VISIBLE);
        } else {
            loadingPanel.setVisibility(View.GONE);
        }
    }

    private void showError(boolean show){
        if (show) {
            showErrorFullScreen();
        }
    }

    @Override
    public void onArtistClicked(Photographer photographer) {
        getViewModel().getPhotographerDetail().setValue(photographer);
        ((BaseActivity)getActivity()).nextFragment(Detailfragment.newInstance());
    }
}