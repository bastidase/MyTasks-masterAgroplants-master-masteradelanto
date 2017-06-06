package com.jonmid.mytasks.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.jonmid.mytasks.Adapters.AdapterUser;
import com.jonmid.mytasks.Data.DataUser;
import com.jonmid.mytasks.LoginActivity;
import com.jonmid.mytasks.Models.User;
import com.jonmid.mytasks.R;

import java.util.List;

public class CreateAccountActivity extends AppCompatActivity {

    Button id_btn_joinUs;
    EditText id_tie_name,id_tie_user,email,password, confirmPassword;
    DataUser dataUser;
    ListView lista;
    List<User> listarusers;

    AdapterUser adapterUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        showToolbar(getResources().getString(R.string.str_btn_createaccount), true);

        id_btn_joinUs = (Button) findViewById(R.id.id_btn_joinUs);
        id_tie_name = (EditText) findViewById(R.id.id_tie_name);
        id_tie_user = (EditText) findViewById(R.id.id_tie_user);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.id_tier_password);
        confirmPassword = (EditText) findViewById(R.id.confirm_Password);



        dataUser = new DataUser(this);
        dataUser.open();

        id_btn_joinUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(id_tie_user.getText().toString().equals("")||password.getText().toString().equals("")
                        ||confirmPassword.getText().toString().equals("")
                        ||id_tie_name.getText().toString().equals("")||email.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), getString(R.string.txt_field_vaccant), Toast.LENGTH_SHORT).show();
                }
                // check if both password matches
                else if(!password.getText().toString().equals(confirmPassword.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), getString(R.string.txt_password_validation), Toast.LENGTH_SHORT).show();

                }
                else
                {
                    createData();
                    Toast.makeText(getApplicationContext(),getString(R.string.txt_succesfully_account), Toast.LENGTH_SHORT).show();
                    listarusers = dataUser.findAll();
                    adapterUser = new AdapterUser(getApplicationContext(), listarusers);
                    lista.setAdapter(adapterUser);
                    //goLogginActivity();
                }
            }
        });

    }

    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_tb_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    private void createData(){
        User user = new User();
        user.setName(id_tie_name.getText().toString());
        user.setEmail(email.getText().toString());
        user.setUsername(id_tie_user.getText().toString());
        user.setPassword(password.getText().toString());
        user.setStatus("false");

        dataUser.create(user);
    }


    public void goLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
