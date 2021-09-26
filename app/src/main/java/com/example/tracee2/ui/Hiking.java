package com.example.tracee2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tracee2.R;
import com.squareup.picasso.Picasso;

public class Hiking extends AppCompatActivity {
    private ImageView mHiking;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiking);
        ImageView imageView = findViewById(R.id.imageView5);
        String url = "https://images.pexels.com/photos/5065321/pexels-photo-5065321.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260";
        Picasso.get().load(url).placeholder(R.drawable.ic_launcher_foreground).into(imageView);

        mHiking = (ImageView) findViewById(R.id.imageView2);

        mHiking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hiking.this, Dashboard.class);
                startActivity(intent);
            }

        });



    }
}