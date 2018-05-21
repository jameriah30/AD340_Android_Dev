package com.example.jamer.helloworld;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jamer.helloworld.models.Matches;
import com.example.jamer.helloworld.viewmodels.MatchesViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MatchesFragment extends Fragment {


    private OnListFragmentInteractionListener mListener;
    private RecyclerView view;
    private MatchesRecyclerViewAdapter adapter;


    public MatchesFragment() {
        // Required empty public constructor
    }



    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = (RecyclerView) inflater.inflate(
                R.layout.recycler_view, container, false);

        MatchesViewModel viewModel = new MatchesViewModel();

        viewModel.getMatchesItems(
                (ArrayList<Matches> matches) -> {
                    //adapter.update(matches, mListener)
                    // See Class Slack
                    adapter = new MatchesRecyclerViewAdapter(matches, mListener);
                    view.setAdapter(adapter);
                    view.setHasFixedSize(true);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

                    view.setLayoutManager(layoutManager);




                }
        );



        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnListFragmentInteractionListener){
            mListener = (OnListFragmentInteractionListener) context;
        } else{
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListner");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Matches item);
    }
}


//    @Nullable
//    @Override
//    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
////        return inflater.inflate(R.layout.fragment_matches, container, false);
//
//        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
//                R.layout.recycler_view, container, false);
//
//        ContentAdapter adapter = new ContentAdapter(recyclerView.getContext());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        return recyclerView;
//
//    }
//
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public ImageView matchPicture;
//        public TextView matchName;
//        public TextView matchBio;
//        public ImageButton likeButton;
//        boolean like = false;
//
//        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
//            super(inflater.inflate(R.layout.fragment_matches, parent, false));
//
//            matchPicture = itemView.findViewById(R.id.card_image);
//            matchName = itemView.findViewById(R.id.card_title);
//            matchBio = itemView.findViewById(R.id.card_text);
//            likeButton = itemView.findViewById(R.id.likeButton);
//
//            likeButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (!like) {
//                        Toast.makeText(itemView.getContext(), "You like " + matchName.getText().toString(), Toast.LENGTH_LONG).show();
//                        like = true;
//                        likeButton.setColorFilter(Color.RED);
//                    } else {
//                        like = false;
//                        likeButton.setColorFilter(Color.GRAY);
//                    }
//                }
//            });
//        }
//    }
//
//    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
//
//
//        private final String[] mNames;
//        private final String[] mBios;
//        private final Drawable[] mPictures;
//
//        public ContentAdapter(Context context) {
//            Resources resources = context.getResources();
//            mNames = resources.getStringArray(R.array.matches_names);
//            mBios = resources.getStringArray(R.array.matches_bios);
//            TypedArray a = resources.obtainTypedArray(R.array.matches_picture);
//            mPictures = new Drawable[a.length()];
//            for (int i = 0; i < mPictures.length; i++) {
//                mPictures[i] = a.getDrawable(i);
//            }
//            a.recycle();
//        }
//
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
//        }
//
//        @Override
//        public void onBindViewHolder(final ViewHolder holder, int position) {
//            holder.matchPicture.setImageDrawable(mPictures[position % mPictures.length]);
//            holder.matchName.setText(mNames[position % mNames.length]);
//            holder.matchBio.setText(mBios[position % mBios.length]);
//        }
//
//        @Override
//        public int getItemCount() {
//            return mNames.length;
//        }
//
//    }
//}

