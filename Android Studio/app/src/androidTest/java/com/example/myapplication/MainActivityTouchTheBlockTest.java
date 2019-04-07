package com.example.myapplication;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.example.R;


import com.example.touchtheblock.TouchTheBlock;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityTouchTheBlockTest {
    @Rule
    public ActivityTestRule<TouchTheBlock> mainActivityTestRule = new ActivityTestRule<>(TouchTheBlock.class);

    @Test
    public void testPlayButtonVisible()
    {
        onView(withId(R.id.btnPlayBox)).check(matches(isDisplayed()));
    }

    @Test
    public void testEndButtonVisible()
    {
        onView(withId(R.id.btnEndGame)).check(matches(isDisplayed()));
    }

    /*@Test
    public void testStartButtonClick()
    {
        onView(withId(R.id.btn_start)).perform(click());
        onView(withId(R.id.btn_check)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_retry)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_start)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
    }*/
}