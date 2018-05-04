package com.example.jamer.helloworld;

//import android.app.Activity;
////import android.app.DatePickerDialog;
////import android.content.pm.ActivityInfo;
////import android.support.test.InstrumentationRegistry;
////import android.support.test.espresso.action.ViewActions;
////import android.support.test.espresso.contrib.PickerActions;
////import android.support.test.espresso.Espresso;
////import android.support.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
////import android.support.test.rule.ActivityTestRule;
////import android.support.test.runner.AndroidJUnit4;
////import android.widget.DatePicker;
////
////import org.hamcrest.Matchers;
////import org.junit.Rule;
////import org.junit.Test;
////import org.junit.runner.RunWith;
////
////import static android.support.test.espresso.action.ViewActions.scrollTo;
////import static android.support.test.espresso.action.ViewActions.typeText;
////import static org.junit.Assert.*;
////
////import android.support.test.InstrumentationRegistry;
////
////
////import static android.support.test.espresso.Espresso.onView;
////import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
////import static android.support.test.espresso.action.ViewActions.click;
////import static android.support.test.espresso.matcher.ViewMatchers.withId;
////import static android.support.test.espresso.matcher.ViewMatchers.withText;
////import static android.support.test.espresso.assertion.ViewAssertions.matches;
////
////import java.util.concurrent.CountDownLatch;
////
////
////import static android.support.test.espresso.matcher.ViewMatchers.withClassName;


import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.PickerActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.DatePicker;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)

public class MainActivityTest2 {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

//    @Before
//    public void setUp() throws Exception {
//        // mActivity = mActivityTestRule.getActivity();
//    }
//
//    @After
//    public void tearDown() {
//        // mActivity = null;
//    }


    private String FirstName = "Jeremiah";
    private String LastName = "Smith";
    private String Email = "jammy@gmail.com";
    private String Username = "jammy35";
    private String Dob = "1982/11/02";
    private String Age = "35";
    private String Job = "Student";
    private String Bio = " I like craft beer";
    private String Pass ="password";
    private String PassAgain ="password";


//    @Test
//    public void testFirstName() {
//        onView(withId(R.id.firstname_edittext)).perform(typeText(FirstName));
//        closeSoftKeyboard();
////        onView(withId(R.id.submit_button)).perform(click());
//        onView(withId(R.id.firstname_edittext)).check(matches(withText(FirstName)));
//    }
//
//    @Test
//    public void testLastName() {
//        onView(withId(R.id.lastname_edittext)).perform(typeText(LastName));
//        closeSoftKeyboard();
////        onView(withId(R.id.submit_button)).perform(click());
//        onView(withId(R.id.lastname_edittext)).check(matches(withText(LastName)));
//    }
//
//    @Test
//    public void testEmail() {
//        onView(withId(R.id.email_edittext)).perform(typeText(Email));
//        closeSoftKeyboard();
////        onView(withId(R.id.submit_button)).perform(click());
//        onView(withId(R.id.email_edittext)).check(matches(withText(Email)));
//    }
//
//    @Test
//    public void testUsername() {
//        onView(withId(R.id.username_edittext)).perform(typeText(Username));
//        closeSoftKeyboard();
////        onView(withId(R.id.submit_button)).perform(click());
//        onView(withId(R.id.username_edittext)).check(matches(withText(Username)));
//    }
//
//    @Test
//    public void testBirthday() {
//        onView(withId(R.id.birthday_edittext)).perform(typeText(Dob));
//        closeSoftKeyboard();
////        onView(withId(R.id.submit_button)).perform(click());
//        onView(withId(R.id.birthday_edittext)).check(matches(withText(Dob)));
//    }
//
//    @Test
//    public void testJob() {
//        onView(withId(R.id.occupation_edittext)).perform(typeText(Job));
//        closeSoftKeyboard();
////        onView(withId(R.id.submit_button)).perform(click());
//        onView(withId(R.id.occupation_edittext)).check(matches(withText(Job)));
//    }
//
//    @Test
//    public void testDescription() {
//        onView(withId(R.id.description_edittext)).perform(typeText(Bio));
//        closeSoftKeyboard();
////        onView(withId(R.id.submit_button)).perform(click());
//        onView(withId(R.id.description_edittext)).check(matches(withText(Bio)));
//    }
//
//    @Test
//    public void testPassword() {
//        onView(withId(R.id.password_edittext)).perform(typeText(Pass));
//        closeSoftKeyboard();
////        onView(withId(R.id.submit_button)).perform(click());
//        onView(withId(R.id.password_edittext)).check(matches(withText(Pass)));
//    }
//
//    @Test
//    public void testPassAgain() {
//        onView(withId(R.id.password_again_edittext)).perform(typeText(PassAgain));
//        closeSoftKeyboard();
////        onView(withId(R.id.submit_button)).perform(click());
//        onView(withId(R.id.password_again_edittext)).check(matches(withText(PassAgain)));
//    }
//
//    @Test
//    public void testSubmitButton() {
//
//        onView(withId(R.id.firstname_edittext)).perform(scrollTo(),typeText(FirstName));
//        closeSoftKeyboard();
//
//        onView(withId(R.id.lastname_edittext)).perform(scrollTo(),typeText(LastName));
//        closeSoftKeyboard();
//
//        onView(withId(R.id.email_edittext)).perform(scrollTo(),typeText(Email));
//        closeSoftKeyboard();
//
////        onView(withId(R.id.birthday_edittext)).perform(scrollTo(),typeText(Dob));
////        closeSoftKeyboard();
//
//        setDate(R.id.birthday_edittext, 1982, 11, 2);
//        closeSoftKeyboard();
////        Espresso.closeSoftKeyboard();
//
//        onView(withId(R.id.username_edittext)).perform(scrollTo(),typeText(Username));
//        closeSoftKeyboard();
//
//        onView(withId(R.id.occupation_edittext)).perform(scrollTo(),typeText(Job));
//        closeSoftKeyboard();
//
//        onView(withId(R.id.description_edittext)).perform(scrollTo(),typeText(Bio));
//        closeSoftKeyboard();
//
//        onView(withId(R.id.password_edittext)).perform(scrollTo(),typeText(Pass));
//        closeSoftKeyboard();
//
//        onView(withId(R.id.password_again_edittext)).perform(scrollTo(),typeText(PassAgain));
//        closeSoftKeyboard();
//
//        onView(withId(R.id.submit_button)).perform(click());
//
//        // new activity
////        onView(withId(R.id.profilename)).check(matches(withText(Name)));
//        onView(withId(R.id.p_age)).check(matches(withText(Age)));
//        onView(withId(R.id.p_occupation)).check(matches(withText(Job)));
//        onView(withId(R.id.p_description)).check(matches(withText(Bio)));
//    }
//
//    private void setDate(int birthday_edittext, int i, int i1, int i2) {
//    }


