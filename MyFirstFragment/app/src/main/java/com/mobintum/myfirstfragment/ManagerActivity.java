package com.mobintum.myfirstfragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class ManagerActivity extends ActionBarActivity implements ButtonsFragment.OnFragmentInteractionListener{

    private FragmentManager fragmentManager;
    private String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        View view = inflater.inflate(R.layout.activity_manager, null);
        tag = view.getTag().toString();
        setContentView(view);
        fragmentManager = getSupportFragmentManager();


        if(tag.equals("sw600dp")){
            fragmentManager.beginTransaction()
                    .replace(R.id.containerLeft, new ButtonsFragment())
                    .commit();
        }else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, new ButtonsFragment())
                    .commit();

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_manager, menu);
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
    public void onAnimalSelected(String name) {

        if(tag.equals("sw600dp")){
            fragmentManager.beginTransaction()
                    .replace(R.id.containerRight, ImageFragment.newInstance(name))
                    .commit();

        }else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, ImageFragment.newInstance(name))
                    .addToBackStack(null)
                    .commit();
        }

    }
}
