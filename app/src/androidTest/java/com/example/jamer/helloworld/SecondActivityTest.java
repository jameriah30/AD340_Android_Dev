package com.example.jamer.helloworld;


import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SecondActivityTest {

    @Rule
    public ActivityTestRule<SecondActivity> activityTestRule
            = new ActivityTestRule<SecondActivity>(SecondActivity.class) {
        @Override
        protected Intent getActivityIntent() {
            Intent intentToTest = new Intent();
            intentToTest.putExtra(Constants.KEY_FIRST_NAME, "Jeremiah");
            intentToTest.putExtra(Constants.KEY_LAST_NAME, "Smith");
            intentToTest.putExtra(Constants.KEY_EMAIL, "jammy@gmail.com");
            intentToTest.putExtra(Constants.KEY_USERNAME, "jammy35");
            intentToTest.putExtra(Constants.KEY_AGE, "35");
            intentToTest.putExtra(Constants.KEY_OCCUPATION, "Student");
            intentToTest.putExtra(Constants.KEY_DESCRIPTION, "I like craft beer");
            intentToTest.putExtra(Constants.KEY_PASS, "password");
            intentToTest.putExtra(Constants.KEY_PASSAGAIN, "password");
            return intentToTest;
        }
    };

//Passed
//    @Test
//    public void testForTabs(){
//
//        onView(withId(R.id.viewpager))
//                .perform(click())
//                .check(matches(isDisplayed()));
//
//}


//    @Test
//    public void testSwipeThroughTabs() {
//        //Profile tab
//        onView(withId(R.id.p_age))
//                .check(matches(withText("Age:")));
//
//        onView(withId(R.id.p_occupation))
//                .check(matches(withText("Student")));
//
//        onView(withId(R.id.p_description))
//                .check(matches(withText("I like craft beer")));
//
//
//
//        onView(withId(R.id.viewpager))
//                .perform(swipeLeft());
//
//        onView(withId(R.id.viewpager))
//                .perform(swipeLeft());
//
//        //Settings tab
//        onView(withId(R.id.settingsFrag))
//                .check(matches(withText("Settings Fragment Soon to Come")));
//    }

//    @Test
//    public void testSwipeThroughFragments(){
//
//        onView(withId(R.id.viewpager))
//                .perform(swipeLeft());
//
//        //Matches tab
//        onView(withId(R.id.matchesFrag))
//                .check(matches(withText("Matches Fragment Soon to Come")));
//
//        onView(withId(R.id.viewpager))
//                .perform(swipeLeft());
//
//        //Settings tab
//        onView(withId(R.id.settingsFrag))
//                .check(matches(withText("Settings Fragment Soon to Come")));
//    }

//    @Test
//    public void testIntentExtra(){
//        onView(withId(R.id.p_age))
//                .check(matches(withText("Age:")));
//
//        onView(withId(R.id.p_occupation))
//                .check(matches(withText("Occupation:")));
//
//        onView(withId(R.id.p_description))
//                .check(matches(withText("Description:")));
//
//    }
//
//
//    @Test
//    public void testBackButton() {
//        Espresso.pressBack();
//
//        onView(withId(R.id.firstname_edittext))
//                .check(matches(withText("")));
//
//        onView(withId(R.id.lastname_edittext))
//                .check(matches(withText("")));
//
//        onView(withId(R.id.email_edittext))
//                .check(matches(withText("")));
//
//        onView(withId(R.id.username_edittext))
//                .check(matches(withText("")));
//
//        onView(withId(R.id.birthday_edittext))
//                .check(matches(withHint("Birthday")));
//    }



}
