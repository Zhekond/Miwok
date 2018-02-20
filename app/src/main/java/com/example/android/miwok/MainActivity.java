/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private TextView colorsView;
    private TextView membersView;
    private TextView phrasesView;
    private TextView numbersView;



    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Main activity","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Main activity","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Main activity","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Main activity","onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Main activity", "onStart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        myListener listener = new myListener();
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Log.i("Main activity", "onCreate");
//        colorsView = (TextView)findViewById(R.id.colors);
//        colorsView.setOnClickListener(listener);
//        membersView = (TextView)findViewById(R.id.family);
//        membersView.setOnClickListener(listener);
//        phrasesView = (TextView)findViewById(R.id.phrases);
//        phrasesView.setOnClickListener(listener);
//        numbersView = (TextView)findViewById(R.id.numbers);
//        numbersView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(), NumbersActivity.class);
//                startActivity (i);
//            }
//        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.myPager);

        FragmentManager fm = getSupportFragmentManager();

        fragPagerAdapter pagerAdapter = new fragPagerAdapter(fm);

        pager.setAdapter(pagerAdapter);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("NUMBERS"));
        tabLayout.addTab(tabLayout.newTab().setText("FAMILY"));
        tabLayout.addTab(tabLayout.newTab().setText("COLORS"));
        tabLayout.addTab(tabLayout.newTab().setText("PHRASES"));
        tabLayout.setupWithViewPager(pager);

    }

    public class myListener implements View.OnClickListener{
        @Override
        public void onClick(View V){
            int id = V.getId();
            if(id == colorsView.getId()) {
                Intent i = new Intent(getApplicationContext(), ColorsActivity.class);
                startActivity(i);
            }else if (id == membersView.getId()) {
                Intent i = new Intent(getApplicationContext(), MembersActivity.class);
                startActivity(i);
            }else if(id == phrasesView.getId()) {
                Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
                startActivity(i);
            }else{
                Toast toast = Toast.makeText(getApplicationContext(),"Fail",Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}