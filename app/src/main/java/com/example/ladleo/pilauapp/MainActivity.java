package com.example.ladleo.pilauapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.container) != null){
            if(savedInstanceState != null){
                return;
            }
        }
        //create a new a fragment to be placed in the actvity layout
        final Home homeFragment = new Home();
//        In case this activiity was passed with special instructions from an Intent
//        pass the Intent's extas as arguments to the fragment
        homeFragment.setArguments(getIntent().getExtras());

//        add the homeFragment to the "container" in FrameLayout
//        getSupportFragmentManager().beginTransaction().add(R.id.container, homeFragment).commit();

        final FragmentManager fragmentManager = getFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, homeFragment).commit();


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_profile:
                        Log.e("PROFILE", "profile has been clicked");
                        UserProfile userProfileFragment= new UserProfile();
                        userProfileFragment.setArguments(getIntent().getExtras());
                        FragmentTransaction profileFragmentTransaction = fragmentManager.beginTransaction();
                        profileFragmentTransaction.replace(R.id.container, userProfileFragment);
                        profileFragmentTransaction.addToBackStack(null);
                        profileFragmentTransaction.commit();
                        break;
                    case R.id.action_post:
                        Log.e("POST", "action has been clicked");
                        NewPost newPostFragment = new NewPost();
                        newPostFragment.setArguments(getIntent().getExtras());
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.container, newPostFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();

                        break;
                    case R.id.action_explore:
                        Log.e("EXPLORE","action explore has been clicked");
                        Explore exploreFragment= new Explore();
                        exploreFragment.setArguments(getIntent().getExtras());
                        FragmentTransaction exploreFragmentTransaction = fragmentManager.beginTransaction();
                        exploreFragmentTransaction.replace(R.id.container, exploreFragment);
                        exploreFragmentTransaction.addToBackStack(null);
                        exploreFragmentTransaction.commit();
                        break;
                }
                return false;
            }
        });
    }

}
