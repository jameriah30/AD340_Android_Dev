package com.example.jamer.helloworld;

import android.graphics.Color;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jamer.helloworld.models.Matches;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MatchesRecyclerViewAdapter extends RecyclerView.Adapter<MatchesRecyclerViewAdapter.ViewHolder> {
    private List<Matches> mValues;
    private MatchesFragment.OnListFragmentInteractionListener mListener;
    private double currLat;
    private double currLong;

    public MatchesRecyclerViewAdapter(List<Matches> items, MatchesFragment.OnListFragmentInteractionListener listener, double currLong, double currLat) {
        mValues = items;
        mListener = listener;
        this.currLong = currLong;
        this.currLat = currLat;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_matches, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        if(mValues == null || mListener == null) {
            return;
        }
        holder.mItem = mValues.get(position);
        holder.matchName.setText(mValues.get(position).name);
        holder.mImgUrl = mValues.get(position).imageUrl; // get image URL from object
        Picasso.get().load(holder.mImgUrl).into(holder.matchPicture); // set image url into ImageView
        holder.liked = mValues.get(position).liked;

        if (!holder.liked) {
            holder.likeButton.setColorFilter(Color.GRAY);
        } else {
            holder.likeButton.setColorFilter(Color.RED);
        }

        holder.likeButton.setOnClickListener(v -> {
            if (null != mListener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) that an item has been selected.
                if (!holder.liked) {
                    Toast.makeText(holder.mView.getContext(), "You like " + mValues.get(position).name, Toast.LENGTH_LONG).show();
                    holder.likeButton.setColorFilter(Color.RED);
                } else {
                    holder.likeButton.setColorFilter(Color.BLACK);
                }
                mListener.onListFragmentInteraction(holder.mItem);
            }
        });

        holder.latitude = mValues.get(position).lat;
        double newLat = Double.parseDouble(holder.latitude);

        holder.longitude = mValues.get(position).longitude;
        double newLong = Double.parseDouble(holder.longitude);

        float[] distance = new float[1];

        Location.distanceBetween(currLat, currLong, newLat, newLong, distance);

        Log.v("help", Double.toString(distance[0]));

        if (distance[0] > 16094) {
            holder.mCard.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        if(mValues != null) {
            return mValues.size();
        } else {
            return 0;
        }
    }

    public void setCurrLat(double currLat) {
        this.currLat = currLat;
    }

    public void setCurrLong(double currLong) {
        this.currLong = currLong;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View mView;
        public ImageView matchPicture;
        public TextView matchName;
        public TextView matchBio;
        public ImageButton likeButton;
        public String mImgUrl;
        public Matches mItem;
        public Boolean liked;
        public String latitude;
        public String longitude;
        public final RelativeLayout mCard;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            matchName = view.findViewById(R.id.card_title);
            matchPicture = view.findViewById(R.id.card_image);
            likeButton = view.findViewById(R.id.likeButton);
            mCard = view.findViewById(R.id.this_card);
        }
    }
}