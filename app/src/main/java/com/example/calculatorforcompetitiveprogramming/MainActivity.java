package com.example.calculatorforcompetitiveprogramming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    TextView display;
    TextView output;
    StringBuilder input = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display_input);
        output=findViewById(R.id.display_result);
        int[] button_id = {R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7,
                R.id.btn_8, R.id.btn_9, R.id.btn_addition, R.id.btn_subtract, R.id.btn_multiply, R.id.btn_divide,
                R.id.btn_decimal, R.id.btn_leftbracket, R.id.btn_rightbracket, R.id.btn_equal,R.id.btn_delete,R.id.btn_clr};
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        View.OnClickListener inputListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                if (b.getText().toString().equals("X"))
                input.append("*");
                else input.append(b.getText().toString());
                display.setText(input.toString());
            }
        };
        // All other button listeners
        for (int id : button_id) {
            findViewById(id).setOnClickListener(inputListener);
        }
        // CLR Button
        findViewById(R.id.btn_clr).setOnClickListener(v -> {
            input.setLength(0);
            display.setText("0");
            output.setText("Output");
        });

        // DEL Button
        findViewById(R.id.btn_delete).setOnClickListener(v -> {
            if (input.length() > 0) {
                input.deleteCharAt(input.length() - 1);
                display.setText(input.length() > 0 ? input.toString() : "0");
            }
        });
        // EQUAL Button, evaluates the expression using the ExpressionBuilder library exp4j
        findViewById(R.id.btn_equal).setOnClickListener(v -> {
            try {
                String s=display.getText().toString();
                Expression e = new ExpressionBuilder(s).build();
                double result = e.evaluate();
                output.setText(String.valueOf(result));
            } catch (Exception e) {
                output.setText("Error");
            }
        });
        findViewById(R.id.btn_advnacedmode).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, advanced_mode.class);
            startActivity(intent);
        });
    }
}