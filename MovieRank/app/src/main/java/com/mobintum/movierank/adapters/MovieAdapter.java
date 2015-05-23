package com.mobintum.movierank.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobintum.movierank.R;
import com.mobintum.movierank.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Rick on 23/05/15.
 */
public class MovieAdapter extends ArrayAdapter {

    private ArrayList<Movie> movies;
    private Context context;
    private LayoutInflater inflater;

    public MovieAdapter(Context context, int resource, ArrayList<Movie> movies) {
        super(context, resource, movies);
        this.movies = movies;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView==null) {
            convertView = inflater.inflate(R.layout.item_list_movie, parent, false);
            holder = new ViewHolder();
            holder.txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
            holder.imgMovie = (ImageView) convertView.findViewById(R.id.imgMovie);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Movie movie = movies.get(position);
        holder.txtTitle.setText(movie.getTitle());
        Picasso.with(context).load(movie.getPosterUrl()).into(holder.imgMovie);

        return convertView;
    }

    class ViewHolder{
        TextView txtTitle;
        ImageView imgMovie;
    }

}
