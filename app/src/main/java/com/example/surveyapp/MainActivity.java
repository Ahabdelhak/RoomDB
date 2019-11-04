package com.example.surveyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    QuestionDAO questionDAO;
    RadioGroup rg ;
    RadioButton rbyes , rbNo ;
    TextView tv ;

    Button btn ;

    String[] questions = {"Do you speak english ?" , "Do you speak French ?" , "Do you speak Italy ?" , "Do you speak Arabic ?"};
    String[] QuestDBarray;


    byte index , yes , No;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= findViewById(R.id.textView);
        rbyes =findViewById(R.id.radioyes);
        rbNo =findViewById(R.id.radioNo);
        btn=findViewById(R.id.button);

        rg=findViewById(R.id.radioGroup);


        questionDAO = SurveyDatabase.getInstance(this).getQuestionDAO();
        List<String> quest =questionDAO.selectGenres();


        //System.out.println(" Questions "+Arrays.toString(quest.toArray()));

        QuestDBarray = quest.toArray(new String[quest.size()]);
        System.out.println(" Questions "+Arrays.toString(QuestDBarray));



        tv.setText(QuestDBarray[0]);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = rg.getCheckedRadioButtonId();
                View rb = rg.findViewById(id);

                if(rb.getId()==R.id.radioyes){
                    yes++;
                    System.out.println("test");
                }else{
                    No++;
                }
            }
        });





    }


    public void Next(View view) {

        index++;
        if (index<QuestDBarray.length) {
            tv.setText(QuestDBarray[index]);
            rbyes.setChecked(false);
            rbNo.setChecked(false);
        }else{
            Toast.makeText(this, "you ans yes " + yes + " times and, " + " " + "No "+ No + " Times", Toast.LENGTH_SHORT).show();


            Intent intent = new Intent(MainActivity.this,Home.class);
            startActivity(intent);
        }

    }
}
