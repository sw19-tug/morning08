package com.example.myapplication;


import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.R;
import com.example.fourinarow.FourInARowActivity;
import com.example.tic_tac_toe.TicTacToe;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
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

public class MainActivityFourInARowTest {

    @Rule
    public ActivityTestRule<FourInARowActivity> mainActivityTestRule = new ActivityTestRule<>(FourInARowActivity.class);


    @Test
    public void testButtonsVisible()
    {
        // DropDown Menu
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Color Settings")).perform(click());

        onView(withId(R.id.btn_start)).check(matches(isDisplayed()));

        // row selection
        onView(withId(R.id.Grid)).check(matches(not(isDisplayed())));



    }


}
