package com.example.artyzt.ui.userprofile;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artyzt.R;
import com.example.artyzt.databinding.ActivityProfileBinding;

import java.util.ArrayList;

public class UserProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final TextView artistName = findViewById(R.id.artist_name);
        final TextView artistExp = findViewById(R.id.artist_exp);
        final TextView artistTalent = findViewById(R.id.artist_talent);
        final TextView artistLoc = findViewById(R.id.artist_location);

        artistName.setText(getIntent().getStringExtra("fullName"));
        artistExp.setText(getIntent().getStringExtra("experience"));
        artistTalent.setText(getIntent().getStringExtra("talent"));
        artistLoc.setText(getIntent().getStringExtra("location"));

        final ArrayList<String> dataList = new ArrayList<>();
        dataList.add(getIntent().getStringExtra("biography"));
        dataList.add(getIntent().getStringExtra("contactInfo"));
        dataList.add("Links");
        dataList.add("Media");

        final RecyclerView recyclerView = findViewById(R.id.userprofile_list);
        recyclerView.setAdapter(new UserProfileAdapter(dataList));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
