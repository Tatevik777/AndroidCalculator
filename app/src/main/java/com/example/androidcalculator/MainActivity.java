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
    private String input="",Answer;
    private boolean clearResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen = findViewById(R.id.screen);
       
    }

    // Метод для инициализации действия кнопок

    public void onClick(View view) {
        Button button = (Button) view;

        String data = button.getText().toString();// получаем текст из кнопок
        //Описываем действия для каждой кнопки
        switch (data) {
            case "AC":
                input = " ";
                clearResult=false;
                break;
            case "x":
                clearResult=false;
                Logic();
                input += "*";
                break;

            case "=":
                clearResult=true;
                Logic();
                Answer = input;
                break;

            case "←":
                if(input.length()>0){
                    clearResult=false;
                    String newText=input.substring(0,input.length()-1);
                    input=newText;
                }
                break;
            default:
                if(input==null){
                    input="";
                }
                if(data.equals("+") || data.equals("-") || data.equals("/")){
                    clearResult=false;
                    Logic();
                }
                else if(clearResult==true){
                    input="";
                    clearResult=false;
                }
                input+=data;
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


