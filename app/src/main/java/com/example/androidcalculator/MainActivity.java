package com.example.androidcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    //Объявляем все кнопки калькулятора, экран и переменные ввод и ответ;

    private TextView Screen;
    private Button AC, Back, Div, One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Zero,
            Equals, Multiply, Minus, Plus, Point;
    private String input, Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen = findViewById(R.id.screen);
        //Инициализируем экран и кнопки

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

        AC = findViewById(R.id.ac);
        Back = findViewById(R.id.back);
        Div = findViewById(R.id.div);
        Multiply = findViewById(R.id.multiply);
        Minus = findViewById(R.id.minus);
        Plus = findViewById(R.id.plus);
        Point = findViewById(R.id.point);
        Equals = findViewById(R.id.equal);
    }

    // Метод для инициализации действия кнопок
    public void ButtonClick(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();// получаем текст из кнопок
        //Описываем действия для каждой кнопки
        switch (data) {
            case "AC":
                input = " ";
                break;
            case "x":
                Logic();
                input += "*";
                break;

            case "=":
                Logic();
                Answer = input;
                break;

            case "←":
                String newText = input.substring(0, input.length() - 1);
                input = newText;
                break;

            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/")) {
                    Logic();
                }
                input += data;
                // если в данных есть знак + , - или деление , то вызывает метод
                // с логикой калькулятора
        }
        Screen.setText(input);// и добавляем данные на экран
    }

    //Логика калькулятора
    private void Logic() {
        // метод split для соединения операций и цифр
        if (input.split("\\*").length == 2) {
            String[] number = input.split("\\*");
            try {
                double multiply = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                input = multiply + "";
            } catch (Exception e) {
            }


        } else if (input.split("/").length == 2) {
            String[] number = input.split("/");
            try {
                double division = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                input = division + "";
            } catch (Exception e) {
            }


        } else if (input.split("\\+").length == 2) {
            String[] number = input.split("\\+");
            try {
                double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = sum + "";
            } catch (Exception ignored) {
            }
        } else if (input.split("-").length > 1) {
            String[] number = input.split("-");
            if (number[0].equals("") && number.length == 2) {
                number[0] = 0 + "";
            }
            try {
                double substraction = 0;
                if (number.length == 2) {
                    substraction = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                } else if (number.length == 3) {
                    substraction = Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                }

                input = substraction + "";
            } catch (Exception ignored) {
            }


        }


        String[] number = input.split("\\.");
        if (number.length > 1) {
            if (number[1].equals("0")) {
                input = number[0];
            }


        }
        Screen.setText(input);
    }
}