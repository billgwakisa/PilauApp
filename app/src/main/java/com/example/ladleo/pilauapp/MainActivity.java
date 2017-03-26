package com.example.ladleo.pilauapp;

import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.action_profile:
                        Log.e("PROFILE", "profile has been clicked");
                        break;
                    case R.id.action_post:
                        Log.e("POST", "action has been clicked");
                        break;
                    case R.id.action_explore:
                        Log.e("EXPLORE","action explore has been clicked");
                        break;
                }
                return false;
            }
        });
    }

    //    BottomBar mBottomBar;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
//        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
//            @Override
//            public void onTabReSelected(@IdRes int tabId) {
//                android.app.FragmentManager fragmentManager = getFragmentManager();
//                android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                fragmentTransaction.add(R.id.contentContainer, new UserProfile(), "user_profile");
//                fragmentTransaction.add(R.id.contentContainer, new NewPost(), "new_post");
//                fragmentTransaction.add(R.id.contentContainer, new Explore(), "explore");
//
//                if (tabId == R.id.action_profile){
////                    show user profile
//                    UserProfile fragment = new UserProfile();
//                    fragmentTransaction.replace(R.id.contentContainer, fragment);
//                    fragmentTransaction.addToBackStack(null);
//                    fragmentTransaction.commit();
//                }
//                else if(tabId == R.id.action_post){
//                    Log.e("Message", "Action profile clicked:"+tabId);
////                    show the new post activity
//                    NewPost fragment = new NewPost();
//                    fragmentTransaction.replace(R.id.contentContainer, fragment);
//                    fragmentTransaction.addToBackStack(null);
//                    fragmentTransaction.commit();
//                }
//                else if(tabId == R.id.action_explore){
//                    Log.e("Message", "Action profile clicked:"+tabId);
////                    show the explore activity
//                    Explore fragment = new Explore();
//                    fragmentTransaction.replace(R.id.contentContainer, fragment);
//                    fragmentTransaction.addToBackStack(null);
//                    fragmentTransaction.commit();
//                }
//            }
//        });
//    }
//
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        getMenuInflater().inflate(R.menu.activity_main, menu);
////        return true;
////    }
////
////    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////        if(item.getItemId() == R.id.action_profile){
////            setContentView(R.layout.activity_main);
////        }
////        else if(item.getItemId() == R.id.action_post){
////            setContentView(R.layout.single_post);
////        }
////        else if(item.getItemId() == R.id.action_explore){
////            setContentView(R.layout.city);
////        }
////        else {
////            setContentView(R.layout.activity_main);
////        }
////        return super.onOptionsItemSelected(item);
////    }
}
