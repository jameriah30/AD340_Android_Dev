package com.example.jamer.helloworld;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.pm.ActivityInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.PickerActions;
import android.support.test.espresso.Espresso;
import android.support.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.DatePicker;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.typeText;
import static org.junit.Assert.*;

import android.support.test.InstrumentationRegistry;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import java.util.concurrent.CountDownLatch;


import static android.support.test.espresso.matcher.ViewMatchers.withClassName;


@RunWith(AndroidJUnit4.class)

public class MainActivityTest2 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void thisIsATest(){

        onView(withId(R.id.textView1))
                .check(matches(withText(R.string.register_form_text)));



//        onView(withId(R.id.goback_button))
//                .perform(click());

        onView(withId(R.id.firstname_edittext)).perform(typeText("Jeremiah"));

        onView(withId(R.id.lastname_edittext)).perform(typeText("Smith"));

        onView(withId(R.id.email_edittext)).perform(typeText("jammy@gmail.com"));

        onView(withId(R.id.username_edittext)).perform(typeText("jammy35"));

        setDate(R.id.birthday_edittext, 1999, 11, 2);

        onView(withId(R.id.password_edittext)).perform(typeText("password"));

        onView(withId(R.id.password_again_edittext)).perform(typeText("password"));

        onView(withId(R.id.submit_button))
                .perform(click());


        Espresso.closeSoftKeyboard();

        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());

    }

    public static void setDate(int datePickerLaunchViewId, int year, int monthOfYear, int dayOfMonth) {
        onView(withId(datePickerLaunchViewId)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, monthOfYear, dayOfMonth));
        onView(withId(android.R.id.button1)).perform(click());
    }



}