package com.example.artyzt.ui.userprofile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artyzt.R;
import com.example.artyzt.databinding.FragmentNotificationsBinding;

public class UserProfileFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final RecyclerView profileList = root.findViewById(R.id.userprofile_list);
        profileList.setAdapter(new UserProfileAdapter());
        profileList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return root;
    }
}
