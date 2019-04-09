package com.example.myapplication;
import static android.support.test.espresso.action.ViewActions.click;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import com.example.R;
import com.example.touchtheblock.TouchTheBlock;
import org.junit.Rule;
import org.junit.Test;
import static android.support.test.espresso.Espresso.onView;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityTouchTheBlockTest {
    @Rule
    public ActivityTestRule<TouchTheBlock> mainActivityTestRule = new ActivityTestRule<>(TouchTheBlock.class);

    @Test
    public void testButtonsVisible()
    {

        onView(withId(R.id.btnPlayBox)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.btnEndGame)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE)));
        onView(withId(R.id.btn_startgame)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBlockCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

    }

    @Test
    public void testBlockChooseColor() throws InterruptedException
    {
        onView(withId(R.id.btnBlockCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBlockCol)).perform(click());
        Thread.sleep(100);
        onView(withId(R.id.button00)).perform(click());
    }

    @Test
    public void testBackChooseColor() throws InterruptedException
    {
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(100);
        onView(withId(R.id.button00)).perform(click());
    }


    @Test
    public void testColorBtn00() throws InterruptedException
    {
        String expected = "#00FFFF";
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(100);
        onView(withId(R.id.button00)).perform(click());

    }

    @Test
    public void testColorBtn01() throws InterruptedException
    {
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(100);
        onView(withId(R.id.button01)).perform(click());
    }

    @Test
    public void testColorBtn02() throws InterruptedException
    {
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(100);
        onView(withId(R.id.button02)).perform(click());
    }

    @Test
    public void testColorBtn03() throws InterruptedException
    {
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(100);
        onView(withId(R.id.button03)).perform(click());
    }



    @Test
    public void testColorBtn10() throws InterruptedException
    {
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(100);
        onView(withId(R.id.button10)).perform(click());
    }

    @Test
    public void testColorBtn11() throws InterruptedException
    {
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(100);
        onView(withId(R.id.button11)).perform(click());
    }

    @Test
    public void testColorBtn12() throws InterruptedException
    {
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(100);
        onView(withId(R.id.button12)).perform(click());
    }

    @Test
    public void testColorBtn13() throws InterruptedException
    {
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(100);
        onView(withId(R.id.button13)).perform(click());
    }


    @Test
    public void testColorBtn20() throws InterruptedException
    {
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(100);
        onView(withId(R.id.button20)).perform(click());
    }

    @Test
    public void testColorBtn21() throws InterruptedException
    {
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(100);
        onView(withId(R.id.button21)).perform(click());
    }

    @Test
    public void testColorBtn22() throws InterruptedException
    {
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(100);
        onView(withId(R.id.button22)).perform(click());
    }

    @Test
    public void testColorBtn23() throws InterruptedException
    {
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(100);
        onView(withId(R.id.button23)).perform(click());
    }


    @Test
    public void testColorBtn30() throws InterruptedException
    {
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(100);
        onView(withId(R.id.button30)).perform(click());
    }

    @Test
    public void testColorBtn31() throws InterruptedException
    {
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(100);
        onView(withId(R.id.button31)).perform(click());
    }

    @Test
    public void testColorBtn32() throws InterruptedException
    {
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(200);
        onView(withId(R.id.button32)).perform(click());
    }

    @Test
    public void testColorBtn33() throws InterruptedException
    {
        onView(withId(R.id.btnBackCol)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
        onView(withId(R.id.btnBackCol)).perform(click());
        Thread.sleep(200);
        onView(withId(R.id.button33)).perform(click());
    }





}