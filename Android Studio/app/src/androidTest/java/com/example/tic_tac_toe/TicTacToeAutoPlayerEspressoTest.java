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
import static org.hamcrest.Matchers.not;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)

public class TicTacToeAutoPlayerEspressoTest
{
    @Rule
    public ActivityTestRule<TicTacToeAutoPlayer> mainActivityTestRule = new ActivityTestRule<>(TicTacToeAutoPlayer.class);

    @Test
    public void testButtonsVisibleAuto()
    {
        onView(withId(R.id.button_1)).check(matches(isDisplayed()));
        onView(withId(R.id.button_2)).check(matches(isDisplayed()));
        onView(withId(R.id.button_3)).check(matches(isDisplayed()));
        onView(withId(R.id.button_4)).check(matches(isDisplayed()));
        onView(withId(R.id.button_5)).check(matches(isDisplayed()));
        onView(withId(R.id.button_6)).check(matches(isDisplayed()));
        onView(withId(R.id.button_7)).check(matches(isDisplayed()));
        onView(withId(R.id.button_8)).check(matches(isDisplayed()));
        onView(withId(R.id.button_9)).check(matches(isDisplayed()));

    }


    @Test
    public void testButtonFunctionAuto()
    {
        TicTacToeAutoPlayer.click = 9;
        onView(withId(R.id.button_1)).perform(click());
        onView(withId(R.id.button_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_2)).perform(click());
        onView(withId(R.id.button_2)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_3)).perform(click());
        onView(withId(R.id.button_3)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_4)).perform(click());
        onView(withId(R.id.button_4)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_5)).perform(click());
        onView(withId(R.id.button_5)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_6)).perform(click());
        onView(withId(R.id.button_6)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_8)).perform(click());
        onView(withId(R.id.button_8)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_7)).perform(click());
        onView(withId(R.id.button_7)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_9)).perform(click());
    }
}