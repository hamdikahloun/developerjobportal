package com.veganet.developerjobportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.veganet.developerjobportal.fargments.HomeFragment;
import com.veganet.developerjobportal.fargments.ProfileFragment;
import com.veganet.developerjobportal.fargments.SearchFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = getWindow().getDecorView().getSystemUiVisibility(); // get current flag
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;   // add LIGHT_STATUS_BAR to flag
            getWindow().getDecorView().setSystemUiVisibility(flags);
        }
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        setCurrentFragment(new HomeFragment());
    }

    private void setCurrentFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_home :
                setCurrentFragment(new HomeFragment());
                return true;
            case R.id.action_search :
                setCurrentFragment(new SearchFragment());
                return true;
            case R.id.action_profile :
                setCurrentFragment(new ProfileFragment());
                return true;
        }
        return false;
    }
}
