package com.example.myapplication;


import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import com.example.R;
import com.example.hangman.HangMan;
import com.example.hangman.HangManActivity;
import com.example.hangman.HangManActivity;
import com.example.hangman.R;

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
    public ActivityTestRule<HangManActivity> mainActivityTestRule = new ActivityTestRule<>(HangManActivity.class);

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
    public void testGallowVisible()
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
    @Test
    public void testHeadGraphicDisplayed()
    {
        private HangMan hangman = new HangMan();
        String word = "fig";
        String input = "x";

        hangman.initialize();

        char[] testOutputarray = new char[word.length()];

        for(int i = 0; i < testOutputarray.length; i++) {
            testOutputarray[i] = '_';
        }
        hangman.setOutputarray(testOutputarray);
        hangman.setSearchedword(word);
        hangman.checkLetter(input);

        onView(withId(R.id.imageViewHead)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE);
    }
    @Test
    public void testWholeWordWithGraphic()
    {
        private HangMan hangman = new HangMan();
        String word = "lemon";
        String input = "x";

        hangman.initialize();

        char[] testOutputarray = new char[word.length()];
        for(int i = 0; i < testOutputarray.length; i++) {
            testOutputarray[i] = '_';
        }
        hangman.setOutputarray(testOutputarray);
        hangman.setSearchedword(word);

        for(int i = 6; i > 0; i--) {
            hangman.checkLetter(input);
        }

        onView(withId(R.id.imageViewHead)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE);
        onView(withId(R.id.imageViewThroat)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE);
        onView(withId(R.id.imageViewBody)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE);
        onView(withId(R.id.imageViewRightHand)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE);
        onView(withId(R.id.imageViewLeftHand)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE);
    }
}
