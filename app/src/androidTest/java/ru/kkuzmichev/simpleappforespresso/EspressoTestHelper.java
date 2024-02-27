package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

import java.util.concurrent.TimeUnit;

public class EspressoTestHelper {
    static void checkNavigationDrawerItemDisplayed(String itemName) {
        onView(allOf(withId(androidx.navigation.ui.R.id.design_menu_item_text), withText(itemName)))
                .check(matches(isDisplayed()));
    }

    static void selectNavigationDrawerItem(String itemName) {
        onView(withText(itemName))
                .perform(click());
    }

    static void checkTextDisplayed(int viewId, String text) {
        onView(withId(viewId))
                .check(matches(isDisplayed()))
                .check(matches(withText(text)));
    }

    static void openNavigationDrawer() {
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
}
