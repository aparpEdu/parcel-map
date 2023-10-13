package com.example.peopleapp.validation;

import android.widget.EditText;

public class Validation
{
    public static boolean validateAge(EditText ageText){
        int age;
        if(ageText.getText() !=null && !ageText.getText().toString().isEmpty()){
             age = Integer.parseInt(ageText.getText().toString());
        } else {
            return false;
        }

        return age != 0 && age <= 150;
    }

    public static boolean validateCity(EditText cityText){
        if(cityText.getText() == null){
            return false;
        }
        String city = cityText.getText().toString();

        return !city.startsWith(" ") && city.length() >= 2;
    }

    public static boolean validateAddress(EditText addressText){
        if(addressText.getText() == null){
            return false;
        }
        String address = addressText.getText().toString();

        return !address.startsWith(" ") && address.length() >= 5;
    }


}
