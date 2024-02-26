package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

@LargeTest

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testHomeFragmentDisplayed() {
        checkTextDisplayed(R.id.text_home, "This is home fragment");
    }

    @Test
    public void testNavigationDrawerItemsDisplayed() {
        openNavigationDrawer();

        checkNavigationDrawerItemDisplayed("Home");
        checkNavigationDrawerItemDisplayed("Gallery");
        checkNavigationDrawerItemDisplayed("Slideshow");
    }

    @Test
    public void testSlideshowFragmentDisplayed() {
        openNavigationDrawer();
        selectNavigationDrawerItem("Slideshow");

        checkTextDisplayed(R.id.text_slideshow, "This is slideshow fragment");
    }

    private void openNavigationDrawer() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withContentDescription("Open navigation drawer"))
                .check(matches(isDisplayed()))
                .perform(click());

        onView(withId(R.id.nav_view))
                .check(matches(isDisplayed()));
    }

    private void checkNavigationDrawerItemDisplayed(String itemName) {
        onView(allOf(withId(androidx.navigation.ui.R.id.design_menu_item_text), withText(itemName)))
                .check(matches(isDisplayed()));
    }

    private void selectNavigationDrawerItem(String itemName) {
        onView(withText(itemName))
                .perform(click());
    }

    private void checkTextDisplayed(int viewId, String text) {
        onView(withId(viewId))
                .check(matches(isDisplayed()))
                .check(matches(withText(text)));
    }
}
