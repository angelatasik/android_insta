package com.example.app_insta.model;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.app_insta.R;
import com.example.app_insta.model.Fragment.HomeFragment;
import com.example.app_insta.model.Fragment.NotificationFragment;
import com.example.app_insta.model.Fragment.ProfileFragment;
import com.example.app_insta.model.Fragment.SearchFragment;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationSelectedListener navigationItemSelectedListener=
            new BottomNavigationView.OnNavigationSelectedListener() {
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    switch(menuItem.getItemId()) {

                        case R.id.nav_home:
                            selectedFragment=new HomeFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragment=new SearchFragment();
                            break;
                        case R.id.nav_add:
                            selectedFragment=null;
                            startActivity(new Intent(MainActivity.this,PostActivity.class));
                            break;
                        case R.id.nav_heart:
                            selectedFragment=new NotificationFragment();
                            break;
                        case R.id.nav_profile:
                            SharedPreferences.Editor editor=getSharedPreferences("PREF", MODE_PRIVATE).edit();
                            editor.putString("profileid" , FirebaseAuth.getInstance().getCurrentUser().getUid());
                            editor.apply();
                            selectedFragment=new ProfileFragment();
                            break;
                    }
                    if (selectedFragment!=null)
                    {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();
                    }
                    return true;
                }
            };
}
