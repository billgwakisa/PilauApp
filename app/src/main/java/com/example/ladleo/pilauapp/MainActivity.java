package com.example.ladleo.pilauapp;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
                if (tabId == R.id.action_profile){
//                    show user profile
//                    setContentView(R.layout.profile);
                    setContentView(R.layout.city);
                }
                else if(tabId == R.id.action_post){
//                    show the new post activity
//                    setContentView(R.layout.new_post);
                    setContentView(R.layout.single_post);
                }
                else if(tabId == R.id.action_explore){
//                    show the explore activity
//                    setContentView(R.layout.explore);
                    setContentView(R.layout.home);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_profile){
            setContentView(R.layout.activity_main);
        }
        else if(item.getItemId() == R.id.action_post){
            setContentView(R.layout.single_post);
        }
        else if(item.getItemId() == R.id.action_explore){
            setContentView(R.layout.city);
        }
        else {
            setContentView(R.layout.activity_main);
        }
        return super.onOptionsItemSelected(item);
    }
}
