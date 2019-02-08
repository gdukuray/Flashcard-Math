package com.example.flashcardmath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Random;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvMsg;

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


    }
}
