package com.example.artyzt.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artyzt.Data;
import com.example.artyzt.databinding.FragmentDashboardBinding;
import com.example.artyzt.ui.userprofile.UserProfileActivity;

import org.json.JSONArray;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        JSONArray array = (new Data()).retrieveFavorites(getActivity());
        final RecyclerView artistList = binding.dashboardList;
        artistList.setAdapter(new DashboardAdapter(getActivity(), array));
        artistList.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}