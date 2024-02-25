package com.example.aplicacion_dani;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Aviones_list extends Fragment {
    ImageView volver;
    NavController navController;

    private List<AvionItem> avionItemList;
    private AvionesAdapter avionesAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);


        volver = view.findViewById(R.id.volver);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.aeropuertos_list);

            }
        });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aviones_list, container, false);

        // Inicializa tu lista de datos (avionItemList)
        avionItemList = new ArrayList<>();
        avionItemList.add(new AvionItem("PRG - JFK"));
        avionItemList.add(new AvionItem("LHR - HKG"));
        avionItemList.add(new AvionItem("FCO - CMN"));
        avionItemList.add(new AvionItem("CMN - LHR"));
        avionItemList.add(new AvionItem("BCN - CDG"));

        // Configura el RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        avionesAdapter = new AvionesAdapter(avionItemList);
        recyclerView.setAdapter(avionesAdapter);

        return view;
    }
}