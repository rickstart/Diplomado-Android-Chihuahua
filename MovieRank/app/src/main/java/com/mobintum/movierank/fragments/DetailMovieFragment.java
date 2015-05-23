package com.mobintum.movierank.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobintum.movierank.R;
import com.mobintum.movierank.models.Movie;
import com.squareup.picasso.Picasso;


public class DetailMovieFragment extends Fragment {

    private static final String ARG_PARAM_MOVIE = "paramMovie";

    private Movie movie;


    public static DetailMovieFragment newInstance(Movie movie) {
        DetailMovieFragment fragment = new DetailMovieFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_MOVIE,movie);
        fragment.setArguments(args);
        return fragment;
    }

    public DetailMovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.movie = (Movie) getArguments().getSerializable(ARG_PARAM_MOVIE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail_movie, container, false);
        ImageView imgPoster = (ImageView) view.findViewById(R.id.imgPoster);
        TextView txtTitleDetail = (TextView) view.findViewById(R.id.txtTitleDetail);

        Picasso.with(getActivity()).load(movie.getPosterUrl()).into(imgPoster);
        txtTitleDetail.setText(movie.getTitle());

        return view;
    }


}
