package com.example.jamer.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

public class Main2Activity extends Activity {

    private TextView say_my_name;
    private TextView welcome;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thankyou_main);
        say_my_name = findViewById(R.id.say_my_name);
        welcome = findViewById(R.id.welcome);
        StringBuilder msg = new StringBuilder("Thank you for registering: ");
        Intent intent = getIntent();

        Bundle b = intent.getExtras();

        if (b.containsKey(Constants.KEY_USERNAME)){
            String userName = b.getString(Constants.KEY_USERNAME);
            msg.append(userName);
        }


        welcome.setText(msg);


    }



    public void goBackMain(View view){
       Intent goBack = new Intent(Main2Activity.this, MainActivity.class) ;
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