package com.example.jamer.helloworld;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import android.support.test.InstrumentationRegistry;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

@RunWith(AndroidJUnit4.class)

public class MainActivityTest2 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void thisIsATest(){

        onView(withId(R.id.textView1))
                .check(matches(withText(R.string.hello_world)));

        onView(withId(R.id.button1))
                .perform(click());

        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());

    }

}