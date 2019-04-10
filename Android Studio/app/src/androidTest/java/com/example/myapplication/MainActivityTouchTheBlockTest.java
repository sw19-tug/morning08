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
    public void testClockButtonVisible() {
        onView(withId(R.id.tv_time)).check(matches(isDisplayed()));
    }
}