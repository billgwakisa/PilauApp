package com.example.ladleo.pilauapp;

import android.app.Fragment;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;

public class MainActivity extends AppCompatActivity {

    BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                android.app.FragmentManager fragmentManager = getFragmentManager();
                android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();



                fragmentTransaction.add(R.id.contentContainer, new UserProfile(), "user_profile");
                fragmentTransaction.add(R.id.contentContainer, new NewPost(), "new_post");
                fragmentTransaction.add(R.id.contentContainer, new Explore(), "explore");

                if (tabId == R.id.action_profile){
//                    show user profile
                    UserProfile fragment = new UserProfile();
                    fragmentTransaction.add(R.id.contentContainer, fragment);
                    fragmentTransaction.commit();
                }
                else if(tabId == R.id.action_post){
                    Log.e("Message", "Action profile clicked:"+tabId);
//                    show the new post activity
                    NewPost fragment = new NewPost();
                    fragmentTransaction.add(R.id.contentContainer, fragment);
                    fragmentTransaction.commit();

                }
                else if(tabId == R.id.action_explore){
                    Log.e("Message", "Action profile clicked:"+tabId);
//                    show the explore activity
                    Explore fragment = new Explore();
                    fragmentTransaction.add(R.id.contentContainer, fragment);
                    fragmentTransaction.commit();
                }
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId() == R.id.action_profile){
//            setContentView(R.layout.activity_main);
//        }
//        else if(item.getItemId() == R.id.action_post){
//            setContentView(R.layout.single_post);
//        }
//        else if(item.getItemId() == R.id.action_explore){
//            setContentView(R.layout.city);
//        }
//        else {
//            setContentView(R.layout.activity_main);
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
