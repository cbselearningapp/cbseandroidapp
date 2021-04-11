package com.basith.cbseapp.Activities.Dashboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.basith.cbseapp.Activities.Dashboard.Fragments.NinthFragment;
import com.basith.cbseapp.Activities.Dashboard.Fragments.NotificationFragment;
import com.basith.cbseapp.Activities.Dashboard.Fragments.SettingsFragment;
import com.basith.cbseapp.Activities.Dashboard.Fragments.TenthFragment;
import com.basith.cbseapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {

    final Fragment fragment1 = new TenthFragment();
    final Fragment fragment2 = new NinthFragment();
    final Fragment fragment4 = new SettingsFragment();
    final Fragment fragment3 = new NotificationFragment();
    final FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        setBottomNav();
        fragmentManager.beginTransaction().replace(R.id.containerview, fragment1).commit();
    }


    public void setBottomNav(){
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_10);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.action_10:
                        fragment = fragment1;
                        fragmentManager.beginTransaction().replace(R.id.containerview, fragment).commit();
                        return true;
                    case R.id.action_9:
                        fragment = fragment2;
                        fragmentManager.beginTransaction().replace(R.id.containerview, fragment).commit();
                        return true;
                    case R.id.action_notifications:
                        fragment = fragment3;
                        fragmentManager.beginTransaction().replace(R.id.containerview, fragment).commit();
                        return true;
                    case R.id.action_settings:
                        fragment = fragment4;
                        fragmentManager.beginTransaction().replace(R.id.containerview, fragment).commit();
                        return true;
                    default:
                        return true;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }



}