package com.example.homework3_3.fragment;

import android.annotation.SuppressLint;
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


public class CitiesFragment extends Fragment {

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewContinents);

        String selectedCountry = getArguments() != null ? getArguments().getString("country") : "";

        List<Item> cities = getCitiesForCountry(selectedCountry);

        com.example.homework3_3.ItemAdapter adapter = new com.example.homework3_3.ItemAdapter(requireContext(), cities, item -> {
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<Item> getCitiesForCountry(String country) {
        if ("Казахстан".equals(country)) {
            return Arrays.asList(
                   new Item("Алматы", "https://th.bing.com/th/id/R.55b2e460e738a9f7ba87c0c352273345?rik=2wv7DPefq59VTA&riu=http%3a%2f%2fabout-planet.ru%2fimages%2fasia%2fgoroda%2falmata%2falmata4.jpg&ehk=2i1OnBs3Kx2lWOMBh%2bFgpinUvBP9WMAckjQvqnALNIs%3d&risl=&pid=ImgRaw&r=0"),
                    new Item("Нур-Султан","https://th.bing.com/th/id/OIP.TQlJmwFoIeCHHtsc5Z-0ZQHaEK?w=291&h=181&c=7&r=0&o=5&dpr=2&pid=1.7"),
                    new Item("Шымкент","https://th.bing.com/th/id/OIP.sgJHbdHdNocP_65qT1gJLgHaEo?w=294&h=183&c=7&r=0&o=5&dpr=2&pid=1.7")
            );
        } else if ("Россия".equals(country)) {
            return Arrays.asList(
                   // new Item("Москва","https://th.bing.com/th/id/OIP._RjgpzzyXA4RAUyGQuDLrgHaEK?w=279&h=180&c=7&r=0&o=5&dpr=2&pid=1.7"),
                   // new Item("Санкт-Петербург", "https://th.bing.com/th/id/OIP.ihvDpXvNb4PScpvOP3wCeQHaE0?w=247&h=180&c=7&r=0&o=5&dpr=2&pid=1.7"),
                   // new Item("Казань","https://th.bing.com/th/id/OIP.80IYZk6AF0jKi3euNFKuaQHaE-?w=199&h=180&c=7&r=0&o=5&dpr=2&pid=1.7")
            );
        }
        return Arrays.asList();
    }
}
