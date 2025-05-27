package com.example.calculatorforcompetitiveprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.math.BigInteger;

public class advanced_mode extends AppCompatActivity {
    EditText firstNumber, secondNumber;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        firstNumber = findViewById(R.id.et_first_num);
        secondNumber = findViewById(R.id.et_second_num);
        result = findViewById(R.id.tv_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.btn_gcd).setOnClickListener(v -> {
            try {
                long a = Long.parseLong(firstNumber.getText().toString());
                long b = Long.parseLong(secondNumber.getText().toString());
                result.setText(String.valueOf(gcd(a, b)));
            } catch (Exception e) {
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_lcm).setOnClickListener(v -> {
            try {
                double a = Double.parseDouble(firstNumber.getText().toString());
                double b = Double.parseDouble(secondNumber.getText().toString());
                result.setText(String.valueOf(lcm(a, b)));
            } catch (Exception e) {
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_expo).setOnClickListener(v -> {
            try {
                double a = Double.parseDouble(firstNumber.getText().toString());
                double b = Double.parseDouble(secondNumber.getText().toString());
                result.setText(String.valueOf(Math.pow(a, b)));
            } catch (Exception e) {
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_mod).setOnClickListener(v -> {
            try {
                long a = Long.parseLong(firstNumber.getText().toString());
                long b = Long.parseLong(secondNumber.getText().toString());
                result.setText(String.valueOf(a % b));
            } catch (Exception e) {
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_fact).setOnClickListener(v -> {
            try {
                long a = Long.parseLong(firstNumber.getText().toString());
                result.setText(String.valueOf(factorial(a)));
            } catch (Exception e) {
                result.setText("Invalid Input");
            }

        });
        findViewById(R.id.btn_sin).setOnClickListener(v -> {
            try {
                double a = Integer.parseInt(firstNumber.getText().toString());
                 a=Math.toRadians(a);
                result.setText(String.valueOf(Math.sin(a)));
            } catch (Exception e) {
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_cos).setOnClickListener(v -> {
            try {
                double a = Integer.parseInt(firstNumber.getText().toString());
                a=Math.toRadians(a);
                result.setText(String.valueOf(Math.cos(a)));
            } catch (Exception e) {
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_tan).setOnClickListener(v -> {
            try {
                double a = Double.parseDouble(firstNumber.getText().toString());
                a=Math.toRadians(a);
                result.setText(String.valueOf(Math.tan(a)));
            } catch (Exception e) {
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_log2).setOnClickListener(v -> {
            try{
                double a=Double.parseDouble(firstNumber.getText().toString());
                result.setText(String.valueOf(Math.log(a)/Math.log(2)));
            }catch (Exception e){
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_log10).setOnClickListener(v -> {
            try{
                double a=Double.parseDouble(firstNumber.getText().toString());
                result.setText(String.valueOf(Math.log10(a)));
            }catch (Exception e){
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_sqrt).setOnClickListener(v->{
            try {
                double a=Double.parseDouble(firstNumber.getText().toString());
                result.setText(String.valueOf(Math.sqrt(a)));
            }catch (Exception e){
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_ncr).setOnClickListener(v->{
            try {
                long n=Long.parseLong(firstNumber.getText().toString());
                long r=Long.parseLong(secondNumber.getText().toString());
                BigInteger numerator=factorial(n);
                BigInteger denominator=factorial(n-r).multiply(factorial(r));
                result.setText(String.valueOf(numerator.divide(denominator)));
            }catch (Exception e){
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_npr).setOnClickListener(v->{
            try {
                long n=Long.parseLong(firstNumber.getText().toString());
                long r=Long.parseLong(secondNumber.getText().toString());
                BigInteger numerator=factorial(n);
                BigInteger denominator=factorial(n-r);
                result.setText(String.valueOf(numerator.divide(denominator)));
            }catch (Exception e){
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_and).setOnClickListener(v->{
            try {
                long a = Long.parseLong(firstNumber.getText().toString());
                long b = Long.parseLong(secondNumber.getText().toString());
                result.setText(String.valueOf(a&b));
            }catch (Exception e){
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_or).setOnClickListener(v->{
            try {
                long a = Long.parseLong(firstNumber.getText().toString());
                long b = Long.parseLong(secondNumber.getText().toString());
                result.setText(String.valueOf(a|b));
            }catch (Exception e){
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_xor).setOnClickListener(v->{
            try {
                long a = Long.parseLong(firstNumber.getText().toString());
                long b = Long.parseLong(secondNumber.getText().toString());
                result.setText(String.valueOf(a ^ b));
            }catch (Exception e){
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_bin).setOnClickListener(v->{
           try {
               long a = Long.parseLong(firstNumber.getText().toString());
               result.setTextSize(15);
               result.setText(((Long.toBinaryString(a)))+"\n"+"Number of set bits:"+Long.bitCount(a));

           }catch (Exception e){
               result.setText("Invalid Input");
           }
        });
        findViewById(R.id.btn_oct).setOnClickListener(v->{
            try {
                long a = Long.parseLong(firstNumber.getText().toString());
                result.setText(((Long.toOctalString(a))));
            }catch (Exception e){
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_hex).setOnClickListener(v->{
            try {
                long a = Long.parseLong(firstNumber.getText().toString());
                result.setText(((Long.toHexString(a))));
            }catch (Exception e){
                result.setText("Invalid Input");
            }
        });
        findViewById(R.id.btn_clear).setOnClickListener(v->{
            firstNumber.setText("");
            secondNumber.setText("");
            result.setText("");
            firstNumber.setHint("Enter First Number");
            secondNumber.setHint("Enter Second Number");
            result.setHint("Result will be shown here");
        });
        findViewById(R.id.btn_moreoptions).setOnClickListener(v->{
            Intent intent = new Intent(advanced_mode.this,PrimeNumbers.class);
            startActivity(intent);
        });

    }
    double gcd(double a, double b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    double lcm(double a, double b) {
        return (a * b) / gcd(a, b);
    }
    BigInteger factorial(long a) {
        BigInteger value=BigInteger.ONE;
        for (int i = 2; i <= a; i++) {
            value=BigInteger.valueOf(i).multiply(value);
        }
        return value;
    }

}