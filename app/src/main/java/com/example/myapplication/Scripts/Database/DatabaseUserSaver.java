package com.example.myapplication.Scripts.Database;

import com.example.myapplication.Scripts.Exceptions.UserIsNotSaved;
import com.example.myapplication.Scripts.Model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseUserSaver {
    private DatabaseReference database;

    public DatabaseUserSaver() {
        database = FirebaseDatabase.getInstance().getReference(TableContants.USER_TABLE);
    }

    public void TrySave(User user) throws UserIsNotSaved {
        try {
            database.push().setValue(user);
        }
        catch (Exception ex) {
            throw new UserIsNotSaved(ex.getMessage());
        }
    }
}
