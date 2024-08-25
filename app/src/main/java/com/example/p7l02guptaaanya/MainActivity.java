package com.example.p7l02guptaaanya;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    Button incrementButton;
    TextView greetingDisplay, greetingStart;
    String[] planets;
    RadioButton leftRadBut, rightRadBut;
    EditText name;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incrementButton = findViewById(R.id.increment_button);
        greetingDisplay = findViewById(R.id.greeting_textview);
        planets = getResources().getStringArray(R.array.planets_array);
        leftRadBut = findViewById(R.id.radio_left);
        rightRadBut = findViewById(R.id.radio_right);
        name = findViewById(R.id.name_input);
        greetingStart = findViewById(R.id.greeting_name);
        Button submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameT = name.getText().toString();
                if (!nameT.isEmpty()) {
                    greetingStart.setText(getString(R.string.greeting, nameT));
                    name.setVisibility(View.GONE);
                    submitButton.setVisibility(View.GONE);
                }
            }
        });

//        name.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int st, int c, int a) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int st, int b, int c) {
//                //name.setHint("Welcome " + s.toString());
//                greetingStart.setText(getString(R.string.greeting, s.toString()));
//                name.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//            }
//        });
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                System.out.println("incrementing: " + ++count);
//                Log.i("incrementing", String.valueOf(count));
//                greetingDisplay.setText(getString(R.string.likes_count, count));
                if(rightRadBut.isChecked())
                    count = ++count%planets.length;
                greetingDisplay.setText(planets[count]);

            }
        });
    }

    public void decrement(View view) {
//        System.out.println("decrementing: " + --count);
//        greetingDisplay.setText(getString(R.string.likes_count, count));
        if(leftRadBut.isChecked())
            if(--count < 0) count = planets.length-1;
        greetingDisplay.setText(planets[count]);
    }
}