package com.example.myapplication;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;
import com.example.R;
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
    public void testButtonsVisible()
    {
        Log.d("Testing: ", "In testButtonVisible");
        onView(withId(R.id.btnPlayBox)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.btnEndGame)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.btn_startgame)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        Log.d("Testing: ", "Out testButtonVisible");
    }


    @Test
    public void testLabelsVisible()
    {
        Log.d("Testing: ", "In testLabelsVisible");
        onView(withId(R.id.tv_gamelost)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        Log.d("Testing: ", "Out testLabelsVisible");
    }

    @Test
    public void testStartButtonClick()
    {
        Log.d("Testing: ", "In testStartButtonClick");
        onView(withId(R.id.btn_startgame)).perform(click());
        onView(withId(R.id.btnPlayBox)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnEndGame)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btn_startgame)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.tv_gamelost)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        Log.d("Testing: ", "Out testStartButtonClick");
    }

    @Test
    public void testPlayButtonClick()
    {
        Log.d("Testing: ", "In testPlayButtonClick");
        onView(withId(R.id.btn_startgame)).perform(click());
        onView(withId(R.id.btnPlayBox)).perform(click());
        onView(withId(R.id.btnPlayBox)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnEndGame)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btn_startgame)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.tv_gamelost)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        Log.d("Testing: ", "Out testPlayButtonClick");
    }



    @Test
    public void testEndButtonClick()
    {
        Log.d("Testing: ", "In testEndButtonClick");
        onView(withId(R.id.btn_startgame)).perform(click());
        onView(withId(R.id.btnEndGame)).perform(click());
        onView(withId(R.id.btnPlayBox)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnEndGame)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btn_startgame)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.tv_gamelost)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        Log.d("Testing: ", "Out testEndButtonClick");
    }
}