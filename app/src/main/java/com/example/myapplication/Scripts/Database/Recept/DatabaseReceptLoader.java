package com.example.myapplication.Scripts.Database.Recept;

import androidx.annotation.NonNull;

import com.example.myapplication.Scripts.Database.TableContants;
import com.example.myapplication.Scripts.Model.Recept;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DatabaseReceptLoader {
    private DatabaseReference database;

    public static ArrayList<Recept> Recepts;

    public DatabaseReceptLoader(){
        database = FirebaseDatabase.getInstance().getReference(TableContants.RECEPT_TABLE);
        Recepts = new ArrayList<>();
    }

    public void initRecepts(){
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (Recepts.size() > 0) {
                    Recepts.clear();
                }
                for (DataSnapshot ds : snapshot.getChildren()) {
                    Recepts.add(ds.getValue(Recept.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
