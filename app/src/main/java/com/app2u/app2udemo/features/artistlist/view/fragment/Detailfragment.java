package com.app2u.app2udemo.features.artistlist.view.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.app2u.app2udemo.R;
import com.app2u.app2udemo.commons.view.fragment.BaseFragment;
import com.app2u.app2udemo.features.artistlist.domain.model.Photographer;
import com.app2u.app2udemo.features.artistlist.view.activity.MainActivity;
import com.app2u.app2udemo.features.artistlist.view.viewmodel.ArtistViewModel;

import static com.app2u.app2udemo.commons.utils.DisplayUtils.setImageCachedFromUrl;

public class Detailfragment extends BaseFragment {
    private ImageView imageView;
    private TextView textViewName;
    private TextView textViewDescription;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_detail;
    }

    @Override
    protected void bindViews(View view) {
        imageView = view.findViewById(R.id.imageDetail);
        textViewName = view.findViewById(R.id.nameDetail);
        textViewDescription = view.findViewById(R.id.description);
    }

    @Override
    public void onResume() {
        super.onResume();
        setDataToView(getViewModel().getPhotographerDetail().getValue());
        ((MainActivity)getActivity()).initBackButton();
    }

    @Override
    protected void initViews() {
        initObservers();
    }

    public static Detailfragment newInstance() {
        return new Detailfragment();
    }

    private void initObservers() {
        // element observer
        final Observer<Photographer> photographerObserver = photographer -> setDataToView(photographer);
        getViewModel().getPhotographerDetail().observe(this, photographerObserver);
    }


    private void setDataToView(@Nullable final Photographer photographer) {
        String urlImage = photographer.getImage();
        String completeName = photographer.getFirstName() + " " + photographer.getLastName();
        String description = photographer.getDescription();
        if (!TextUtils.isEmpty(urlImage)) {
            setImageCachedFromUrl(imageView, urlImage, getContext());
        } else {
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.place_holder));
        }
        textViewName.setText(completeName);
        textViewDescription.setText(description);
    }

    @Override
    protected ArtistViewModel getViewModel() {
        return ((MainActivity) getActivity()).getArtistViewModel();
    }
}