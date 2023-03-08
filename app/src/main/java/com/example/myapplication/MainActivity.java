package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Scripts.Database.DatabaseUserLoader;
import com.example.myapplication.Scripts.Database.DatabaseUserSaver;
import com.example.myapplication.Scripts.Exceptions.FieldIsEmptyException;
import com.example.myapplication.Scripts.Exceptions.UserIsNotFound;
import com.example.myapplication.Scripts.Exceptions.UserIsNotSaved;
import com.example.myapplication.Scripts.Model.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button enterButton;
    private Button loginButton;

    private EditText password;
    private EditText login;

    private DatabaseUserLoader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListeners();

        loader = new DatabaseUserLoader();

        loader.getUsers();
    }

    private void findViews() {
        enterButton = findViewById(R.id.buttonEnter);
        loginButton = findViewById(R.id.buttonLogin);

        password = findViewById(R.id.editTextTextPassword);
        login = findViewById(R.id.editTextTextPersonName);
    }

    private void setListeners() {
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterUser();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAvtorization();
            }
        });
    }

    private void goToAvtorization() {
        startActivity(new Intent(this, AvtorizationActivity.class));
    }

    private void RegisterUser() {
        try {
            tryCheckFieldsAtNull();

            //DatabaseUserSaver userSaver = new DatabaseUserSaver();



            for(User user : loader.users){
                Log.w("gfdgd", "gfdgdfg");
            }

            //User user = new User("User", login.getText().toString(), password.getText().toString());

            //userSaver.TrySave(user);
        }
        catch (FieldIsEmptyException ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
            return;
        }
        /*catch (UserIsNotSaved ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage(), Toast.LENGTH_LONG).show();
            return;
        }
         */
        /*catch (UserIsNotFound ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
            return;
        }
         */
    }

    private void goToMainMenu() {
        startActivity(new Intent(this, MenuActivity.class));
    }

    private void tryCheckFieldsAtNull() throws FieldIsEmptyException {
        if (TextUtils.isEmpty(password.getText())) {
            throw new FieldIsEmptyException("Заполните пароль");
        }
        else if(TextUtils.isEmpty(login.getText())) {
            throw new FieldIsEmptyException("Заполните логин");
        }
    }
}