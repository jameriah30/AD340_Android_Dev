package com.example.jamer.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = ProfileActivity.class.getSimpleName();



    private Adapter adapter;
    private ViewPager vpage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        adapter = new Adapter(getSupportFragmentManager());
        vpage = findViewById(R.id.viewpager);

        setupViewPager(vpage);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);

        tabs.setupWithViewPager(vpage);

        }

    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new ProfileFragment(), "Profile");
        adapter.addFragment(new MatchesFragment(), "Matches");
        adapter.addFragment(new SettingsFragment(), "Settings");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
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
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
//        Log.i(TAG, "onRestoreInstanceState()");
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
//
//        outState.putString(Constants.KEY_WELCOME_TEXT, welcome.getText().toString());
//
//    }


}