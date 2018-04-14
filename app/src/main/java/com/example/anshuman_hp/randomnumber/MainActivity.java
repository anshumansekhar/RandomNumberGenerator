package com.example.anshuman_hp.randomnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    EditText startNumberText;
    EditText endNumberText;
    int startNumber, endNumber;
    TextView result;
    ArrayList list = new ArrayList();
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startNumberText = (EditText) findViewById(R.id.StartNumber);
        endNumberText = (EditText) findViewById(R.id.EndNumber);
        result = (TextView) findViewById(R.id.result);
        submit = (Button) findViewById(R.id.button);
        result.setMovementMethod(new ScrollingMovementMethod());
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText("");
                list.clear();
                startNumber = Integer.valueOf(startNumberText.getText().toString());
                endNumber = Integer.valueOf(endNumberText.getText().toString());
                if (startNumber > endNumber) {
                    startNumber = startNumber + endNumber;
                    endNumber = startNumber - endNumber;
                    startNumber = startNumber - endNumber;

                }
                if (startNumber < endNumber && startNumber > 0 && endNumber > 0 && startNumber < 65 && endNumber < 65) {
                    for (int i = startNumber; i < endNumber; i++) {
                        list.add(i);
                    }
                    Collections.shuffle(list);
                    for (int i = 0; i < list.size(); i++) {
                        result.append(list.get(i).toString() + "\n");
                    }

                } else
                    Toast.makeText(getApplicationContext(), "Enter Correct Values", Toast.LENGTH_SHORT).show();


            }
        });


    }
}

