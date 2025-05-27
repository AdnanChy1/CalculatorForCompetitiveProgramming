package com.example.calculatorforcompetitiveprogramming;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class PrimeNumbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prime_numbers);
        EditText firstNumber = findViewById(R.id.et_f);
        EditText secondNumber = findViewById(R.id.et_s);
        TextView result = findViewById(R.id.tv_primelist);
        int[] isPrime = new int[1000001];
        for (int i=2;i<=1000000;i++){
            isPrime[i]=1;
        }

        for(int i=2;i*i<=1000000;i++){
            if(isPrime[i]==1){
                for(int j=i*i;j<=1000000;j+=i){
                    isPrime[j]=0;
                }
            }
        }
        ArrayList<Integer> primelist=new ArrayList<>();
        for(int i=0;i<=1000000;i++){
            if (isPrime[i]==1)primelist.add(i);
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.btn_submit).setOnClickListener(v -> {
            try {
                int a=Integer.parseInt(firstNumber.getText().toString());
                int b=Integer.parseInt(secondNumber.getText().toString());
                result.setText("List of Prime Numbers:\n");
                display(a,b,primelist,result);

            }catch (Exception e){
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
            }
        });
    }
    void display(int a,int b,ArrayList<Integer> primelist,TextView result){
        int i=0,j=primelist.size()-1;
        while (i<j){
            int mid=(i+j)/2;
            if (primelist.get(mid)<a)i=mid+1;
            else j=mid;
        }
        int count=1;
        for(int k=i;k<primelist.size();k++){
            if (primelist.get(k)<=b){
                result.setGravity(Gravity.START);
                result.append(count+") "+primelist.get(k)+"\n");
                count++;
            }
        }
    }

}