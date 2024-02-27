package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static ru.kkuzmichev.simpleappforespresso.EspressoTestHelper.openNavigationDrawer;
import static ru.kkuzmichev.simpleappforespresso.EspressoTestHelper.selectNavigationDrawerItem;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;

@RunWith(AllureAndroidJUnit4.class)
public class GalleryTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);
        openNavigationDrawer();
        selectNavigationDrawerItem("Gallery");
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }

    @Test
    public void testSlideshowFragmentDisplayed() {
        onView(allOf(withId(R.id.item_number), withText("7")))
                .check(matches(withText("7")));
    }

    @Test
    public void testRecyclerViewItemCount() {
        onView(withId(R.id.recycle_view))
                .check(matches(CustomViewMatcher.recyclerViewSizeMatcher(10)))
                .check(CustomViewAssertion.isRecyclerView())
                .check(matches(isDisplayed()));
    }
}
