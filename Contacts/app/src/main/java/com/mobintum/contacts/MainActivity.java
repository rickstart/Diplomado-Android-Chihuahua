package com.mobintum.contacts;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{


    final Contact santos = new Contact("Santos Benavides", "Observatorio", "Chihuahua","4132471","sbenavi@gmail.com","sbenavi","@sbenavilee");
    final Contact eduardo = new Contact("Eduardo Garcia", "Observatorio","Chihuahua","4100838","eduardo.garciao@outlook.com","lalogarcia","@lalogarcias");
    final Contact ricardo = new Contact("Ricardo Centeno", "Mobintum", "CD MX", "5514382887","ricardo.celj@gmail.com", "rickstart", "@rickstart");

    final Contact[] contacts = {santos,eduardo,ricardo};

    private int position=0;

    private ImageView imgProfile;
    private TextView txtName, txtCompany, txtCity, txtPhone, txtEmail, txtGit, txtTwitter;
    private Button btnBack, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgProfile = (ImageView) findViewById(R.id.imgProfile);
        txtName = (TextView) findViewById(R.id.txtName);
        txtCompany = (TextView) findViewById(R.id.txtCompany);
        txtCity = (TextView) findViewById(R.id.txtCity);
        txtPhone = (TextView) findViewById(R.id.txtPhone);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtGit = (TextView) findViewById(R.id.txtGit);
        txtTwitter = (TextView) findViewById(R.id.txtTwitter);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnNext = (Button) findViewById(R.id.btnNext);
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
                if(position>0) {
                     position--;
                    loadData();
                }


                break;
            case R.id.btnNext:
                if (position<contacts.length-1){
                    position++;
                    loadData();
                }

                break;
        }

    }

    public void loadData(){
        String label;
        Contact contact = contacts[position];


        txtName.setText(contact.getName());
        txtCompany.setText(contact.getCompany());

        label = getResources().getString(R.string.email);
        txtEmail.setText(label+" "+contact.getEmail());
        label = getResources().getString(R.string.tel);
        txtPhone.setText(label+" "+contact.getPhone());

    }
}
