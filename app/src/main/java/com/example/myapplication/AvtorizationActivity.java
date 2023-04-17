package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Scripts.Database.DatabaseUserLoader;
import com.example.myapplication.Scripts.Exceptions.FieldIsEmptyException;
import com.example.myapplication.Scripts.Exceptions.UserIsNotFound;
import com.example.myapplication.Scripts.Model.User;

import java.util.logging.ConsoleHandler;

public class AvtorizationActivity extends AppCompatActivity {

    private Button enterButton;
    private Button loginButton;

    private EditText password;
    private EditText login;

    private DatabaseUserLoader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avtorization);

        findViews();
        setListeners();

        loader = new DatabaseUserLoader();
        loader.initUsers();
    }

    private void findViews(){
        enterButton = findViewById(R.id.avtButtonEnter);
        loginButton = findViewById(R.id.avtButtonLogin);
        password = findViewById(R.id.avtEditTextTextPassword);
        login = findViewById(R.id.avtEditTextTextPersonName);
    }

    private void setListeners(){
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Avtorizate();
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegistration();
            }
        });
    }

    private void goToRegistration() {
        startActivity(new Intent(this, MainActivity.class));
    }

    private void Avtorizate(){
        try {
            tryCheckFieldsAtNull();

            tryFindUser();

            goToMainMenu();
        }
        catch (FieldIsEmptyException ex){
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        catch (UserIsNotFound ex){
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void goToMainMenu() {
        startActivity(new Intent(this, MenuActivity.class));
    }

    private User tryFindUser() throws UserIsNotFound {
        for(User user : loader.users){
            if(user.login.equals(login.getText().toString()) && user.password.equals(password.getText().toString())){
                return user;
            }
        }

        throw new UserIsNotFound("Пользователь не найден");
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
