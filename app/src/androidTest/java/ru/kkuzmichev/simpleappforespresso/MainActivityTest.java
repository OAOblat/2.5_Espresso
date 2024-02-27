package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.kkuzmichev.simpleappforespresso.EspressoTestHelper.checkNavigationDrawerItemDisplayed;
import static ru.kkuzmichev.simpleappforespresso.EspressoTestHelper.checkTextDisplayed;
import static ru.kkuzmichev.simpleappforespresso.EspressoTestHelper.openNavigationDrawer;
import static ru.kkuzmichev.simpleappforespresso.EspressoTestHelper.selectNavigationDrawerItem;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;

@LargeTest

//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
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




}
