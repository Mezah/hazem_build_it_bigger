package com.hazem.tutorials.androidjokelibrary.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hazem.tutorials.androidjokelibrary.R;

public class JokeActivity extends AppCompatActivity {

    private TextView myJoke;
    public static final String JOKE="joke";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        myJoke= (TextView) findViewById(R.id.my_joke_text_view);

        String joke=getIntent().getStringExtra(JOKE);

        if(joke!=null){
            myJoke.setText(joke);
        }
        else myJoke.setText(getResources().getString(R.string.no_joke));

    }
}
