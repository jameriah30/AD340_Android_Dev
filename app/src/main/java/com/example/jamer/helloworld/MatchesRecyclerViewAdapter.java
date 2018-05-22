package com.example.jamer.helloworld;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jamer.helloworld.models.Matches;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MatchesRecyclerViewAdapter extends RecyclerView.Adapter<MatchesRecyclerViewAdapter.ViewHolder> {
    private List<Matches> mValues;
    private MatchesFragment.OnListFragmentInteractionListener mListener;

    public MatchesRecyclerViewAdapter(List<Matches> items, MatchesFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

//    public MatchesRecyclerViewAdapter(){
//
//    }

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
    }

    @Override
    public int getItemCount() {
        if(mValues != null) {
            return mValues.size();
        } else {
            return 0;
        }
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

        public ViewHolder(View view) {
            super(view);
            mView = view;
            matchName = view.findViewById(R.id.card_title);
            matchPicture = view.findViewById(R.id.card_image);
            likeButton = view.findViewById(R.id.likeButton);
        }
    }
}