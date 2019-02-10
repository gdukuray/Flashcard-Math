package com.example.flashcardmath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvMsg;
    private TextView txtFormula;
    private Button nextProblem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMsg = (TextView) findViewById(R.id.txtFooterMessage);
        String secretMsg;


        Bundle bundle = getIntent().getExtras();
        secretMsg = bundle.getString("secretVal");  //TRUE OR FALSE: The parameter in quotes, is the key to the Bundle/Hashmap?
        secretMsg = "Secret Message From Activity 1: " + secretMsg;

        tvMsg.setText(secretMsg);  //QUESTION: Is this the Key or Value?
        Toast.makeText(MainActivity.this, "The Login activity sent me a Secret Value = " + secretMsg , Toast.LENGTH_LONG).show();


       // Random rnd = new Random();
        //int[] intArray = rnd.ints(30, 0, 9).toArray();

        txtFormula = (TextView) findViewById(R.id.txtFormula);
        String equ = genEqt();
        txtFormula.setText(equ);

        nextProblem = (Button) findViewById(R.id.nextProblem);
        nextProblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               txtFormula.setText(genEqt());
            }
        });


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
            }//add, minus, mult, divide
            if(i == 5)
            {
                result+="=";
            }
        }
        return result;
    }
}


