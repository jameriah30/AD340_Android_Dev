package com.example.jamer.helloworld;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.pm.ActivityInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
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

import static android.support.test.espresso.action.ViewActions.scrollTo;
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
    public void inputValidationTest(){

        onView(withId(R.id.textView1))
                .check(matches(withText(R.string.register_form_text)));



//        onView(withId(R.id.goback_button))
//                .perform(click());

        onView(withId(R.id.firstname_edittext)).perform(scrollTo(), typeText("Jeremiah"));
        onView(withId(R.id.lastname_edittext)).perform(scrollTo(), typeText("Smith"));
        onView(withId(R.id.email_edittext)).perform(scrollTo(), typeText("jammy@gmail.com"));
        onView(withId(R.id.username_edittext)).perform(scrollTo(), typeText("jammy35"));
        onView(withId(R.id.occupation_edittext)).perform(scrollTo(), typeText("Developer"));
        onView(withId(R.id.description_edittext)).perform(scrollTo(), typeText("I like craft beer"));
        setDate(R.id.birthday_edittext, 1982, 11, 2);
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.password_edittext)).perform(scrollTo(), typeText("password"));
        onView(withId(R.id.password_again_edittext)).perform(scrollTo(), typeText("password"));
        Espresso.closeSoftKeyboard();
//        onView(withId(R.id.submit_button))
//                .perform(click());
//        Espresso.closeSoftKeyboard();


        TestUtils.rotateScreen(mActivityTestRule.getActivity());

        // Make sure text view input  still has proper values after screen rotation

//        onView(withId(R.id.firstname_edittext)).perform(scrollTo()).check(matches(withText("Jeremiah")));
//        onView(withId(R.id.lastname_edittext)).perform(scrollTo()).check(matches(withText("Smith")));
//        onView(withId(R.id.email_edittext)).perform(scrollTo()).check(matches(withText("jammy@gmail.com")));
//        onView(withId(R.id.p_age)).perform(scrollTo()).check(matches(withText("35")));
//        onView(withId(R.id.p_occupation)).perform(scrollTo()).check(matches(withText("Developer")));
//        onView(withId(R.id.p_description)).perform(scrollTo()).check(matches(withText("I like craft beer")));
//        onView(withId(R.id.password_edittext)).perform(scrollTo()).check(matches(withText("password")));
//        onView(withId(R.id.password_again_edittext)).perform(scrollTo()).check(matches(withText("password")));


//        mActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        onView(withId(R.id.firstname_edittext)).perform(scrollTo()).check(matches(withText("Jeremiah")));
//        onView(withId(R.id.lastname_edittext)).perform(scrollTo()).check(matches(withText("Smith")));
//        onView(withId(R.id.email_edittext)).perform(scrollTo()).check(matches(withText("jammy@gmail.com")));
//        onView(withId(R.id.username_edittext)).check(matches(withText("jammy35")));
//        onView(withId(R.id.occupation_edittext)).perform(scrollTo()).check(matches(withText("Developer")));
//        onView(withId(R.id.description_edittext)).perform(scrollTo()).check(matches(withText("I like craft beer")));
//        onView(withId(R.id.password_edittext)).perform(scrollTo()).check(matches(withText("password")));
//        onView(withId(R.id.password_again_edittext)).perform(scrollTo()).check(matches(withText("password")));
//        mActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        onView(withId(R.id.firstname_edittext)).perform(scrollTo()).check(matches(withText("Jeremiah")));
//        onView(withId(R.id.lastname_edittext)).perform(scrollTo()).check(matches(withText("Smith")));
//        onView(withId(R.id.email_edittext)).perform(scrollTo()).check(matches(withText("jammy@gmail.com")));
//        onView(withId(R.id.username_edittext)).check(matches(withText("jammy35")));
//        onView(withId(R.id.occupation_edittext)).perform(scrollTo()).check(matches(withText("Developer")));
//        onView(withId(R.id.description_edittext)).perform(scrollTo()).check(matches(withText("I like craft beer")));
//        onView(withId(R.id.password_edittext)).perform(scrollTo()).check(matches(withText("password")));
//        onView(withId(R.id.password_again_edittext)).perform(scrollTo()).check(matches(withText("password")));
//        mActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);







//        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());

    }
//    @Test
//    public void rotatingSumbitwithValid() {
//        onView(withId(R.id.firstname_edittext)).perform(scrollTo(), typeText("Jeremiah"));
//        onView(withId(R.id.lastname_edittext)).perform(scrollTo(), typeText("Smith"));
//        onView(withId(R.id.username_edittext)).perform(scrollTo(), typeText("jammy35"));
//        onView(withId(R.id.email_edittext)).perform(scrollTo(), typeText("jammy@gmail.com"));
//        onView(withId(R.id.occupation_edittext)).perform(scrollTo(), typeText("Developer"));
//        onView(withId(R.id.description_edittext)).perform(scrollTo(), typeText("I like craft beer"));
//        onView(withId(R.id.password_edittext)).perform(scrollTo(), typeText("password"));
//        onView(withId(R.id.password_again_edittext)).perform(scrollTo(), typeText("password"));
//        Espresso.closeSoftKeyboard();
//        setDate(R.id.birthday_edittext, 1982, 11, 02);
//
//        // rotate the screen before
//        mActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        mActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        mActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//
//        Espresso.closeSoftKeyboard();
////        onView(withId(R.id.submit_button)).perform(ViewActions.scrollTo());
//        onView(withId(R.id.submit_button)).perform(click());
//    }

    public static void setDate(int datePickerLaunchViewId, int year, int monthOfYear, int dayOfMonth) {
        onView(withId(datePickerLaunchViewId)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, monthOfYear, dayOfMonth));
        onView(withId(android.R.id.button1)).perform(click());
    }



}