package com.adam.mydatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView contentlist;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentlist = (ListView) findViewById(R.id.contentlist);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        ArrayList<contact> contacts = new ArrayList<>();
        contacts.add(new contact("contact 1",2345678));
        contacts.add(new contact("contact 2",1234567));
        contacts.add(new contact("contact 3",6561585));
        contacts.add(new contact("contact 4",1231455));
        contacts.add(new contact("contact 5",5155152));

        ContactAdapter contactAdapter = new ContactAdapter(this, R.layout.item_contact,contacts);

        contentlist.setAdapter(contactAdapter);
//       Intent i = new Intent(getApplicationContext(), MainActivity.class);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddContact.class);
                startActivity(intent);
            }
        });

        contentlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, updateContact.class);
                startActivity(intent);
            }
        });


    }
}