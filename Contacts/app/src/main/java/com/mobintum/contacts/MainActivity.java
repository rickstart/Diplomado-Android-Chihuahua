package com.mobintum.contacts;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {


    final Contact santos = new Contact("Santos Benavides", "Observatorio", "Chihuahua","4132471","sbenavi@gmail.com","sbenavi","@sbenavilee");
    final Contact eduardo = new Contact("Eduardo Garcia", "Observatorio","Chihuahua","4100838","eduardo.garciao@outlook.com","lalogarcia","@lalogarcias");
    final Contact ricardo = new Contact("Ricardo Centeno", "Mobintum", "CD MX", "5514382887","ricardo.celj@gmail.com", "rickstart", "@rickstart");

    final Contact[] contacts = {santos,eduardo,ricardo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
