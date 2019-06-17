package com.example.tic_tac_toe;


import android.app.AlertDialog;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

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
import static android.support.test.espresso.matcher.ViewMatchers.withText;
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

        ViewInteraction button2 = onView(
                allOf(withId(R.id.button_0_1),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                1),
                        isDisplayed()));

        ViewInteraction button3 = onView(
                allOf(withId(R.id.button_0_2),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                2),
                        isDisplayed()));

        ViewInteraction button4 = onView(
                allOf(withId(R.id.button_1_0),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                0),
                        isDisplayed()));

        ViewInteraction button5 = onView(
                allOf(withId(R.id.button_1_1),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                1),
                        isDisplayed()));

        ViewInteraction button6 = onView(
                allOf(withId(R.id.button_1_2),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        1),
                                2),
                        isDisplayed()));

        ViewInteraction button7 = onView(
                allOf(withId(R.id.button_2_0),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        2),
                                0),
                        isDisplayed()));

        ViewInteraction button8 = onView(
                allOf(withId(R.id.button_2_1),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        2),
                                1),
                        isDisplayed()));

        ViewInteraction button9 = onView(
                allOf(withId(R.id.button_2_2),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        2),
                                2),
                        isDisplayed()));

        ViewInteraction button10 = onView(
                allOf(withId(R.id.button_2_2),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        2),
                                2),
                        isDisplayed()));
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
    public void Winning() {

        onView(withId(R.id.label_sc)).check(matches(withText("Score: ")));

        onView(withId(R.id.button_0_0)).perform(click());
        onView(withId(R.id.button_0_0)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_0_1)).perform(click());
        onView(withId(R.id.button_0_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_1_1)).perform(click());
        onView(withId(R.id.button_1_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_0_2)).perform(click());
        onView(withId(R.id.button_0_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_2_2)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.label_sc)).check(matches(withText("Score: 1")));
    }

    @Test
    public void Losing() {
        onView(withId(R.id.label_sc)).check(matches(withText("Score: ")));

        onView(withId(R.id.button_0_0)).perform(click());
        onView(withId(R.id.button_0_0)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_0_1)).perform(click());
        onView(withId(R.id.button_0_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_0_2)).perform(click());
        onView(withId(R.id.button_0_2)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_1_1)).perform(click());
        onView(withId(R.id.button_1_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_1_2)).perform(click());
        onView(withId(R.id.button_1_2)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_2_1)).perform(click());

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.label_sc)).check(matches(withText("Score: -2")));

    }

    @Test
    public void Draw() {
        onView(withId(R.id.label_sc)).check(matches(withText("Score: ")));
        onView(withId(R.id.button_0_0)).perform(click());
        onView(withId(R.id.button_0_0)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_0_2)).perform(click());
        onView(withId(R.id.button_0_2)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_0_1)).perform(click());
        onView(withId(R.id.button_0_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_1_1)).perform(click());
        onView(withId(R.id.button_1_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_1_2)).perform(click());
        onView(withId(R.id.button_1_2)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_1_0)).perform(click());
        onView(withId(R.id.button_1_0)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_2_2)).perform(click());
        onView(withId(R.id.button_2_2)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_2_1)).perform(click());
        onView(withId(R.id.button_2_1)).check(matches(not(isEnabled())));
        onView(withId(R.id.button_2_0)).perform(click());

        onView(withId(android.R.id.button1)).perform(click());

        onView(withId(R.id.label_sc)).check(matches(withText("Score: 0")));
    }

}