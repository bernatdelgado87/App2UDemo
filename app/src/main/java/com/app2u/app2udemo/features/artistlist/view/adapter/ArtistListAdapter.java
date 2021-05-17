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
import com.app2u.app2udemo.features.artistlist.data.model.remote.ApiPhotographer;
import com.app2u.app2udemo.features.artistlist.domain.model.Photographer;

import java.util.List;

import static com.app2u.app2udemo.commons.utils.DisplayUtils.adjustViewInPercentScreenSize;
import static com.app2u.app2udemo.commons.utils.DisplayUtils.setImageCachedFromUrl;

public class ArtistListAdapter extends RecyclerView.Adapter<ArtistListAdapter.ArtistListViewHolder> {
    public static final double IMAGE_ARTIST_ELEMENT_HEIGHT = 0.2;

    private List<Photographer> photographerList;
    private Context context;
    private ArtistClickListener artistClickListener;

    public ArtistListAdapter(List<Photographer> photographerList, ArtistClickListener artistClickListener, Context context) {
        this.photographerList = photographerList;
        this.artistClickListener = artistClickListener;
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
        Photographer apiPhotographer = photographerList == null || photographerList.size() == 0 ? null : photographerList.get(position);
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

    private void goToArtistDetail(Photographer photographer) {
        artistClickListener.onArtistClicked(photographer);
    }

    @Override
    public int getItemCount() {
        if (photographerList != null) {
            return photographerList.size();
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

    public interface ArtistClickListener {
        void onArtistClicked(Photographer photographer);
    }
}
