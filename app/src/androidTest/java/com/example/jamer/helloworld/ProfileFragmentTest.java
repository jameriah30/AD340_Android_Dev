package com.example.jamer.helloworld;

//public class ProfileFragmentTest {
//}

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ProfileFragmentTest {

    @Rule
    public ActivityTestRule<ProfileActivity> activityTestRule
            = new ActivityTestRule<ProfileActivity>(ProfileActivity.class) {
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


//    @Test
//    public void testThatImageExists() {
//        onView(withId(R.id.img))
//                .check(matches(isDisplayed()));
//    }
//
//    @Test
//    public void testThatNameExists() {
//        onView(withId(R.id.profilename))
//                .check(matches(isDisplayed()));
//    }

//    @Test
//    public void testIntentExtra(){
//        onView(withId(R.id.p_age))
//                .check(matches(withText("35")));
//
//        onView(withId(R.id.p_occupation))
//                .check(matches(withText("Student")));
//
//        onView(withId(R.id.p_description))
//                .check(matches(withText("I like craft beer")));
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
////        onView(withId(R.id.birthday_edittext))
////                .check(matches(withHint(@string/birthday)));
//    }

//    @Test
//    public void testThatAgeExists() {
//        onView(withId(R.id.p_age))
//                .check(matches(withText("35")));
//    }
//
//
//    @Test
//    public void testThatOccupationExists() {
//        onView(withId(R.id.p_occupation))
//                .check(matches(withText("Student")));
//    }
//
//    @Test
//    public void testThatBioExists() {
//        onView(withId(R.id.p_description))
//                .check(matches(withText("I like craft beer")));
//    }


//    @Test
//    public void testThatNewProfileButtonExists() {
//        onView(withId(R.id.goback_button))
//                .check(matches(isDisplayed()));
//    }

//    @Test
//    public void testThatNewProfileFileButtonIsClickAble() {
//        onView(withId(R.id.goback_button)).perform(click());
////        onView(withId(R.id.firstname_edittext)).check(matches(withText("")));
//    }

}
