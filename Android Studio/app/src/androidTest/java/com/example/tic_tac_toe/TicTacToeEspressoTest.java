package com.example.tic_tac_toe;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)

public class TicTacToeEspressoTest
{
    @Rule
    public ActivityTestRule<TicTacToe> mainActivityTestRule = new ActivityTestRule<>(TicTacToe.class);


    //Test for two Player Mode
    @Test
    public void testButtonsVisible()
    {
        onView(withId(R.id.label_sc)).check(matches(isDisplayed()));
        onView(withId(R.id.button_0_0)).check(matches(isDisplayed()));
        onView(withId(R.id.button_0_1)).check(matches(isDisplayed()));
        onView(withId(R.id.button_0_2)).check(matches(isDisplayed()));
        onView(withId(R.id.button_1_0)).check(matches(isDisplayed()));
        onView(withId(R.id.button_1_1)).check(matches(isDisplayed()));
        onView(withId(R.id.button_1_2)).check(matches(isDisplayed()));
        onView(withId(R.id.button_2_0)).check(matches(isDisplayed()));
        onView(withId(R.id.button_2_1)).check(matches(isDisplayed()));
        onView(withId(R.id.button_2_2)).check(matches(isDisplayed()));

    }


   @Test
    public void testButtonFunction(){
        onView(withId(R.id.button_0_0)).perform(click());
        onView(withId(R.id.button_0_0)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_0_1)).perform(click());
        onView(withId(R.id.button_0_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_0_2)).perform(click());
        onView(withId(R.id.button_0_2)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_1_0)).perform(click());
        onView(withId(R.id.button_1_0)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_1_1)).perform(click());
        onView(withId(R.id.button_1_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_1_2)).perform(click());
        onView(withId(R.id.button_1_2)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_2_1)).perform(click());
        onView(withId(R.id.button_2_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_2_2)).perform(click());
        onView(withId(R.id.button_2_2)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_2_0)).perform(click());
    }

}

