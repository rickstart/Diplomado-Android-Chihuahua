package com.mobintum.listcontacts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    final Contact santos = new Contact("Santos Benavides", "Observatorio", "Chihuahua","4132471","sbenavi@gmail.com","sbenavi","sbenavilee", R.mipmap.pic_santos);
    final Contact eduardo = new Contact("Eduardo Garcia", "Observatorio","Chihuahua","4100838","eduardo.garciao@outlook.com","lalogarcia","lalogarcias",R.mipmap.pic_lalo);
    final Contact ricardo = new Contact("Ricardo Centeno", "Mobintum", "CD MX", "5514382887","ricardo.celj@gmail.com", "rickstart", "rickstart", R.mipmap.pic_ricardo);

    private ListView listContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contacts.add(santos);
        contacts.add(eduardo);
        contacts.add(ricardo);

        listContacts = (ListView) findViewById(R.id.listContacts);

        ContactAdapter adapter = new ContactAdapter(getApplicationContext(),R.layout.item_list_contact,contacts);
        listContacts.setAdapter(adapter);
        listContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("contact", contacts.get(position));

                startActivity(intent);
            }
        });
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
