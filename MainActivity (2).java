package com.example.sbmpcstudent.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView countLabel;
    private TextView questionLabel;
    private TextView answerBtn1;
    private TextView answerBtn2;
    private TextView answerBtn3;
    private TextView answerBtn4;

    private String rightAnswer;
    private int rightAnswerCount=0;
    private int quizCount=1;

    ArrayList<ArrayList<String>>quizArray=new ArrayList<>();

    String quizData[][]={
            //{"Country","Right Answer","Choice1","Choice2,"Choice3","Choice4"}
            {"China","Beijing","Jakarata","Manila","Stockholm"},
            {"India","New Delhi","Beijing","Bangkok","Seoul"},
            {"Indonesia","Jakarata","Manila","New Delhi","Kuala Lumpur"},
            {"Japan","Tokyo","Bangkok","Taipei","Jakarta"},
            {"Thailand","Bangkok","Berlin","Havana","Kingston"},
            {"Brazil","Brasilia","Havana","Bangkok","Copenhagen"},
            {"Canada","Ottawa","Bern","Copenhagen","Jakarata"},
            {"Cuba","Havana","Bern","London","Mexico City"},
            {"Mexico","Mexico City","Ottawa","Berlin","Santiago"},
            {"United States","Washington D.C.","San Jose","Buenos Aires","Kuala Lumpur"},
            {"France","Paris","Ottawa","Copenhagen","Tokyo"},
            {"Germany","Berlin","Copenhagen","Bangkok","Santiago"},
            {"Italy","Rome","London","Paris","Athens"},
            {"Spain","Madrid","Mexico City","Jakarta","Havana"},
            {"United Kingdom","London","Rome","Paris","Singapore"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countLabel=(TextView)findViewById(R.id.countLabel);
        questionLabel=(TextView)findViewById(R.id.questionLabel);
        answerBtn1=(TextView)findViewById(R.id.answerBtn1);
        answerBtn2=(TextView)findViewById(R.id.answerBtn2);
        answerBtn3=(TextView)findViewById(R.id.answerBtn3);
        answerBtn4=(TextView)findViewById(R.id.answerBtn4);

        //Create quizArray from quizData
        for(int i=0;i<quizData.length;i++) {
            //prepare array
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]);//Country
            tmpArray.add(quizData[i][1]);//Right Answer
            tmpArray.add(quizData[i][2]);//Choice1
            tmpArray.add(quizData[i][3]);//Choice2
            tmpArray.add(quizData[i][4]);//Choice3

            //Add tmpArray to quizArray.
            quizArray.add(tmpArray);
        }
        showNextQuiz();
        }
        public void showNextQuiz(){
            //Update quizCountLabel.
            countLabel.setText("Q"+quizCount);
            //Generate random number between 0 to 14(quizArray's size - 1).
            Random random=new Random();
            int randomNum=random.nextInt(quizArray.size());
            //Pick one quiz set
            ArrayList<String> quiz=quizArray.get(randomNum);
            //Set question and right answer.
            //array format:{"Country","Right Answer","Choice1","Choice2,"Choice3","Choice4"}
            questionLabel.setText(quiz.get(0));
            rightAnswer=quiz.get(1);
            //Remove "Country" from quiz and Shuffle choices

    }
}
