package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.Scripts.Database.Lesson.DatabaseLessonLoader;
import com.example.myapplication.Scripts.Model.Lesson;
import com.example.myapplication.Scripts.Recycles.LessonAdapter;

import java.util.ArrayList;

public class LessonsFragment extends Fragment {
    private RecyclerView lessonsView;

    private View view;

    private ArrayList<Lesson> lessons;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        lessons = DatabaseLessonLoader.Lessons;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_lessons, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LessonAdapter.OnLessonClickListener lessonClickListener = new LessonAdapter.OnLessonClickListener() {
            @Override
            public void onStateClick(Lesson lesson, int position) {

                Intent intent = new Intent(getActivity(), LessonActivity.class);
                intent.putExtra("Lesson", lesson);
                startActivity(intent);
            }
        };

        lessonsView= view.findViewById(R.id.LessonsRecyclerView);
        lessonsView.setLayoutManager(new LinearLayoutManager(getContext()));
        LessonAdapter adapter =  new LessonAdapter(getContext(), lessons, lessonClickListener);
        lessonsView.setAdapter(adapter);

    }
}