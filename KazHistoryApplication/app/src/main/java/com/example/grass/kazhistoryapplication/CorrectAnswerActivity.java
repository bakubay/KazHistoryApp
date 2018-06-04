package com.example.grass.kazhistoryapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class CorrectAnswerActivity extends ActionBarActivity {
    int intValue;
    int intLive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent mIntent = getIntent();
        intValue = mIntent.getIntExtra("current", 0);
        intLive = mIntent.getIntExtra("Live", 0);
        setContentView(R.layout.activity_correct_answer);
        setupReturnButton();
    }


    public void setupReturnButton() {
        Button buttonReturn = (Button) findViewById(R.id.buttonNext);
        buttonReturn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                intValue++;
                Intent myIntent = new Intent(CorrectAnswerActivity.this, QuestionActivity.class);
                myIntent.putExtra("current", intValue);
                myIntent.putExtra("Live", intLive);
                startActivity(myIntent);
                //startActivity(new Intent(CorrectAnswerActivity.this,QuestionActivity.class));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_correct_answer, menu);
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
