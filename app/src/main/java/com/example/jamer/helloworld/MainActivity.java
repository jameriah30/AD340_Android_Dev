package com.example.jamer.helloworld;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends Activity implements View.OnClickListener{

    private EditText firstnameEdittext,lastnameEdittext,emailEdittext,usernameEdittext,ageEdittext,birthdayEdittext,passEdittext,passAgainEdittext;

    private Button submitButton;
    private DatePickerDialog datePickerDialog;
    private int month, day, c_year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        ageEdittext=(EditText)findViewById(R.id.age_edittext);
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
        String firstname=firstnameEdittext.getText().toString();
        String lastname=lastnameEdittext.getText().toString();
        String email=emailEdittext.getText().toString();
        String pass=passEdittext.getText().toString();
        String passAgain=passAgainEdittext.getText().toString();
        String age=ageEdittext.getText().toString();
        String username=usernameEdittext.getText().toString();
        String birthday=birthdayEdittext.getText().toString();





        //Check all fields
        if(!firstname.equals("")&&!lastname.equals("")&&!email.equals("")&&!pass.equals("")&&!passAgain.equals("")&&!birthday.equals("")&&!age.equals("")&&!username.equals("")){

            if(!isOfAge(month,day,c_year)){
                Toast.makeText(this,"Must be 18 year of age!",Toast.LENGTH_SHORT).show();
            }

            //Check if pass and passAgain are the same
            if(pass.equals(passAgain)){

                //Everything allright
                Toast.makeText(this,getResources().getString(R.string.here_is_values,("\nUsername:"+username+"\nFirstname:"+firstname+"\nLastname:"+lastname+"\nEmail:"+email+"\nAge:"+age+"\nBirthday:"+birthday)),Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this,getResources().getString(R.string.passwords_must_be_the_same),Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this,getResources().getString(R.string.no_field_can_be_empty),Toast.LENGTH_SHORT).show();
        }

        if(isOfAge(month,day,c_year)){

            Intent intent = new Intent (this, Main2Activity.class);
            intent.putExtra(Constants.KEY_USERNAME, username );
            startActivity(intent);}

            else{
            Toast.makeText(this,"Must be 18 year of age!",Toast.LENGTH_SHORT).show();}




    }
//    public void goToActivity2 (View view){
//        ;
//    }


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


}
