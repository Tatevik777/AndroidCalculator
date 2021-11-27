package com.example.androidcalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button AC, Back, Div, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Zero,
            Equals, Multiply, Minus, Plus, Point;
    Float v1, v2;
    boolean ifadd, ifdiv, ifmul, ifsub;
    TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = findViewById(R.id.screen);

        One = findViewById(R.id.one);
        Two = findViewById(R.id.two);
        Three = findViewById(R.id.three);
        Four = findViewById(R.id.four);
        Five = findViewById(R.id.five);
        Six = findViewById(R.id.six);
        Seven = findViewById(R.id.seven);
        Eight = findViewById(R.id.eight);
        Nine = findViewById(R.id.nine);
        Zero = findViewById(R.id.zero);
        Point = findViewById(R.id.point);


        Multiply = findViewById(R.id.multiply);
        Equals = findViewById(R.id.equals);
        Plus = findViewById(R.id.plus);
        Minus = findViewById(R.id.minus);
        Div = findViewById(R.id.div);
        AC = findViewById(R.id.ac);
        Back = findViewById(R.id.back);

        One.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText() + "1");
            }
        });
        Two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText() + "2");
            }
        });
        Three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText() + "3");
            }
        });
        Four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText() + "4");
            }
        });
        Five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText() + "5");
            }
        });
        Six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText() + "6");
            }
        });
        Seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText() + "7");
            }
        });
        Eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText() + "8");
            }
        });
        Nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText() + "9");
            }
        });
        Zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText() + "0");
            }
        });
        Point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText(screen.getText() + ".");
            }
        });
        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1 = Float.valueOf(screen.getText() + "");
                ifadd = true;
                screen.setText(null);
            }
        });
        Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1 = Float.valueOf(screen.getText() + "");
                ifsub = true;
                screen.setText(null);
            }
        });
        Multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1 = Float.valueOf(screen.getText() + "");
                ifmul = true;
                screen.setText(null);
            }
        });
        Div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1 = Float.valueOf(screen.getText() + "");
                ifdiv = true;
                screen.setText(null);
            }
        });
        Equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v2 = Float.parseFloat(screen.getText() + "");
                if (ifadd == true) {
                    screen.setText(v1 + v2 + "");
                    ifadd = false;
                }
                if (ifsub == true) {
                    screen.setText(v1 - v2 + "");
                    ifsub = false;
                }
                if (ifmul == true) {
                    screen.setText(v1 * v2 + "");
                    ifmul = false;
                }
                if (ifdiv == true) {
                    screen.setText(v1 / v2 + "");
                    ifdiv = false;
                }

            }
        });
        AC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                screen.setText("");
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = screen.getText().toString();
                if (res.length() > 0) {
                    res = res.substring(0, res.length() - 1);
                    screen.setText(res);
                }
            }
        });
    }
}








