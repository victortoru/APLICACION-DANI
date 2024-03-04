package com.example.aplicacion_dani;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoticiasFragment extends Fragment {

    private List<Noticias_list> noticiasList;
    private NoticiaAdapter noticiaAdapter;
    private RecyclerView recyclerViewNoticias;
    private NavController navController;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noticias, container, false);

        noticiasList = new ArrayList<>();
        noticiasList.add(new Noticias_list("carlos", "klkmanit", R.drawable.americanavion));
        noticiasList.add(new Noticias_list("carlos", "klkmanit", R.drawable.americanavion));
        noticiasList.add(new Noticias_list("carlos", "klkmanit", R.drawable.americanavion));
        noticiasList.add(new Noticias_list("carlos", "klkmanit", R.drawable.americanavion));


        recyclerViewNoticias = view.findViewById(R.id.recyclerViewListAeropuertos);
        noticiaAdapter = new NoticiaAdapter(noticiasList, navController);
        recyclerViewNoticias.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewNoticias.setAdapter(noticiaAdapter);

        return view;
    }
}
