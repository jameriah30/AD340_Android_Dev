package com.example.jamer.helloworld;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity implements View.OnClickListener{

    private EditText firstnameEdittext,lastnameEdittext,emailEdittext,usernameEdittext,birthdayEdittext,passEdittext,passAgainEdittext;

    private Button submitButton;
    private DatePickerDialog datePickerDialog;
    private int month, day, c_year;
    private TextView textView1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView1);

        //Bind views with their ids
        bindViews();

        //Set listeners of views
        setViewActions();

        //Create DatePickerDialog to show a calendar to user to select birthdate
        prepareDatePickerDialog();
    }




    private void bindViews() {
        firstnameEdittext=(EditText)findViewById(R.id.firstname_edittext);
        lastnameEdittext=(EditText)findViewById(R.id.lastname_edittext);
        emailEdittext=(EditText)findViewById(R.id.email_edittext);
        usernameEdittext=(EditText)findViewById(R.id.username_edittext);
        birthdayEdittext=(EditText)findViewById(R.id.birthday_edittext);
        passEdittext=(EditText)findViewById(R.id.password_edittext);
        passAgainEdittext=(EditText)findViewById(R.id.password_again_edittext);
        submitButton=(Button)findViewById(R.id.submit_button);
    }

    private void setViewActions() {
        birthdayEdittext.setOnClickListener(this);
        submitButton.setOnClickListener(this);
    }

    private void prepareDatePickerDialog() {
        //Get current date
        Calendar calendar=Calendar.getInstance();

        //Create datePickerDialog with initial date which is current and decide what happens when a date is selected.
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //When a date is selected, it comes here.
                //Change birthdayEdittext's text and dismiss dialog.
                birthdayEdittext.setText(dayOfMonth+"/"+monthOfYear+"/"+year);
                month = monthOfYear;
                day = dayOfMonth;
                c_year = year;

                datePickerDialog.dismiss();
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
    }

    public boolean isOfAge(int month, int day, int c_year){
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        boolean age = false;

        if(currentYear - c_year == 18){
            if(currentMonth <= month){
                if(currentDay <= day){
                    age = true;
                }
            }
        }
        if(currentYear -c_year > 18){
            age = true;
        }

        return age;
        }

    private void showToastWithFormValues() {

        //Get edittexts values
        String firstname = firstnameEdittext.getText().toString();
        String lastname = lastnameEdittext.getText().toString();
        String email = emailEdittext.getText().toString();
        String pass = passEdittext.getText().toString();
        String passAgain = passAgainEdittext.getText().toString();
        String username = usernameEdittext.getText().toString();
        String birthday = birthdayEdittext.getText().toString();


        //Check all fields
        if (!firstname.equals("") && !lastname.equals("") && !email.equals("") && !pass.equals("") && !passAgain.equals("") && !birthday.equals("") && !username.equals("")) {



            //Check if pass and passAgain are the same
            if (pass.equals(passAgain)) {
                //Everything allright
                Toast.makeText(this, getResources().getString(R.string.here_is_values, ("\nUsername:" + username + "\nFirstname:" + firstname + "\nLastname:" + lastname + "\nEmail:" + email + "\nBirthday:" + birthday)), Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, getResources().getString(R.string.passwords_must_be_the_same), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, getResources().getString(R.string.no_field_can_be_empty), Toast.LENGTH_SHORT).show();
        }

        if (!isOfAge(month, day, c_year)) {
            Toast.makeText(this, "Must be 18 year of age!", Toast.LENGTH_SHORT).show();
        } else{
            Intent intent = new Intent (this, Main2Activity.class);
            intent.putExtra(Constants.KEY_USERNAME, username );
            startActivity(intent);

        }
    }






    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.birthday_edittext:
                datePickerDialog.show();
                break;
            case R.id.submit_button:
                showToastWithFormValues();
                break;
        }
    }



    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
//        Log.i(TAG, "onRestoreInstanceState()");
//        if (savedInstanceState.containsKey(Constants.KEY_TEXTVIEW)) {
//            textView1.setText((String)savedInstanceState.get(Constants.KEY_TEXTVIEW));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_FIRST_NAME)) {
//            firstnameEdittext.setText((String) savedInstanceState.get(Constants.KEY_FIRST_NAME));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_LAST_NAME)) {
//            lastnameEdittext.setText((String) savedInstanceState.get(Constants.KEY_LAST_NAME));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_EMAIL)) {
//            emailEdittext.setText((String) savedInstanceState.get(Constants.KEY_EMAIL));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_USERNAME)) {
//            usernameEdittext.setText((String) savedInstanceState.get(Constants.KEY_USERNAME));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_AGE)) {
//            ageEdittext.setText((String) savedInstanceState.get(Constants.KEY_AGE));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_BIRTHDAY)) {
//            submitButton.setText((String) savedInstanceState.get(Constants.KEY_BUTTON_TXT));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_PASS)) {
//            passEdittext.setText((String) savedInstanceState.get(Constants.KEY_PASS));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_PASSAGAIN)) {
//            passAgainEdittext.setText((String) savedInstanceState.get(Constants.KEY_PASSAGAIN));
//        }
//
//        if (savedInstanceState.containsKey(Constants.KEY_BUTTON_TXT)) {
//            birthdayEdittext.setText((String) savedInstanceState.get(Constants.KEY_BIRTHDAY));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_MY_NAME)) {
//            say_my_name.setText((String) savedInstanceState.get(Constants.KEY_MY_NAME));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_BUTTON_GOBACK)) {
//            goback_button.setText((String) savedInstanceState.get(Constants.KEY_BUTTON_GOBACK));
//        }
//        if (savedInstanceState.containsKey(Constants.KEY_WELCOME_TEXT)) {
//            welcome.setText((String) savedInstanceState.get(Constants.KEY_WELCOME_TEXT));
//        }
//
//    }
//
//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        Log.i(TAG, "onSaveInstanceState()");
//        outState.putString(Constants.KEY_TEXTVIEW, textView1.getText().toString());
//        outState.putString(Constants.KEY_FIRST_NAME, firstnameEdittext.getText().toString());
//        outState.putString(Constants.KEY_LAST_NAME, lastnameEdittext.getText().toString());
//        outState.putString(Constants.KEY_EMAIL, emailEdittext.getText().toString());
//        outState.putString(Constants.KEY_USERNAME, usernameEdittext.getText().toString());
//        outState.putString(Constants.KEY_AGE, ageEdittext.getText().toString());
//        outState.putString(Constants.KEY_BIRTHDAY, birthdayEdittext.getText().toString());
//        outState.putString(Constants.KEY_PASS, passEdittext.getText().toString());
//        outState.putString(Constants.KEY_PASSAGAIN, passAgainEdittext.getText().toString());
//        outState.putString(Constants.KEY_BUTTON_TXT, submitButton.getText().toString());
//        outState.putString(Constants.KEY_BUTTON_GOBACK, goback_button.getText().toString());
//        outState.putString(Constants.KEY_MY_NAME, say_my_name.getText().toString());
//        outState.putString(Constants.KEY_MY_NAME, say_my_name.getText().toString());
//        outState.putString(Constants.KEY_WELCOME_TEXT, welcome.getText().toString());
//
//    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }



}
