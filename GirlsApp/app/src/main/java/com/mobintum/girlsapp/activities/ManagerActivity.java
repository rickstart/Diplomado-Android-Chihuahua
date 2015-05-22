package com.mobintum.girlsapp.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.mobintum.girlsapp.R;
import com.mobintum.girlsapp.fragments.GirlDetailFragment;
import com.mobintum.girlsapp.fragments.ListGirlsFragment;
import com.mobintum.girlsapp.fragments.WebViewFragment;
import com.mobintum.girlsapp.models.Girl;

import java.util.ArrayList;


public class ManagerActivity extends ActionBarActivity implements ListGirlsFragment.OnFragmentInteractionListener,
        GirlDetailFragment.OnFragmentInteractionListener {

    private ArrayList<Girl> girlsArray = new ArrayList<Girl>();
    private FragmentManager fragmentManager;
    private String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        View view = inflater.inflate(R.layout.activity_manager,null);
        tag = view.getTag().toString();
        setContentView(view);
        fragmentManager = getSupportFragmentManager();

        girlsArray.add(new Girl("Emma Watson","https://www.facebook.com/emmawatson",R.mipmap.emma_watson));
        girlsArray.add(new Girl("Jennifer Lawrence","https://www.facebook.com/JenniferLawrence?fref=ts",R.mipmap.jennifer_lawrence));
        girlsArray.add(new Girl("Alexis Texas","http://www.teamtexass.com",R.mipmap.alexis_texas));
        girlsArray.add(new Girl("Jennifer Love Hewitt ","https://www.facebook.com/JLHOfficial?fref=ts",R.mipmap.jennifer_love_hewitt));
        girlsArray.add(new Girl("Lisa Edelstein","https://www.facebook.com/LisaEdelstein?fref=ts",R.mipmap.cuddy));



        if(tag.equals("sw600dp") || tag.equals("sw320dp-land")){
            fragmentManager.beginTransaction()
                    .replace(R.id.containerLeft, ListGirlsFragment.newInstance(girlsArray))
                    .commit();

        }else {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, ListGirlsFragment.newInstance(girlsArray))
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
    public void onGirlSelected(Girl girl) {

        if(tag.equals("sw600dp") || tag.equals("sw320dp-land")){

            fragmentManager.beginTransaction()
                    .replace(R.id.containerRight, GirlDetailFragment.newInstance(girl))
                    .commit();
        }else {

            fragmentManager.beginTransaction()
                    .replace(R.id.container, GirlDetailFragment.newInstance(girl))
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void gotoPage(String url) {

        if(tag.equals("sw600dp") || tag.equals("sw320dp-land")){

            fragmentManager.beginTransaction()
                    .replace(R.id.containerRight, WebViewFragment.newInstance(url))
                    .commit();
        }else {

            fragmentManager.beginTransaction()
                    .replace(R.id.container, WebViewFragment.newInstance(url))
                    .addToBackStack(null)
                    .commit();
        }


    }
}
