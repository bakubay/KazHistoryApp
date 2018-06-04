package com.example.grass.kazhistoryapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class WrongAnswerActivity extends ActionBarActivity {
    int intValue;
    int intLive;
    String ans[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent mIntent = getIntent();
        intValue = mIntent.getIntExtra("current", 0);
        intLive = mIntent.getIntExtra("Live", 0);
        setContentView(R.layout.activity_wrong_answer);
        readAnsFileText();
        setupReturnButton();
    }

    public void setupReturnButton() {
        Button buttonReturn = (Button) findViewById(R.id.buttonNext2);
        buttonReturn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                intValue++;
                intLive--;
                Intent myIntent = new Intent(WrongAnswerActivity.this, QuestionActivity.class);
                myIntent.putExtra("current", intValue);
                myIntent.putExtra("Live", intLive
                );
                startActivity(myIntent);
                //startActivity(new Intent(CorrectAnswerActivity.this,QuestionActivity.class));
            }
        });

    }


    public void readAnsFileText() {
        ans = new String[1001];
        try {
            InputStream is = getAssets().open("ans_lvl1.txt");

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;

            int k=0;
            line = reader.readLine();
            while (line != null) {
                k++;
                ans[k] = line;
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TextView tv = (TextView)findViewById(R.id.textView);
        tv.setText(ans[intValue].toString());

//        tv.setText(txt[1].toString());

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_wrong_answer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
