package com.example.grass.kazhistoryapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class QuestionActivity extends ActionBarActivity {
    String txt[];
    String a[];
    String ans[];
    int cur=1;
    int live=3;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent mIntent = getIntent();
        cur = mIntent.getIntExtra("current", 0);
        live = mIntent.getIntExtra("Live", 0);
        if(live == 0) {
            startActivity(new Intent(QuestionActivity.this,GameOverActivity.class));
        }
        if(cur == 11) {
            startActivity(new Intent(QuestionActivity.this,SuccessActivity.class));
        }
        if (cur < 1 || cur > 10) cur = 1;
        if (live < 1 || live > 3) live=3;
        setContentView(R.layout.activity_question);
        setLives();
        readFileText();
        //readAnsFileText();
        readAFileText();
        setupYesButtonPress();
        setupNoButtonPress();
        tv = (TextView)findViewById(R.id.textView);
        tv.setText(txt[cur].toString());
    }



    public void setLives() {
        if(live == 1) {
            ImageView view3 = (ImageView) findViewById(R.id.heartView3);
            view3.setImageResource(R.drawable.heart);
        } else
        if(live == 2) {
            ImageView view3 = (ImageView) findViewById(R.id.heartView3);
            view3.setImageResource(R.drawable.heart);

            ImageView view2 = (ImageView) findViewById(R.id.heartView2);
            view2.setImageResource(R.drawable.heart);
        } else
        if(live == 3) {
            ImageView view1 = (ImageView) findViewById(R.id.heartView1);
            view1.setImageResource(R.drawable.heart);

            ImageView view2 = (ImageView) findViewById(R.id.heartView2);
            view2.setImageResource(R.drawable.heart);

            ImageView view3 = (ImageView) findViewById(R.id.heartView3);
            view3.setImageResource(R.drawable.heart);
        }
    }

    public void readAFileText() {
        a = new String[1001];
        try {
            InputStream is = getAssets().open("a_lvl1.txt");

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;

            int k=0;
            line = reader.readLine();
            while (line != null) {
                k++;
                a[k] = line;
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //tv.setText(txt[1].toString());

    }



    public void setupYesButtonPress() {
        Button buttonYes = (Button) findViewById(R.id.yesButton);
        buttonYes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(a[cur].compareTo("yes") == 0) {
                    Intent myIntent = new Intent(QuestionActivity.this, CorrectAnswerActivity.class);
                    myIntent.putExtra("current", cur);
                    myIntent.putExtra("Live", live);
                    startActivity(myIntent);
                } else {
                    Intent myIntent = new Intent(QuestionActivity.this, WrongAnswerActivity.class);
                    myIntent.putExtra("current", cur);
                    myIntent.putExtra("Live", live);
                    startActivity(myIntent);
                }
                //startActivity(new Intent(.this,.class));
            }
        });
    }

    public void setupNoButtonPress() {
        Button buttonNo = (Button) findViewById(R.id.noButton);
        buttonNo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(a[cur].compareTo("no") == 0) {
                    Intent myIntent = new Intent(QuestionActivity.this, CorrectAnswerActivity.class);
                    myIntent.putExtra("current", cur);
                    myIntent.putExtra("Live", live);
                    startActivity(myIntent);
                } else {
                    Intent myIntent = new Intent(QuestionActivity.this, WrongAnswerActivity.class);
                    myIntent.putExtra("current", cur);
                    myIntent.putExtra("Live", live);
                    startActivity(myIntent);
                }
            }
        });

    }

    public void readFileText() {
        txt = new String[1001];
        try {
            InputStream is = getAssets().open("q_lvl1.txt");

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            String line;

            int k=0;
            line = reader.readLine();
            while (line != null) {
                k++;
                txt[k] = line;
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       // tv.setText(txt[1].toString());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question, menu);
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
