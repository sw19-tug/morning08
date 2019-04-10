package com.example.myapplication;
import static android.support.test.espresso.action.ViewActions.click;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;


import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

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
import static android.support.test.espresso.matcher.ViewMatchers.withText;


public class MainActivityTouchTheBlockTest {


        @Rule
        public ActivityTestRule<TouchTheBlock> mainActivityTestRule = new ActivityTestRule<>(TouchTheBlock.class);

        @Test
        public void testTimeVisible()
        {
            onView(withId(R.id.btnTime)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        }

        @Test
        public void testTimeSetVisible() {
                onView(withId(R.id.btnTime)).check(matches(isDisplayed()));
                onView(withId(R.id.btnTime)).check(matches(withText("2")));
        }
}
