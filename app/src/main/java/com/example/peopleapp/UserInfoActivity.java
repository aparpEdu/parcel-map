package com.example.peopleapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.example.peopleapp.people.People;
import com.example.peopleapp.validation.Validation;
import com.google.android.material.textfield.TextInputLayout;

public class UserInfoActivity extends BaseActivity implements TextWatcher {

    EditText age, city, address;
    TextInputLayout inputLayoutAge, inputLayoutCity, inputLayoutAddress;
    Button next;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        Intent intent = getIntent();
        next = findViewById(R.id.button3);
        Button back = findViewById(R.id.button2);
        age = findViewById(R.id.age);
        city = findViewById(R.id.city);
        address = findViewById(R.id.address);
        inputLayoutAddress = findViewById(R.id.textInputLayout2);
        inputLayoutAge = findViewById(R.id.textInputLayout);
        inputLayoutCity = findViewById(R.id.textInputLayout3);


        age.addTextChangedListener(this);
        city.addTextChangedListener(this);
        address.addTextChangedListener(this);

        back.setOnClickListener(view ->
                onBackPressed());

        next.setOnClickListener(view -> {
            String username = intent.getStringExtra("name");
            People people = new People(username, Integer.parseInt(age.getText().toString()),
                    city.getText().toString(), address.getText().toString());

            Intent nextIntent = new Intent(this, PeopleActivity.class);
            nextIntent.putExtra("people", people);
            startActivity(nextIntent);
        });


    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if (!Validation.validateAge(age)){
            inputLayoutAge.setError("Please provide valid age");
            next.setEnabled(false);

        } else {
            inputLayoutAge.setError("");
            next.setEnabled(true);
        }

        if(!Validation.validateCity(city)){
            inputLayoutCity.setError("City must be at least 2 chars long");
            next.setEnabled(false);
        } else{
            inputLayoutCity.setError("");
            next.setEnabled(true);
        }

        if(!Validation.validateAddress(address)){
            inputLayoutAddress.setError("Address must be at least 5 chars long");
            next.setEnabled(false);
        } else{
            inputLayoutAddress.setError("");
            next.setEnabled(true);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, EntryActivity.class));
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}