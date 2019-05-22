package com.example.tic_tac_toe;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.Espresso.registerIdlingResources;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)

public class TicTacToeColorPickerTest
{
    @Rule
    public ActivityTestRule<TicTacToe> mainActivityTestRule = new ActivityTestRule<>(TicTacToe.class);

    @Test
    public void testVisibility()
    {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Settings")).perform(click());

        try
        {
            Thread.sleep(50);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        onView(withId(R.id.chooseColorButton)).check(matches(isDisplayed()));
        onView(withId(R.id.startGameButton)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonChooseSign)).check(matches(isDisplayed()));
    }

    @Test
    public void testSignButton()
    {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Settings")).perform(click());

        onView(withId(R.id.buttonChooseSign)).perform(click());
        onView(withId(R.id.buttonChooseSign)).check(matches(withText("X")));

        try
        {
            Thread.sleep(50);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

        onView(withId(R.id.buttonChooseSign)).perform(click());
        onView(withId(R.id.buttonChooseSign)).check(matches(withText("O")));
    }
}