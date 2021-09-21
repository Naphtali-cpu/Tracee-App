package com.example.tracee2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.tracee2.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

public class Camping extends AppCompatActivity implements View.OnClickListener {
    private ImageView mHiking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camping);

        ImageView imageView = findViewById(R.id.imageView5);
        String url = "https://images.pexels.com/photos/2398220/pexels-photo-2398220.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260";
        Picasso.get().load(url).placeholder(R.drawable.ic_launcher_foreground).into(imageView);


        mHiking = (ImageView) findViewById(R.id.imageView2);


        mHiking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Camping.this, Dashboard.class);
                startActivity(intent);
            }

        });

    }

    @Override
    public void onClick(View v) {

    }
}