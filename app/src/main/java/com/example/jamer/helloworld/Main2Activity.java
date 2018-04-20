package com.example.jamer.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thankyou_main);
        TextView welcome = findViewById(R.id.welcome);
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


}