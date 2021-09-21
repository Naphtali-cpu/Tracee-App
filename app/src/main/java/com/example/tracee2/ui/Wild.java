package com.example.tracee2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.tracee2.R;
import com.squareup.picasso.Picasso;

public class Wild extends AppCompatActivity {
    private ImageView mHiking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wild);

        ImageView imageView = findViewById(R.id.imageView5);
        String url = "https://images.pexels.com/photos/6796879/pexels-photo-6796879.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260";
        Picasso.get().load(url).placeholder(R.drawable.ic_launcher_foreground).into(imageView);

        mHiking = (ImageView) findViewById(R.id.imageView2);

        mHiking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Wild.this, Dashboard.class);
                startActivity(intent);
            }

        });
    }
}