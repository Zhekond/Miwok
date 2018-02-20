package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by home on 7/22/2017.
 */

public class myFrag extends Fragment {
    public myFrag(){

    }
    int mCurrentPage;
    int color;
    private MediaPlayer player;
    private ListClickHandler myHandler;
    private AudioManager audioManager;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Bundle data = getArguments();
        mCurrentPage = data.getInt("current_page",0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.word_list, container,false);
        ListView listView = (ListView)v.findViewById(R.id.rootView);
        ArrayList<Word> words = new ArrayList<Word>();
        switch (mCurrentPage){
            case 1: {
                words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
                words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
                words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
                words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
                words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
                words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
                words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
                words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
                words.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
                words.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));
                color = R.color.category_numbers;
                break;
            }
            case 2:{
                words.add(new Word("father","әpә",R.drawable.family_father,R.raw.family_father));
                words.add(new Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
                words.add(new Word("son","angsi",R.drawable.family_son,R.raw.family_son));
                words.add(new Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
                words.add(new Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
                words.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
                words.add(new Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
                words.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
                words.add(new Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
                words.add(new Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));
                color = R.color.category_family;
                break;
            }
            case 3:{
                words.add(new Word("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
                words.add(new Word("green","chokokki",R.drawable.color_green,R.raw.color_green));
                words.add(new Word("brown","ṭakaakki",R.drawable.color_brown,R.raw.color_brown));
                words.add(new Word("gray","ṭopoppi",R.drawable.color_gray,R.raw.color_gray));
                words.add(new Word("black","kululli",R.drawable.color_black,R.raw.color_black));
                words.add(new Word("white","kelelli",R.drawable.color_white,R.raw.color_white));
                words.add(new Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
                words.add(new Word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
                color = R.color.category_colors;
                break;
            }
            case 4:{
                words.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
                words.add(new Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
                words.add(new Word("My name is...","oyaaset...",R.raw.phrase_my_name_is));
                words.add(new Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
                words.add(new Word("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
                words.add(new Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
                words.add(new Word("Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
                words.add(new Word("I’m coming.","әәnәm",R.raw.phrase_im_coming));
                words.add(new Word("Let’s go.","yoowutis",R.raw.phrase_lets_go));
                words.add(new Word("Come here.","әnni'nem",R.raw.phrase_come_here));
                color = R.color.category_phrases;
            }
        }

        WordAdapter myWord = new WordAdapter(getActivity(),words,color);
        listView.setAdapter(myWord);
        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        myHandler = new ListClickHandler(player,audioManager);
        listView.setOnItemClickListener(myHandler);
//        TextView tv = (TextView)v.findViewById(R.id.tv);
//        tv.setText("You are viewing the page #"+mCurrentPage+"\n\n"+"Swipe Horizontally left/right");
        return v;
    }
}
