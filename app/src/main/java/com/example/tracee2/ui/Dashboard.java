package com.example.tracee2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.tracee2.Constants;
import com.example.tracee2.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import butterknife.*;
import butterknife.ButterKnife;

public class Dashboard extends AppCompatActivity implements View.OnClickListener{
    Button btnLogOut;
    Button mbottomNavigationView;
    FirebaseAuth mAuth;
    @BindView(R.id.savedRestaurantsButton) Button mSavedRestaurantsButton;
    @BindView(R.id.findRestaurantsButton) Button mFindRestaurantsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        ImageView imageView = findViewById(R.id.imageview);
        ImageView imageView2 = findViewById(R.id.imageview2);
        ImageView imageView3 = findViewById(R.id.imageview3);
        ImageView imageView4 = findViewById(R.id.imageview4);
        ImageView imageView5 = findViewById(R.id.imageview5);
        ImageView imageView6 = findViewById(R.id.imageview6);
        ImageView imageView7 = findViewById(R.id.imageview7);
        ImageView imageView8 = findViewById(R.id.imageview8);
        ImageView imageView9 = findViewById(R.id.imageview9);
        ImageView imageView10 = findViewById(R.id.imageview10);
        String url = "https://images.pexels.com/photos/7107622/pexels-photo-7107622.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";
        String url2 = "https://images.pexels.com/photos/1443527/pexels-photo-1443527.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";
        String url3 = "https://images.pexels.com/photos/5914157/pexels-photo-5914157.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";
        String url4 = "https://images.pexels.com/photos/1142941/pexels-photo-1142941.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";
        String url5 = "https://images.pexels.com/photos/885880/pexels-photo-885880.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";
        String url6 = "https://images.pexels.com/photos/4032590/pexels-photo-4032590.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";
        String url7 = "https://images.pexels.com/photos/1576939/pexels-photo-1576939.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";
        String url8= "https://images.pexels.com/photos/7026406/pexels-photo-7026406.jpeg?auto=compress&cs=tinysrgb&h=650&w=940";
        String url9 = "https://images.pexels.com/photos/1373009/pexels-photo-1373009.png?auto=compress&cs=tinysrgb&dpr=1&w=500";
        String url10 = "https://images.pexels.com/photos/2385654/pexels-photo-2385654.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500";

        Picasso.get().load(url).placeholder(R.drawable.ic_launcher_foreground).into(imageView);
        Picasso.get().load(url2).placeholder(R.drawable.ic_launcher_foreground).into(imageView2);
        Picasso.get().load(url3).placeholder(R.drawable.ic_launcher_foreground).into(imageView3);
        Picasso.get().load(url4).placeholder(R.drawable.ic_launcher_foreground).into(imageView4);
        Picasso.get().load(url5).placeholder(R.drawable.ic_launcher_foreground).into(imageView5);
        Picasso.get().load(url6).placeholder(R.drawable.ic_launcher_foreground).into(imageView6);
        Picasso.get().load(url7).placeholder(R.drawable.ic_launcher_foreground).into(imageView7);
        Picasso.get().load(url8).placeholder(R.drawable.ic_launcher_foreground).into(imageView8);
        Picasso.get().load(url9).placeholder(R.drawable.ic_launcher_foreground).into(imageView9);
        Picasso.get().load(url10).placeholder(R.drawable.ic_launcher_foreground).into(imageView10);

        btnLogOut = findViewById(R.id.btnLogout);
        mAuth = FirebaseAuth.getInstance();
        btnLogOut.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(Dashboard.this, LoginActivity.class));
        });

        mFindRestaurantsButton.setOnClickListener(this);
        mSavedRestaurantsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v == mFindRestaurantsButton) {
            Intent intent = new Intent(Dashboard.this, LocationActivity.class);
            startActivity(intent);
        }
        if (v == mSavedRestaurantsButton) {
            Intent intent = new Intent(Dashboard.this, SavedLocationListActivity.class);
            startActivity(intent);
        }
    }

}