    //inputValidationTest PASSED
    @Test
    public void inputValidationTest() {

        onView(withId(R.id.textView1))
                .check(matches(withText(R.string.register_form_text)));


//        onView(withId(R.id.goback_button))
//                .perform(click());

        onView(withId(R.id.firstname_edittext)).perform(scrollTo(),typeText(FirstName));


        onView(withId(R.id.lastname_edittext)).perform(scrollTo(), typeText(LastName));


        onView(withId(R.id.email_edittext)).perform(scrollTo(), typeText(Email));


        onView(withId(R.id.username_edittext)).perform(scrollTo(), typeText(Username));


        onView(withId(R.id.occupation_edittext)).perform(scrollTo(), typeText(Job));


        onView(withId(R.id.description_edittext)).perform(scrollTo(), typeText(Bio));
        Espresso.closeSoftKeyboard();

//        onView(withId(R.id.birthday_edittext))
//                .perform(click());
//        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
//                .perform(PickerActions.setDate(1982, 11, 2));
//        onView(withId(android.R.id.button1)).perform(click());

//        onView(withId(R.id.birthday_edittext))
//                .check(matches(withText(Dob)));
        setDate(R.id.birthday_edittext, 1982, 11, 2);
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.password_edittext)).perform(scrollTo(), typeText(Pass));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.password_again_edittext)).perform(scrollTo(), typeText(PassAgain));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.submit_button)).perform(scrollTo(),click());
//        Espresso.pressBack();

    }

    @Test
    public void goToSecondActivity(){

        onView(withId(R.id.textView1))
                .check(matches(withText(R.string.register_form_text)));


//        onView(withId(R.id.goback_button))
//                .perform(click());

        onView(withId(R.id.firstname_edittext)).perform(scrollTo(),typeText(FirstName));


        onView(withId(R.id.lastname_edittext)).perform(scrollTo(), typeText(LastName));


        onView(withId(R.id.email_edittext)).perform(scrollTo(), typeText(Email));


        onView(withId(R.id.username_edittext)).perform(scrollTo(), typeText(Username));


        onView(withId(R.id.occupation_edittext)).perform(scrollTo(), typeText(Job));


        onView(withId(R.id.description_edittext)).perform(scrollTo(), typeText(Bio));
        Espresso.closeSoftKeyboard();

//        onView(withId(R.id.birthday_edittext))
//                .perform(click());
//        onView(withClassName(Matchers.equalTo(DatePicker.class.getName())))
//                .perform(PickerActions.setDate(1982, 11, 2));
//        onView(withId(android.R.id.button1)).perform(click());

//        onView(withId(R.id.birthday_edittext))
//                .check(matches(withText(Dob)));
        setDate(R.id.birthday_edittext, 1982, 11, 2);
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.password_edittext)).perform(scrollTo(), typeText(Pass));
        Espresso.closeSoftKeyboard();

        onView(withId(R.id.password_again_edittext)).perform(scrollTo(), typeText(PassAgain));
        Espresso.closeSoftKeyboard();

//        onView(withId(R.id.submit_button)).perform(scrollTo(),click());
//        Espresso.pressBack();

        Intent intent = new Intent();

        intent.putExtra(Constants.KEY_FIRST_NAME, "Jeremiah");
        intent.putExtra(Constants.KEY_LAST_NAME, "Smith");
        intent.putExtra(Constants.KEY_EMAIL, "jammy@gmail.com");
        intent.putExtra(Constants.KEY_USERNAME, "jammy35");
        intent.putExtra(Constants.KEY_AGE, "35");
        intent.putExtra(Constants.KEY_OCCUPATION, "Student");
        intent.putExtra(Constants.KEY_DESCRIPTION, "I like craft beer");
        intent.putExtra(Constants.KEY_PASS, "password");
        intent.putExtra(Constants.KEY_PASSAGAIN, "password");

        mActivityTestRule.launchActivity(intent);

    }



    public static void setDate(int datePickerLaunchViewId, int year, int monthOfYear, int dayOfMonth) {
        onView(withId(datePickerLaunchViewId)).perform(click());
        onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, monthOfYear, dayOfMonth));
        onView(withId(android.R.id.button1)).perform(click());
    }



}