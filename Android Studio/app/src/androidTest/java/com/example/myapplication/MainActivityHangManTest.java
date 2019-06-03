package com.example.myapplication;


import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import com.example.R;
import com.example.hangman.HangManActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

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
        String input = "x";

        onView(withId(R.id.btn_start)).perform(click());

        for(int i = 2; i > 0; i--) {
            onView(withId(R.id.txtInput)).perform(typeText(input));
            pressBack();
            onView(withId(R.id.btn_check)).perform(click());
        }

        onView(withId(R.id.imageViewRope)).check(matches(isDisplayed()));
        onView(withId(R.id.imageViewHead)).check(matches(isDisplayed()));
        onView(withId(R.id.imageViewBody)).check(matches(not(isDisplayed())));
        onView(withId(R.id.imageViewLeftHand)).check(matches(not(isDisplayed())));
        onView(withId(R.id.imageViewLeftLeg)).check(matches(not(isDisplayed())));
        onView(withId(R.id.imageViewRightHand)).check(matches(not(isDisplayed())));
        onView(withId(R.id.imageViewRightLeg)).check(matches(not(isDisplayed())));
        onView(withId(R.id.imageViewFace)).check(matches(not(isDisplayed())));
        onView(withId(R.id.btn_start)).check(matches(not(isDisplayed())));
        onView(withId(R.id.btn_check)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_retry)).check(matches(isDisplayed()));
    }
    @Test
    public void testWholeWordWithGraphic()
    {
        String input = "x";

        onView(withId(R.id.btn_start)).perform(click());

        for(int i = 8; i > 0; i--) {
            onView(withId(R.id.txtInput)).perform(typeText(input));
            pressBack();
            onView(withId(R.id.btn_check)).perform(click());

        }

        onView(withId(R.id.imageViewRope)).check(matches(isDisplayed()));
        onView(withId(R.id.imageViewHead)).check(matches(isDisplayed()));
        onView(withId(R.id.imageViewBody)).check(matches(isDisplayed()));
        onView(withId(R.id.imageViewLeftHand)).check(matches(isDisplayed()));
        onView(withId(R.id.imageViewLeftLeg)).check(matches(isDisplayed()));
        onView(withId(R.id.imageViewRightHand)).check(matches(isDisplayed()));
        onView(withId(R.id.imageViewRightLeg)).check(matches(isDisplayed()));
        onView(withId(R.id.imageViewFace)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_start)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_check)).check(matches(not(isDisplayed())));
        onView(withId(R.id.btn_retry)).check(matches(not(isDisplayed())));

    }

    @Test
    public void testTip()
    {
        onView(withId(R.id.btn_start)).perform(click());
        onView(withId(R.id.btn_check)).perform(click());

        TextView textviewoutput = mainActivityTestRule.getActivity().findViewById(R.id.lblOutput);
        TextView textviewscore = mainActivityTestRule.getActivity().findViewById(R.id.lblScore);

        String initialoutput = textviewoutput.getText().toString();
        String initialscore = textviewscore.getText().toString();

        onView(withId(R.id.btn_tip)).perform(click());

        onView(withId(R.id.lblOutput)).check(matches(not(withText(initialoutput))));
        onView(withId(R.id.lblScore)).check(matches(not(withText(initialscore))));

    }
    @Test
    public void testTimerExists()
    {
        onView(withId(R.id.btn_start)).perform(click());
        onView(withId(R.id.stop_Watch)).check(matches(isDisplayed()));
    }

    @Test
    public void testMenubManageWordsIcon(){
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Manage Words")).perform(click());
    }

    @Test
    public void testManageWordsItemVisible(){
        openActionBarOverflowOrOptionsMenu(InstrumentationRegistry.getTargetContext());
        onView(withText("Manage Words")).perform(click());
        onView(withId(R.id.lbl_fix_words)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btn_return)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.lbl_varying_words)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.txtInput)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btn_delete)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btn_add)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }
}