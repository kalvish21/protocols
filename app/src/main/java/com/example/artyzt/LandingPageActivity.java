package com.example.artyzt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.artyzt.databinding.ActivityLandingBinding;

public class LandingPageActivity extends AppCompatActivity {

    private ActivityLandingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        binding = ActivityLandingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button home = binding.buttonHome;
        Button favorites = binding.buttonFavorites;
        Button profile = binding.buttonProfile;

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LandingPageActivity.this, MainActivity.class);
                intent.putExtra("tabId", R.id.navigation_home);
                LandingPageActivity.this.startActivity(intent);
            }
        });

        favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LandingPageActivity.this, MainActivity.class);
                intent.putExtra("tabId", R.id.navigation_dashboard);
                LandingPageActivity.this.startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LandingPageActivity.this, MainActivity.class);
                intent.putExtra("tabId", R.id.navigation_notifications);
                LandingPageActivity.this.startActivity(intent);
            }
        });
    }
}