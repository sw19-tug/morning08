package com.example.myapplication;


import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)

public class MainActivityHangManTest
{
    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testButtonsVisible()
    {
        onView(withId(R.id.btn_start)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_check)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.btn_retry)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
    }
    @Test
    public void testLabelsVisible()
    {
        onView(withId(R.id.lblScore)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.lblOutput)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.txtInput)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
    }
    @Test
    public void testGalgenVisible()
    {
        onView(withId(R.id.imageViewGallow)).check(matches(isDisplayed()));
    }
    @Test
    public void testStartButtonClick()
    {
        onView(withId(R.id.btn_start)).perform(click());
        onView(withId(R.id.btn_check)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_retry)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_start)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
    }
}
