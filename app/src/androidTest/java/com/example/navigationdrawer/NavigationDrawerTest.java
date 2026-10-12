package com.example.navigationdrawer;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.contrib.DrawerMatchers.isOpen;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.NavigationViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/** Drives the real drawer on a device or emulator. */
@RunWith(AndroidJUnit4.class)
public class NavigationDrawerTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activity = new ActivityScenarioRule<>(MainActivity.class);

    private int homeScreens() {
        int[] count = new int[1];
        activity.getScenario().onActivity(a ->
                count[0] = a.getSupportFragmentManager().getFragments().size());
        return count[0];
    }

    private void chooseHome() {
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open());
        onView(withId(R.id.navigation_view)).perform(NavigationViewActions.navigateTo(R.id.optHome));
    }

    @Test
    public void startsWithOneHomeScreen() {
        assertEquals(1, homeScreens());
    }

    @Test
    public void choosingHomeRepeatedlyKeepsOneScreen() {
        chooseHome();
        chooseHome();
        chooseHome();
        assertEquals(1, homeScreens());
        onView(withId(R.id.drawerLayout)).check(matches(isClosed()));
    }

    @Test
    public void rotationKeepsOneScreen() {
        ActivityScenario<MainActivity> scenario = activity.getScenario();
        scenario.recreate();
        assertEquals(1, homeScreens());
    }

    @Test
    public void backClosesTheDrawerBeforeLeaving() {
        onView(withId(R.id.drawerLayout)).perform(DrawerActions.open());
        onView(withId(R.id.drawerLayout)).check(matches(isOpen()));
        pressBack();
        onView(withId(R.id.drawerLayout)).check(matches(isClosed()));
        boolean[] finishing = new boolean[1];
        activity.getScenario().onActivity(a -> finishing[0] = a.isFinishing());
        assertFalse(finishing[0]);
    }
}
