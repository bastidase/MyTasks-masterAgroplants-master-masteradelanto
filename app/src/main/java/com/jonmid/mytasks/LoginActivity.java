package com.jonmid.mytasks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jonmid.mytasks.Data.DataUser;
import com.jonmid.mytasks.Models.User;
import com.jonmid.mytasks.Views.ContainerActivity;
import com.jonmid.mytasks.Views.CreateAccountActivity;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    DataUser datauser;
    Button login;
    EditText username,passwordLogin;
    User userLogin;
    List<User> userList;
    String[] findUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.login);
        username = (EditText) findViewById(R.id.username);
        passwordLogin = (EditText) findViewById(R.id.password);
        datauser = new DataUser(this);
        datauser.open();

        userLogin = datauser.checkStatusLogin();

        if(userLogin == null ){

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(username.getText().toString().equals("")||passwordLogin.getText().toString().equals(""))
                    {
                        Toast.makeText(getApplicationContext(), getString(R.string.txt_field_vaccant), Toast.LENGTH_SHORT).show();
                    }
                    else {
                        findUser = new String[2];
                        findUser = datauser.findUser(username.getText().toString(),passwordLogin.getText().toString());
                        if (findUser[0].equals((username.getText().toString())) && findUser[1].equals((passwordLogin.getText().toString())) ){
                            datauser.statusOn(username.getText().toString(),passwordLogin.getText().toString());
                            Toast.makeText(getApplicationContext(), getString(R.string.txt_validation_login), Toast.LENGTH_SHORT).show();
                            goCreateContainer();
                        }else
                        {Toast.makeText(getApplicationContext(), getString(R.string.txt_no_validation_login) , Toast.LENGTH_SHORT).show();}

                    }
                }
            });

        }else {
            goCreateContainer();
        }

    }

    private void goCreateContainer() {
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }

    public void goCreateAccount(View view){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }



}
