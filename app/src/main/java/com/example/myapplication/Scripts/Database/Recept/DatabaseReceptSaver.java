package com.example.myapplication.Scripts.Database.Recept;

import com.example.myapplication.Scripts.Database.TableContants;
import com.example.myapplication.Scripts.Exceptions.UserIsNotSaved;
import com.example.myapplication.Scripts.Model.Recept;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseReceptSaver {
    private DatabaseReference database;

    public DatabaseReceptSaver(){
        database = FirebaseDatabase.getInstance().getReference(TableContants.RECEPT_TABLE);
    }

    public void TrySave(Recept recept) throws UserIsNotSaved {
        try {
            database.push().setValue(recept);
        }
        catch (Exception ex) {
            throw new UserIsNotSaved(ex.getMessage());
        }
    }
}
