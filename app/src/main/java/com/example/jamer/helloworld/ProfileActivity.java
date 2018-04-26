package com.example.jamer.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class ProfileActivity extends Activity {

    private static final String TAG = ProfileActivity.class.getSimpleName();

    private TextView say_my_name;
    private TextView welcome;
    private TextView p_age;
    private TextView p_occupation;
    private TextView p_description;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thankyou_main);
        say_my_name = findViewById(R.id.say_my_name);
        welcome = findViewById(R.id.welcome);
        p_age = findViewById(R.id.p_age);
        p_occupation = findViewById(R.id.p_occupation);
        p_description = findViewById(R.id.p_description);

        StringBuilder msg = new StringBuilder("Thank you for registering: ");
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        Log.i(TAG, "intent");



        assert b != null;
        if (b.containsKey(Constants.KEY_USERNAME)){
            String userName = b.getString(Constants.KEY_USERNAME);
            welcome.append(userName);
        }

        if (b.containsKey(Constants.KEY_AGE)){
            String age = b.getString(Constants.KEY_AGE);
            p_age.append(age);
        }

        if (b.containsKey(Constants.KEY_OCCUPATION)){
            String occupation = b.getString(Constants.KEY_OCCUPATION);
            p_occupation.append(occupation);
        }

        if (b.containsKey(Constants.KEY_DESCRIPTION)){
            String description = b.getString(Constants.KEY_DESCRIPTION);
            p_description.append(description);
        }





    }



    public void goBackMain(View view){
       Intent goBack = new Intent(ProfileActivity.this, MainActivity.class) ;
       startActivity(goBack);
    }

//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.i(TAG, "onRestart()");
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.i(TAG, "onStart()");
//    }
//
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(TAG, "onRestoreInstanceState()");
        if (savedInstanceState.containsKey(Constants.KEY_WELCOME_TEXT)) {
            welcome.setText((String) savedInstanceState.get(Constants.KEY_WELCOME_TEXT));
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "onSaveInstanceState()");

        outState.putString(Constants.KEY_WELCOME_TEXT, welcome.getText().toString());

    }


}