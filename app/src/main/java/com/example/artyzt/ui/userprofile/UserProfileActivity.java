package com.example.artyzt.ui.userprofile;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.artyzt.R;
import com.example.artyzt.databinding.ActivityProfileBinding;

public class UserProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.content_view, new UserProfileFragment());
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
