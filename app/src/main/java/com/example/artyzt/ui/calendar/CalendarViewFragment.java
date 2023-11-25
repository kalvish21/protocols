package com.example.artyzt.ui.calendar;

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
import com.example.artyzt.databinding.FragmentCalendarBinding;
import com.example.artyzt.ui.home.ArtistHomeAdapter;
import com.example.artyzt.ui.home.HomeViewModel;

public class CalendarViewFragment extends Fragment {

    private FragmentCalendarBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentCalendarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final RecyclerView artistList = binding.eventList;
        artistList.setAdapter(new CalendarAdapter(getActivity(), (new Data()).retrieveEvents(getActivity())));
        artistList.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
