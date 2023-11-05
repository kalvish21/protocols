package com.example.artyzt.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.artyzt.Data;
import com.example.artyzt.databinding.FragmentNotificationsBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel =
                new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Data dataProcessor = new Data();
        JSONObject profileData = dataProcessor.retrieveProfile(getContext());

        EditText name = binding.profileName;
        EditText talent = binding.profileTalent;
        EditText location = binding.profileLocation;
        EditText experience = binding.profileExp;
        EditText background = binding.profileBackground;

        try {
            String fullName = String.format("%s %s", profileData.getString("firstName"), profileData.getString("lastName"));
            name.setText(fullName);
            talent.setText(profileData.getString("talent"));
            location.setText(profileData.getString("location"));
            experience.setText(profileData.getString("experience"));
            background.setText(profileData.getString("biography"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}