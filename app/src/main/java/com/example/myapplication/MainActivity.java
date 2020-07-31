package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //Button interstitial = (Button) findViewById(R.id.interstitial_button);
        Button  loadAd  = (Button) findViewById(R.id.load_ad_button);
        final Spinner adtype_spinner = (Spinner) findViewById(R.id.adtype_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ad_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        adtype_spinner.setAdapter(adapter);

        final Spinner theme_spinner = (Spinner) findViewById(R.id.theme_spinner);
        ArrayAdapter<CharSequence> themeAdapter = ArrayAdapter.createFromResource(this,
                R.array.themes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        theme_spinner.setAdapter(themeAdapter);

        loadAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdActivity.class);
                String selectedAdType = adtype_spinner.getSelectedItem().toString();


                int viewToDisplay=0;
                if(selectedAdType==getString(R.string.adaptive_banner)){
                    viewToDisplay = R.layout.dark_banner_adaptive;
                }
                else  if(selectedAdType==getString(R.string.full_banner)){
                    viewToDisplay = R.layout.dark_banner_full;
                }
                else  if(selectedAdType==getString(R.string.mrec_banner)){
                    viewToDisplay = R.layout.dark_banner_mrec;
                }
                else  if(selectedAdType==getString(R.string.standard_banner)){
                    viewToDisplay = R.layout.dark_banner_standard;
                }
                else  if(selectedAdType==getString(R.string.interstitial)){
                    viewToDisplay = R.layout.dark_interstitial;
                }

                intent.putExtra("ad_type", viewToDisplay);

                startActivity(intent);

            }
        });

    }
}