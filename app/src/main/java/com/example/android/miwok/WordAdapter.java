package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Panda on 12/22/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    int mycolor;

    public WordAdapter(Activity context, ArrayList<Word> words, int color){
        super(context,0,words);
        mycolor = color;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.numfield,parent,false);
        }
//        return super.getView(position, convertView, parent);
        Word currentWord = getItem(position);
        TextView defText = (TextView)listItemView.findViewById(R.id.defId);
        defText.setText(currentWord.getDefaultTranslation());
        TextView miwText = (TextView)listItemView.findViewById(R.id.miwId);
        miwText.setText(currentWord.getMiwokTranslation());
        LinearLayout layout = (LinearLayout)listItemView.findViewById(R.id.listId);
        layout.setBackgroundResource(mycolor);
//        ImageView playButton = (ImageView) listItemView.findViewById(R.id.playbutton);
//        playButton.setBackgroundColor(mycolor);
        if(currentWord.hasImage()){
            ImageView myImg = (ImageView) listItemView.findViewById(R.id.listImage);
            myImg.setImageResource(currentWord.getImageID());


        }else
        {
            ImageView myImg = (ImageView) listItemView.findViewById(R.id.listImage);
            myImg.setVisibility(View.GONE);
        }
        return listItemView;
    }
}
