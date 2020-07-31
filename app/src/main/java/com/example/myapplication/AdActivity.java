package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getIntent().getIntExtra("ad_type",R.layout.activity_ad));



        TextView title = (TextView) findViewById(R.id.title);
        TextView description =(TextView) findViewById(R.id.description);
        ImageView icon = (ImageView)  findViewById(R.id.icon);
        ImageView image = (ImageView)  findViewById(R.id.mediaView);
        Button cta = (Button) findViewById(R.id.cta);


        Animation textFadeIn = AnimationUtils.loadAnimation(this, R.anim.text_fade_in);
        Animation descFadeIn = AnimationUtils.loadAnimation(this, R.anim.text_fade_in);
        Animation iconFadeIn = AnimationUtils.loadAnimation(this, R.anim.icon_fade_in);
        Animation imageFadeIn = AnimationUtils.loadAnimation(this, R.anim.image_fade_in);
        Animation buttonFadeIn = AnimationUtils.loadAnimation(this, R.anim.button_fade_in);



        descFadeIn.setStartOffset(300);
        imageFadeIn.setStartOffset(500);
        buttonFadeIn.setStartOffset(700);

        title.startAnimation(textFadeIn);

        if(description!=null){
            description.startAnimation(descFadeIn);
        }

        if(icon!=null){
            icon.startAnimation(iconFadeIn);
        }
        if(image!=null){
            image.startAnimation(imageFadeIn);
        }

        cta.startAnimation(buttonFadeIn);
    }
}