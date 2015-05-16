package com.mobintum.gallery;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Button btnNext, btnBack;
    private ImageView imgPhoto;
    private int position=0;
    final int[] namePhotos = {R.mipmap.pic_moscu, R.mipmap.pic_newyork,R.mipmap.pic_paris,R.mipmap.pic_san_francisco,R.mipmap.pic_tokio};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgPhoto = (ImageView) findViewById(R.id.imgPhoto);
        btnBack = (Button) findViewById(R.id.btnBack);
        btnNext = (Button) findViewById(R.id.btnNext);


        imgPhoto.setImageDrawable(getResources().getDrawable(namePhotos[position]));

        btnBack.setOnClickListener(this);
        btnNext.setOnClickListener(this);


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

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnBack:
                if(position>0){
                    position--;
                    imgPhoto.setImageDrawable(getResources().getDrawable(namePhotos[position]));
                }
                break;
            case R.id.btnNext:
                if(position<namePhotos.length-1){
                    position++;
                    imgPhoto.setImageDrawable(getResources().getDrawable(namePhotos[position]));

                }
                break;

        }
    }
}
