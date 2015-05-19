package com.mobintum.listcontacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DetailActivity extends ActionBarActivity {
    private int position;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        if(intent!=null){
            Bundle bundle = intent.getExtras();
            if(bundle!=null){
                position = bundle.getInt("position");
                contact = (Contact) bundle.getSerializable("contact");
            }
        }

        RoundedImageView imgProfile = (RoundedImageView) findViewById(R.id.imgProfile);
        TextView txtName = (TextView) findViewById(R.id.txtName);
        TextView txtCompany = (TextView) findViewById(R.id.txtCompany);
        TextView txtCity = (TextView) findViewById(R.id.txtCity);


        txtName.setText(contact.getName());
        txtCompany.setText(contact.getCompany());
        txtCity.setText(contact.getCity());
        imgProfile.setImageDrawable(getResources().getDrawable(contact.getPhoto()));



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
}
