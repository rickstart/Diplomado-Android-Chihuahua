package com.mobintum.listcontacts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class DetailActivity extends ActionBarActivity implements View.OnClickListener {
    private int position;
    private Contact contact;
    private ImageButton btnPhone, btnEmail, btnGithub, btnTwitter;

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
        TextView txtPhone = (TextView) findViewById(R.id.txtPhone);
        TextView txtEmail = (TextView) findViewById(R.id.txtEmail);
        TextView txtGithub = (TextView) findViewById(R.id.txtGit);
        TextView txtTwitter = (TextView) findViewById(R.id.txtTwitter);

        btnPhone = (ImageButton) findViewById(R.id.btnPhone);
        btnEmail = (ImageButton) findViewById(R.id.btnEmail);
        btnGithub = (ImageButton) findViewById(R.id.btnGithub);
        btnTwitter = (ImageButton) findViewById(R.id.btnTwitter);

        btnPhone.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
        btnGithub.setOnClickListener(this);
        btnTwitter.setOnClickListener(this);


        txtPhone.setText(contact.getPhone());
        txtEmail.setText(contact.getEmail());
        txtGithub.setText(contact.getGithub());
        txtTwitter.setText("@"+contact.getTwitter());
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

    @Override
    public void onClick(View v) {
        Intent intent;

        switch(v.getId()){

            case R.id.btnPhone:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + contact.getPhone()));
                startActivity(intent);
                break;

            case R.id.btnEmail:
                intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"+contact.getEmail()));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Contact");
                intent.putExtra(Intent.EXTRA_TEXT,"Request of contact");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;

            case R.id.btnGithub:
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.github.com/"+contact.getGithub()));
                startActivity(intent);
                break;

            case R.id.btnTwitter:
                intent = new Intent(Intent.ACTION_VIEW);
                Log.e("URI", "twitter://user?screen_name="+contact.getTwitter());
                intent.setData(Uri.parse("twitter://user?screen_name="+contact.getTwitter()));
                startActivity(intent);
                break;
        }

    }
}
