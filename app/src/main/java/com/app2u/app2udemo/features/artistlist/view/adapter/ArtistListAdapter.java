package com.app2u.app2udemo.features.artistlist.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app2u.app2udemo.R;
import com.app2u.app2udemo.features.artistlist.domain.model.ApiPhotographer;

import java.util.List;

import static com.app2u.app2udemo.commons.utils.DisplayUtils.adjustViewInPercentScreenSize;
import static com.app2u.app2udemo.commons.utils.DisplayUtils.setImageCachedFromUrl;

public class ArtistListAdapter extends RecyclerView.Adapter<ArtistListAdapter.ArtistListViewHolder> {
    public static final double IMAGE_ARTIST_ELEMENT_HEIGHT = 0.2;

    private List<ApiPhotographer> apiPhotographerList;
    private Context context;

    public ArtistListAdapter(List<ApiPhotographer> apiPhotographerList, Context context) {
        this.apiPhotographerList = apiPhotographerList;
        this.context = context;
    }

    @NonNull
    @Override
    public ArtistListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_list_element, parent, false);
        ArtistListAdapter.ArtistListViewHolder viewHolder = new ArtistListAdapter.ArtistListViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistListViewHolder holder, int position) {
        ApiPhotographer apiPhotographer = apiPhotographerList == null || apiPhotographerList.size() == 0 ? null : apiPhotographerList.get(position);
        String completeName = apiPhotographer.getFirstName() + " " + apiPhotographer.getLastName();
        String urlImage = apiPhotographer.getImage();

        if (!TextUtils.isEmpty(urlImage)) {
            setImageCachedFromUrl(holder.headerImage, urlImage, context);
        } else {
            holder.headerImage.setImageDrawable(context.getResources().getDrawable(R.drawable.place_holder));
        }
        holder.textViewName.setText(completeName);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToArtistDetail(apiPhotographer);
            }
        });

        holder.buttonAddToFavourites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo should call add to favourites implementation
            }
        });

        adjustScreenSizePercentage(holder);
    }

    private void adjustScreenSizePercentage(ArtistListViewHolder holder) {
        adjustViewInPercentScreenSize(IMAGE_ARTIST_ELEMENT_HEIGHT, context, holder.headerImage, false);
    }

    private void goToArtistDetail(ApiPhotographer apiPhotographer) {
        //todo should call new fragment

    }

    @Override
    public int getItemCount() {
        if (apiPhotographerList != null) {
            return apiPhotographerList.size();
        }
        return 0;
    }

    public static class ArtistListViewHolder extends RecyclerView.ViewHolder {
        ImageView headerImage;
        TextView textViewName;
        ImageButton buttonAddToFavourites;

        ArtistListViewHolder(View itemView) {
            super(itemView);
            headerImage = itemView.findViewById(R.id.imageArtistListElement);
            textViewName = itemView.findViewById(R.id.txtvNameArtistListElement);
            buttonAddToFavourites = itemView.findViewById(R.id.buttonAttToFavListElement);
        }

    }
}
