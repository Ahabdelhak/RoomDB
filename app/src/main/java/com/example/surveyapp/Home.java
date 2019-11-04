package com.example.surveyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Home extends AppCompatActivity {


    ListView lv ;

    EditText edNAme ;

    UserDAO userDAO;
    String[] usersListarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        edNAme=findViewById(R.id.edName);
        lv = (ListView) findViewById(R.id.lv);

        userDAO = SurveyDatabase.getInstance(this).getUserDAO();

        List<String> users =userDAO.selectUsers();
        //Toast.makeText(this, "Users " + users , Toast.LENGTH_SHORT).show();

        users.remove(0);
        usersListarray = users.toArray(new String[users.size()]);

        String d=Arrays.toString(usersListarray);

        Toast.makeText(this, "Users " + d , Toast.LENGTH_SHORT).show();

        lv.setAdapter(new ArrayAdapter<String>(Home.this, android.R.layout.simple_list_item_1,usersListarray));


    }

    public void Start(View view) {
        String name=edNAme.getText().toString();

        User user = new User();


        user.Name=name;


        if(edNAme.length()!=0){

            long i=userDAO.insert(user);
            System.out.println("test " + i);

            Intent intent = new Intent(Home.this,MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, "Kindly Enter Your Name", Toast.LENGTH_SHORT).show();
        }

    }
}
