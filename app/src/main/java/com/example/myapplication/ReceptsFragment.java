package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Scripts.Database.Lesson.DatabaseLessonLoader;
import com.example.myapplication.Scripts.Database.Recept.DatabaseReceptLoader;
import com.example.myapplication.Scripts.Model.Lesson;
import com.example.myapplication.Scripts.Model.Recept;
import com.example.myapplication.Scripts.Recycles.LessonAdapter;
import com.example.myapplication.Scripts.Recycles.ReceptAdapter;

import java.util.ArrayList;

public class ReceptsFragment extends Fragment {
    private RecyclerView receptsView;

    private View view;

    private ArrayList<Recept> recepts;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        recepts = DatabaseReceptLoader.Recepts;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_recepts, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        receptsView= view.findViewById(R.id.ReceptsRecyclerView);
        receptsView.setLayoutManager(new LinearLayoutManager(getContext()));
        ReceptAdapter adapter =  new ReceptAdapter(getContext(), recepts);
        receptsView.setAdapter(adapter);

    }
}