package com.mobintum.musicplayer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private ArrayList<Song> songs = new ArrayList<Song>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        songs.add(new Song("Get Lucky", "Daft Punk", "Get Lucky","get_lucky",R.mipmap.ic_get_lucky,"4:08"));
        songs.add(new Song("Love Me Againg", "John Newman", "Tribute","love_me_again",R.mipmap.ic_john_newman,"3:54"));

        ListView listSongs = (ListView) findViewById(R.id.listSongs);
        SongAdapter adapter = new SongAdapter(getApplicationContext(),R.layout.item_list_song,songs);
        listSongs.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
