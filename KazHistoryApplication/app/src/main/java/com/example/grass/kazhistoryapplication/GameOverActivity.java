package com.example.grass.kazhistoryapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class GameOverActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        setupMainMenuButton();
        setupQuestionButton();
    }

    public void setupMainMenuButton() {
        Button button1 = (Button) findViewById(R.id.buttonMenu);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(GameOverActivity.this, MainActivity.class);
                startActivity(myIntent);
//                startActivity(new Intent(MainActivity.this,QuestionActivity.class));
            }
        });

    }

    public void setupQuestionButton() {
        Button button1 = (Button) findViewById(R.id.buttonRetry);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(GameOverActivity.this, QuestionActivity.class);
                myIntent.putExtra("current", 1);
                myIntent.putExtra("Live", 3);
                startActivity(myIntent);
//                startActivity(new Intent(MainActivity.this,QuestionActivity.class));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_over, menu);
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
