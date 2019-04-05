package com.gbsojo.platzigram.view;

import android.support.annotation.NonNull;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.gbsojo.platzigram.R;
import com.gbsojo.platzigram.view.fragment.ExploreFragment;
import com.gbsojo.platzigram.view.fragment.ProfileFragment;
import com.gbsojo.platzigram.view.fragment.TimelineFragment;

public class AppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        final TimelineFragment timelineFragment = new TimelineFragment();
        final ExploreFragment exploreFragment = new ExploreFragment();
        final ProfileFragment profileFragment = new ProfileFragment();

        BottomNavigationView bottombar = findViewById(R.id.navigation);
        bottombar.setSelectedItemId(R.id.navigation_timeline);
        bottombar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_timeline:
                        addFragment(timelineFragment);
                        break;
                    case R.id.navigation_explore:
                        addFragment(exploreFragment);
                        break;
                    case R.id.navigation_profile:
                        addFragment(profileFragment);
                        break;
                }
                return true;
            }

            private void addFragment(Fragment fragment) {
                if (null != fragment) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.app_container, fragment)
                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
    }
}
