package com.example.homework3_3.fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homework3_3.Item;
import com.example.homework3_3.R;

import java.util.Arrays;
import java.util.List;

public class ContinentsFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_continent, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewContinents);

        List<Item> continents = Arrays.asList(
                new Item("Евразия", ""),
                new Item("Африка", ""),
                new Item("Америка", ""),
                new Item("Австралия", ""),
                new Item("Антарктида", "")
        );

        com.example.homework3_3.ItemAdapter adapter = new com.example.homework3_3.ItemAdapter(requireContext(), continents, item -> {
            CountriesFragment countriesFragment = new CountriesFragment();

            Bundle args = new Bundle();
            args.putString("continent", item.getText());
            countriesFragment.setArguments(args);

            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, countriesFragment)
                    .addToBackStack(null)
                    .commit();
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}