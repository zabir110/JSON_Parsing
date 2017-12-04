package com.example.user.json_parsing;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    public static  TextView show;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.show);
        show = (TextView) findViewById(R.id.text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ParsingData parsingData=new ParsingData(MainActivity.this);
                Toast.makeText(MainActivity.this,"Please wait",Toast.LENGTH_SHORT).show();
                parsingData.execute();

            }
        });



    }

}
