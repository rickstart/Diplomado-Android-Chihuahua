package com.mobintum.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;


public class DetailActivity extends ActionBarActivity implements View.OnClickListener {

    private ArrayList<Song> songs;
    private int position;
    private ImageView imgAlbumDetail;
    private TextView txtTitleDetail, txtArtistDetail, txtAlbumDetail, txtTimeDetail;
    private ProgressBar progressBarTime;
    private ImageButton btnBack, btnNext, btnPlay;
    private MediaPlayer mPlayer;
    private boolean playing = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            position = bundle.getInt("position");
            songs = (ArrayList<Song>) bundle.getSerializable("data");
        }

        imgAlbumDetail = (ImageView) findViewById(R.id.imgAlbumDetail);
        txtTitleDetail = (TextView) findViewById(R.id.txtTitleDetail);
        txtArtistDetail = (TextView) findViewById(R.id.txtArtistDetail);
        txtAlbumDetail = (TextView) findViewById(R.id.txtAlbumDetail);
        txtTimeDetail = (TextView) findViewById(R.id.txtTimeDetail);
        progressBarTime = (ProgressBar) findViewById(R.id.progressBarTime);
        btnBack = (ImageButton) findViewById(R.id.btnBack);
        btnPlay = (ImageButton) findViewById(R.id.btnPlay);
        btnNext = (ImageButton) findViewById(R.id.btnNext);

        btnBack.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        loadData();



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadData(){

        Song song = songs.get(position);
        imgAlbumDetail.setImageDrawable(getResources().getDrawable(song.getAlbumPoster()));
        txtTitleDetail.setText(song.getTitle());
        txtArtistDetail.setText(song.getArtist());
        txtAlbumDetail.setText(song.getAlbum());
        txtTimeDetail.setText(song.getTime());

        mPlayer = MediaPlayer.create(
                        getApplicationContext(),
                        getResources().getIdentifier("raw/"+song.getFileName(),
                        "raw",
                        getPackageName()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }

    public void play(){
        if(playing) {
            btnPlay.setImageResource(R.mipmap.btn_pause);

            mPlayer.start();
            playing=false;
        }else{
            mPlayer.pause();
            playing = true;
            btnPlay.setImageResource(R.mipmap.btn_play);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnPlay:
                play();
                break;
            case R.id.btnBack:
                if(position>0){
                    position--;
                    mPlayer.stop();
                    loadData();

                    playing = true;
                    play();
                }
                break;

            case R.id.btnNext:
                if(position<songs.size()-1){
                    position++;
                    mPlayer.stop();
                    loadData();

                    playing = true;
                    play();

                }
                break;
        }


    }
}
