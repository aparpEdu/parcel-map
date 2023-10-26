package com.example.peopleapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.peopleapp.people.People;

public class PeopleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
        TextView name = findViewById(R.id.textView), age = findViewById(R.id.textView2),
                address = findViewById(R.id.textView3), city = findViewById(R.id.textView4);
        Intent intent = getIntent();
        People person = intent.getParcelableExtra("people");
        assert person != null;
        name.setText(person.getName());
        age.setText(String.valueOf(person.getAge()));
        address.setText(person.getAddress());
        city.setText(person.getCity());

        Button finish = findViewById(R.id.button4);
        Button map = findViewById(R.id.button5);
        map.setOnClickListener(view -> showAddress(person.getCity()+ " " + person.getAddress()));
        finish.setOnClickListener(view -> finishAndRemoveTask());
    }

    private void showAddress(String address){
        Uri searchQuery = Uri.parse("geo:0,0?q=" + Uri.encode(address));

        Intent intent = new Intent(Intent.ACTION_VIEW, searchQuery);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}