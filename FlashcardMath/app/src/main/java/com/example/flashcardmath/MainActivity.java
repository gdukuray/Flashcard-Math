package com.example.flashcardmath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvMsg;
    private TextView txtFormula;
    private Button nextProblem;
    private TextView txtFooterMessage;
    private TextView txtUserAnswer;
    String equ;
    int ans = 0;
    int userans = 0;
    int score = 0;
    int questionNum = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMsg = (TextView) findViewById(R.id.txtFooterMessage);
        String secretMsg;


        Bundle bundle = getIntent().getExtras();
        secretMsg = bundle.getString("secretVal");  //TRUE OR FALSE: The parameter in quotes, is the key to the Bundle/Hashmap?
        secretMsg = "Welcome " + secretMsg;

        tvMsg.setText(secretMsg);  //QUESTION: Is this the Key or Value?
        Toast.makeText(MainActivity.this, secretMsg , Toast.LENGTH_LONG).show();


       // Random rnd = new Random();
        //int[] intArray = rnd.ints(30, 0, 9).toArray();

        txtFormula = (TextView) findViewById(R.id.txtFormula);
        equ = genEqt();
        txtFormula.setText(equ);

        nextProblem = (Button) findViewById(R.id.nextProblem);
        txtUserAnswer = (TextView) findViewById(R.id.txtUserAnswer);
        nextProblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//if next problem is clicked
                //check answer first
                ans = findAns(equ);//function return int answer from a String equation
                userans = Integer.parseInt(txtUserAnswer.getText().toString());
                if(ans == userans)
                {
                    score++;
                    tvMsg.setText("Your score is " + score+". "+ questionNum+"/10");

                }
                else
                {
                    tvMsg.setText("Wrong answer, the answer is " + ans + ". Your score is " + score +". "+ questionNum+"/10");
                }
                if(questionNum<10) {
                    //After checking display the next problem
                    equ = genEqt();
                    txtFormula.setText(equ);//generate a new problem
                    questionNum++;
                }
                else {
                    tvMsg.setText("Game over. Your score is " + score+". Press button to start a new game.");
                    questionNum = 1;
                }
            }
        });


    }

    //return int answer from a String equation
    // 1 + 2 * 3 = 7
    public static int findAns(String eq)
    {
        int result = 0;
        int firstNum;
        int secNum;
        int thirdNum;

        firstNum = Character.getNumericValue(eq.charAt(0));
        secNum = Character.getNumericValue(eq.charAt(2));
        thirdNum = Character.getNumericValue(eq.charAt(4));


        if(eq.charAt(1) == '+')//if first operation add or minus, check the second operation
        {
            if(eq.charAt(3) == '+' )
            { result = firstNum + secNum + thirdNum; }
            else if(eq.charAt(3) == '-' )
            { result = firstNum + secNum - thirdNum; }
            else if(eq.charAt(3) == '*' )
            { result = firstNum + secNum * thirdNum; }
        }
        else if (eq.charAt(1) == '-')
        {
            if(eq.charAt(3) == '+' )
            { result = firstNum - secNum + thirdNum; }
            else if(eq.charAt(3) == '-' )
            { result = firstNum - secNum - thirdNum; }
            else if(eq.charAt(3) == '*' )
            { result = firstNum - secNum * thirdNum; }
        }
        else if (eq.charAt(1) == '*')
        {
            if(eq.charAt(3) == '+' )
            { result = firstNum * secNum + thirdNum; }
            else if(eq.charAt(3) == '-' )
            { result = firstNum * secNum - thirdNum; }
            else if(eq.charAt(3) == '*' )
            { result = firstNum * secNum * thirdNum; }
        }


        return result;
    }


    //generate equations
    public static String genEqt()
    {
        int s = 0;
        String[] symbol = {"+","-","*"};
        String result ="";
        for(int i = 0; i<6; i++)
        {
            if(i%2 == 0)
            {
                result += Integer.toString((int)(Math.random()*10));
            }//number
            if(i%2 == 1 && i!=5)
            {
                s = (int)(Math.random()*3);
                result += symbol[s];
            }//add, minus, multiply, divide
            if(i == 5)
            { result+="="; }
        }
        return result;
    }
}


