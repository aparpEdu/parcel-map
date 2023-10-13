package com.example.peopleapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class EntryActivity extends BaseActivity implements TextWatcher {


    TextInputLayout textInputLayout;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        editText.addTextChangedListener(this);
        textInputLayout = findViewById(R.id.username);
        button.setOnClickListener(view -> {
            if (textInputLayout.getError() == null || textInputLayout.getError().toString().isEmpty()){
                Intent intent = new Intent(this, UserInfoActivity.class);
                intent.putExtra("name", editText.getText().toString());
                startActivity(intent);
            }
        });
    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        if(editText.getText().toString().length() < 5){
            textInputLayout.setError("Username should be at least 5 characters long");
        } else{
            textInputLayout.setError("");
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}