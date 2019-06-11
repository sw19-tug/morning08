package com.example.myapplication;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.example.R;
import com.example.hangman.HangManActivity;
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
        public void testTimeVisible()
        {
                onView(withId(R.id.tv_time)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));

        }

        @Test
        public void testTimeVisibleAfterBtnEnd() throws InterruptedException {
                onView(withId(R.id.btn_startgame)).perform(click());

                onView(withId(R.id.btnPlayBox)).perform(click());
                onView(withId(R.id.tv_time)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
                onView(withId(R.id.btnEndGame)).perform(click());
                onView(withId(R.id.tv_time)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

        }

        @Test
        public void testTimeVisibleAfterTimeout() throws InterruptedException {
                onView(withId(R.id.btn_startgame)).perform(click());

                onView(withId(R.id.btnPlayBox)).perform(click());
                onView(withId(R.id.tv_time)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
                Thread.sleep(2500);
                onView(withId(R.id.tv_time)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));

        }

        @Test
        public void testScoreButtonisDisplayed(){
                onView(withId(R.id.tv_score)).check(matches(isDisplayed()));
        }

        @Test
        public void testContinueButtonNotDisplayed(){
                onView(withId(R.id.Button_Continue)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        }

}
