package com.mobintum.musicplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rick on 20/05/15.
 */
public class SongAdapter extends ArrayAdapter {

    private LayoutInflater inflater;
    private ArrayList<Song> songs;
    private Context context;

    public SongAdapter(Context context, int resource, ArrayList<Song> songs) {
        super(context, resource, songs);
        this.songs = songs;
        this.context = context;
        this.inflater = LayoutInflater.from(context);

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView==null){
            convertView = inflater.inflate(R.layout.item_list_song,parent,false);
            holder = new ViewHolder();
            holder.imgAlbum = (ImageView) convertView.findViewById(R.id.imgAlbum);
            holder.txtArtist = (TextView) convertView.findViewById(R.id.txtArtist);
            holder.txtTitle = (TextView) convertView.findViewById(R.id.txtTitle);
            holder.txtTime = (TextView) convertView.findViewById(R.id.txtTime);

            convertView.setTag(holder);

        }else {
            holder = (ViewHolder) convertView.getTag();

        }

        Song song = songs.get(position);
        holder.imgAlbum.setImageDrawable(context.getResources().getDrawable(song.getAlbumPoster()));
        holder.txtTitle.setText(song.getTitle());
        holder.txtArtist.setText(song.getArtist());
        holder.txtTime.setText(song.getTime());



        return convertView;
    }

     class ViewHolder{
        ImageView imgAlbum;
        TextView txtTitle;
        TextView txtArtist;
        TextView txtTime;
    }
}
