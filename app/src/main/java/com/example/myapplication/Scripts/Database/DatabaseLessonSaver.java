package com.example.myapplication.Scripts.Database;

import com.example.myapplication.Scripts.Exceptions.UserIsNotSaved;
import com.example.myapplication.Scripts.Model.Lesson;
import com.example.myapplication.Scripts.Model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseLessonSaver {
    private DatabaseReference database;

    public DatabaseLessonSaver(){
        database = FirebaseDatabase.getInstance().getReference(TableContants.LESSON_TABLE);
    }

    public void TrySave(Lesson lesson) throws UserIsNotSaved {
        try {
            database.push().setValue(lesson);
        }
        catch (Exception ex) {
            throw new UserIsNotSaved(ex.getMessage());
        }
    }
}
