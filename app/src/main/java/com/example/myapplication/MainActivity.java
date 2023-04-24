package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Scripts.Database.User.DatabaseUserSaver;
import com.example.myapplication.Scripts.Exceptions.FieldIsEmptyException;
import com.example.myapplication.Scripts.Exceptions.UserIsNotSaved;
import com.example.myapplication.Scripts.Model.User;

public class MainActivity extends AppCompatActivity {

    private Button enterButton;
    private Button loginButton;

    private EditText password;
    private EditText login;

    private DatabaseUserSaver saver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListeners();

        saver = new DatabaseUserSaver();

    }

    private void findViews() {
        enterButton = findViewById(R.id.avtButtonEnter);
        loginButton = findViewById(R.id.avtButtonLogin);

        password = findViewById(R.id.avtEditTextTextPassword);
        login = findViewById(R.id.avtEditTextTextPersonName);
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

            User user = new User("User", login.getText().toString(), password.getText().toString());

            saver.TrySave(user);
        }
        catch (FieldIsEmptyException ex){
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        catch(UserIsNotSaved ex){
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }


        goToAvtorization();
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