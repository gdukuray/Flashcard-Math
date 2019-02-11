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
    private TextView txtFooterMessage;
    private TextView trackans;
    String equ;
    int ans = 0;


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
        trackans = (TextView) findViewById(R.id.trackans);
        nextProblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//if next problem is clicked
                //check answer first
                ans = findAns(equ);//function return int answer from a String equation
                //trackans.setText(ans);//!!!problem here!!!

                //After checking display the next problem
                equ = genEqt();
                txtFormula.setText(equ);//generate a new problem
            }
        });


    }

    //return int answer from a String equation
    // 1 + 2 * 3 = 7
    public static int findAns(String eq)
    {
        int result = 0;
        int firstNum = 0;
        int secNum = 0;
        int thirdNum = 0;

        firstNum = Character.getNumericValue(eq.charAt(1));
        secNum = Character.getNumericValue(eq.charAt(3));
        thirdNum = Character.getNumericValue(eq.charAt(5));

        if(eq.charAt(2) == '+')//if first operation add or minus, check the second operation
        {
            if(eq.charAt(4) == '+' )
            {
                result = firstNum + secNum + thirdNum;
            }
            else if(eq.charAt(4) == '-' )
            {
                result = firstNum + secNum - thirdNum;
            }
            else if(eq.charAt(4) == '*' )
            {
                result = firstNum + secNum * thirdNum;
            }
        }
        else if (eq.charAt(2) == '-')
        {
            if(eq.charAt(4) == '+' )
            {
                result = firstNum - secNum + thirdNum;
            }
            else if(eq.charAt(4) == '-' )
            {
                result = firstNum - secNum - thirdNum;
            }
            else if(eq.charAt(4) == '*' )
            {
                result = firstNum - secNum * thirdNum;
            }
        }
        else if (eq.charAt(2) == '*')
        {
            if(eq.charAt(4) == '+' )
            {
                result = firstNum * secNum + thirdNum;
            }
            else if(eq.charAt(4) == '-' )
            {
                result = firstNum * secNum - thirdNum;
            }
            else if(eq.charAt(4) == '*' )
            {
                result = firstNum * secNum * thirdNum;
            }
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
            }//add, minus, mult, divide
            if(i == 5)
            {
                result+="=";
            }
        }
        return result;
    }
}


