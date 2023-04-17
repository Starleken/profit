package com.example.myapplication.Scripts.Database;

import android.content.Intent;
import android.os.Debug;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.Scripts.Exceptions.FieldIsEmptyException;
import com.example.myapplication.Scripts.Exceptions.UserIsNotFound;
import com.example.myapplication.Scripts.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUserLoader {
    private DatabaseReference database;

    public ArrayList<User> users;

    public DatabaseUserLoader() {
        database = FirebaseDatabase.getInstance().getReference(TableContants.USER_TABLE);
        users = new ArrayList<>();
    }

    public void initUsers() {
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (users.size() > 0) {
                    users.clear();
                }
                for (DataSnapshot ds : snapshot.getChildren()) {
                    users.add(ds.getValue(User.class));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("gfdgdf","Ошибка чтения");
            }
        });
    }

    //TODO Изменить отправляемую ошибку и поиск юзера
    public User findUserByLogin(String login) throws UserIsNotFound {
        for(User user : users) {
            if (user.login.equals(login)) {
                return user;
            }
        }

        throw new UserIsNotFound("Пользователь не найден");
    }

}
