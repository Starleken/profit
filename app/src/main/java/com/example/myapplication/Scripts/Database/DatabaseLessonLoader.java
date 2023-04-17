package com.example.myapplication.Scripts.Database;

import androidx.annotation.NonNull;

import com.example.myapplication.Scripts.Model.Lesson;
import com.example.myapplication.Scripts.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DatabaseLessonLoader {
    private DatabaseReference database;

    public ArrayList<Lesson> Lessons;

    public DatabaseLessonLoader(){
        database = FirebaseDatabase.getInstance().getReference(TableContants.LESSON_TABLE);
        Lessons = new ArrayList<>();
    }

    public void initLessons(){
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (Lessons.size() > 0) {
                    Lessons.clear();
                }
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Lessons.add(ds.getValue(Lesson.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
