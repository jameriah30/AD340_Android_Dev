package com.example.jamer.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

//import com.crashlytics.android.Crashlytics;
//import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    TextView sayMyName;
    TextView TxtChange;
    Button BtnColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.sayMyName = findViewById(R.id.say_my_name);

        TxtChange = (TextView)findViewById(R.id.textView1);
        BtnColor = (Button)findViewById(R.id.button1);

        BtnColor.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                TxtChange.setTextColor(Color.GREEN);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_bye) {
            this.sayMyName.setText(R.string.thank_you);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
