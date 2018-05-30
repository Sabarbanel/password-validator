package com.example.sarah.passwordval;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoTests {

    @Rule
    public ActivityTestRule<ValidateActivity> espTestActivity = new ActivityTestRule<>(
            ValidateActivity.class);

    @Test
    public void caseIssue() {
        onView(withId(R.id.editText)).perform(typeText("rooo1234oooof"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("This password is too weak")));

        onView(withId(R.id.editText)).perform(typeText("ROOO1234OOOOF"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("This password is too weak")));
    }

    @Test
    public void namedPasswordIssue() {
        onView(withId(R.id.editText)).perform(typeText("paSsword"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("This password is too weak")));
    }
    @Test
    public void failsRegex() {
        onView(withId(R.id.editText)).perform(typeText("paSsword1234"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("This password is too weak")));
    }
    @Test
    public void failsLetterReq() {
        onView(withId(R.id.editText)).perform(typeText("12345678"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("This password is too weak")));
    }
    @Test
    public void failsNumberReq() {
        onView(withId(R.id.editText)).perform(typeText("FloooooooofyCat"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("This password is too weak")));
    }
    @Test
    public void verifyPassing() {
        onView(withId(R.id.editText)).perform(typeText("13%CAtsP\\"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("This password is sufficiently strong")));
    }
    @Test
    public void verifyClickingWorksWhenOverpressed() {
        onView(withId(R.id.editText)).perform(typeText("R5(9grite34"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("This password is sufficiently strong")));
    }



    }

