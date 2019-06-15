package com.example.myapplication;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.R;
import com.example.fourinarow.FourInARowActivity;
import com.example.tic_tac_toe.TicTacToe;

import org.junit.Assert;
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
    public void testMainMenueButtonsVisible()
    {
        onView(withId(R.id.Button_Start)).check(matches(isDisplayed()));
        onView(withId(R.id.GridLayout_Grid)).check(matches(not(isDisplayed())));
    }

    @Test
    public void testGameElementsButtonsVisible()
    {
        onView(withId(R.id.Button_Start)).perform(click());
        onView(withId(R.id.GridLayout_Grid)).check(matches(isDisplayed()));

        Button button = mainActivityTestRule.getActivity().findViewById(R.id.Button_Start);
        String actualText = button.getText().toString();
        Assert.assertEquals(actualText, "Reset");

    }

    @Test
    public void testSetToken()
    {
        onView(withId(R.id.Button_Start)).perform(click());
        onView(withId(R.id.ImageView_5_0)).perform((click()));
        onView(withId(R.id.ImageView_5_0)).perform((click()));
        onView(withId(R.id.ImageView_5_0)).perform((click()));

        GradientDrawable backgroundGradient0 = (GradientDrawable) mainActivityTestRule.getActivity().findViewById(R.id.ImageView_0_0).getBackground();
        GradientDrawable backgroundGradient2 = (GradientDrawable) mainActivityTestRule.getActivity().findViewById(R.id.ImageView_2_0).getBackground();

        Assert.assertEquals(backgroundGradient0.getColor(), backgroundGradient2.getColor());
    }

    @Test
    public void testInitialScore()
    {
        String expexted_value = "0";

        onView(withId(R.id.Button_Start)).perform(click());
        onView(withId(R.id.Label_ScoreUser_1)).check(matches(isDisplayed()));
        onView(withId(R.id.Label_ScoreUser_2)).check(matches(isDisplayed()));

        TextView lbl_score_player1 = mainActivityTestRule.getActivity().findViewById(R.id.Label_ScoreUser_1);
        TextView lbl_score_player2 = mainActivityTestRule.getActivity().findViewById(R.id.Label_ScoreUser_1);
        String actual_text_player1 = lbl_score_player1.getText().toString();
        String actual_text_player2 = lbl_score_player2.getText().toString();

        Assert.assertEquals(actual_text_player1, actual_text_player2);
        Assert.assertEquals(actual_text_player1, expexted_value);
    }

    @Test
    public void testIncreaseScore()
    {
        String expexted_value_user1 = "1";
        String expexted_value_user2 = "0";


        onView(withId(R.id.Button_Start)).perform(click());
        onView(withId(R.id.Label_ScoreUser_1)).check(matches(isDisplayed()));
        onView(withId(R.id.Label_ScoreUser_2)).check(matches(isDisplayed()));

        for(int i = 0; i<3;i++)
        {
            onView(withId(R.id.ImageView_5_0)).perform((click()));
            onView(withId(R.id.ImageView_5_1)).perform((click()));
        }
        onView(withId(R.id.ImageView_5_0)).perform((click()));


        TextView lbl_score_player1 = mainActivityTestRule.getActivity().findViewById(R.id.Label_ScoreUser_1);
        TextView lbl_score_player2 = mainActivityTestRule.getActivity().findViewById(R.id.Label_ScoreUser_2);
        String actual_text_player1 = lbl_score_player1.getText().toString();
        String actual_text_player2 = lbl_score_player2.getText().toString();

        Assert.assertEquals(actual_text_player1, expexted_value_user1);
        Assert.assertEquals(actual_text_player2, expexted_value_user2);

    }


}
