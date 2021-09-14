package com.example.tracee2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.tracee2.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.*;
import butterknife.ButterKnife;

public class Dashboard extends AppCompatActivity {

    Button btnLogOut;
    Button mbottomNavigationView;
    FirebaseAuth mAuth;
    @BindView(com.example.tracee2.R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @BindView(com.example.tracee2.R.id.locationEditText) EditText mLocationEditText;


    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.tracee2.R.layout.activity_dashboard);
        ButterKnife.bind(this);


        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String location = mLocationEditText.getText().toString();
                Intent intent = new Intent(Dashboard.this, LocationActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
                Toast.makeText(Dashboard.this, location, Toast.LENGTH_LONG).show();

            }
        });


//        Making the recyclerview

//        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        MyMovieData[] myMovieData = new MyMovieData[]{
//                new MyMovieData("Camping","Go camping with friends!",R.drawable.camping),
//                new MyMovieData("Hiking","Look for places to hike",R.drawable.hiking),
//                new MyMovieData("Travel","Travel with your family!",R.drawable.travel),
//                new MyMovieData("Trail Walks","Look for best places for Trails",R.drawable.trail),
//                new MyMovieData("Wild Tour","Visit animals parks",R.drawable.wildtour),
//                new MyMovieData("Cycling Segments","2003 film",R.drawable.cycling),
//                new MyMovieData("Swimming","Have fun with your friends and family",R.drawable.swimming),
//        };
//
//        MyMovieAdapter myMovieAdapter = new MyMovieAdapter(myMovieData,Dashboard.this);
//        recyclerView.setAdapter(myMovieAdapter);

//        Logout user

        btnLogOut = findViewById(R.id.btnLogout);
        mAuth = FirebaseAuth.getInstance();
        btnLogOut.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(Dashboard.this, LoginActivity.class));
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(Dashboard.this, LoginActivity.class));
        }
    }
}