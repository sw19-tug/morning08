package com.example.tic_tac_toe;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.example.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TicTacToeUnitTest {

    @Rule
    public ActivityTestRule<TicTacToe> mActivityTestRule = new ActivityTestRule<>(TicTacToe.class);

    @Test
    public void checkTttButtonTest() {
        ViewInteraction button = onView(
                allOf(withId(R.id.button_0_0),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction button2 = onView(
                allOf(withId(R.id.button_0_1),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        ViewInteraction button3 = onView(
                allOf(withId(R.id.button_0_2),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                2),
                        isDisplayed()));
        button3.check(matches(isDisplayed()));

        ViewInteraction button4 = onView(
                allOf(withId(R.id.button_1_0),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        button4.check(matches(isDisplayed()));

        ViewInteraction button5 = onView(
                allOf(withId(R.id.button_1_1),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                1),
                        isDisplayed()));
        button5.check(matches(isDisplayed()));

        ViewInteraction button6 = onView(
                allOf(withId(R.id.button_1_2),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                2),
                        isDisplayed()));
        button6.check(matches(isDisplayed()));

        ViewInteraction button7 = onView(
                allOf(withId(R.id.button_2_0),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        2),
                                0),
                        isDisplayed()));
        button7.check(matches(isDisplayed()));

        ViewInteraction button8 = onView(
                allOf(withId(R.id.button_2_1),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        2),
                                1),
                        isDisplayed()));
        button8.check(matches(isDisplayed()));

        ViewInteraction button9 = onView(
                allOf(withId(R.id.button_2_2),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        2),
                                2),
                        isDisplayed()));
        button9.check(matches(isDisplayed()));

        ViewInteraction button10 = onView(
                allOf(withId(R.id.button_2_2),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        2),
                                2),
                        isDisplayed()));
        button10.check(matches(isDisplayed()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    //Test for two Player Mode

    @Test
    public void Winning(){
        int expected = TicTacToe.getScore() + 1;

        onView(withId(R.id.button_0_0)).perform(click());
        onView(withId(R.id.button_0_0)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_0_1)).perform(click());
        onView(withId(R.id.button_0_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_1_1)).perform(click());
        onView(withId(R.id.button_1_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_0_1)).perform(click());
        onView(withId(R.id.button_0_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_2_2)).perform(click());

        int actual = TicTacToe.getScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void Losing(){
        int expected = TicTacToe.getScore();

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
        onView(withId(R.id.button_2_0)).perform(click());
        onView(withId(R.id.button_2_0)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_2_1)).perform(click());
        onView(withId(R.id.button_2_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_2_2)).perform(click());


        int actual = TicTacToe.getScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void Draw() {
        int expected = TicTacToe.getScore() ;
        TicTacToe.click = 9;

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

        int actual = TicTacToe.getScore();

        Assert.assertEquals(expected, actual);
    }
    //Tests for Autoplayer Mode

    @Test
    public void WinningAutoplayer(){
        int expected = TicTacToe.getScore() + 1;
        TicTacToe.Autoplayer = true;

        TicTacToe.click = 9;
        onView(withId(R.id.button_0_0)).perform(click());
        onView(withId(R.id.button_0_0)).check(matches(not(isEnabled())));
        TicTacToe.click = 9;
        onView(withId(R.id.button_0_1)).perform(click());
        onView(withId(R.id.button_0_1)).check(matches(not(isEnabled())));
        TicTacToe.click = 9;
        onView(withId(R.id.button_1_2)).perform(click());
        onView(withId(R.id.button_1_2)).check(matches(not(isEnabled())));

        int actual = TicTacToe.getScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void LosingAutoplayer(){
        int expected = TicTacToe.getScore() - 2;
        TicTacToe.Autoplayer = true;

        TicTacToe.click = 10;
        onView(withId(R.id.button_0_0)).perform(click());
        onView(withId(R.id.button_0_0)).check(matches(not(isEnabled())));
        TicTacToe.click = 10;
        onView(withId(R.id.button_0_1)).perform(click());
        onView(withId(R.id.button_0_1)).check(matches(not(isEnabled())));
        TicTacToe.click = 10;
        onView(withId(R.id.button_1_2)).perform(click());
        onView(withId(R.id.button_1_2)).check(matches(not(isEnabled())));
        int actual = TicTacToe.getScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void DrawAutoplayer() {
        int expected = TicTacToe.getScore() ;
        TicTacToe.Autoplayer = true;

        TicTacToe.click = 9;

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

        int actual = TicTacToe.getScore();

        Assert.assertEquals(expected, actual);
    }

}
