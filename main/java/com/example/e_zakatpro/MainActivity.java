package com.example.e_zakatpro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double value,totalValue;
    EditText weight,goldValue;
    RadioButton btnWear, btnKeep;
    TextView Output1, Output2, Output3;
    Button btnCalculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculateButtonClick(View view) {
        weight = (EditText) findViewById(R.id.weight);
        goldValue = (EditText) findViewById(R.id.goldValue);
        RadioButton btnWear = (RadioButton) findViewById(R.id.btnWear);
        RadioButton btnKeep = (RadioButton) findViewById(R.id.btnKeep);
        Output1 = (TextView) findViewById(R.id.Output1);
        Output2 = (TextView) findViewById(R.id.Output2);
        Output3 = (TextView) findViewById(R.id.Output3);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        double goldWeight = Double.parseDouble(weight.getText().toString());
        double Value = Double.parseDouble(goldValue.getText().toString());
        double TotalValue = goldWeight * Value;
        double goldMinus = 0;
        double keepValue = 85, wearValue = 200;
        double payable = 0, zakat = 0;

        if (btnKeep.isChecked()) {
            goldMinus = (goldWeight - keepValue);
            if (goldMinus > 0) {
                payable = goldMinus * Value;
                zakat = payable * 0.025;
            } else if (goldMinus < 0) {
                payable = 0;
            }
        } else if (btnWear.isChecked()) {
            goldMinus = (goldWeight - wearValue);
            if (goldMinus > 0) {
                payable = goldMinus * Value;
                zakat = payable * 0.025;
            } else if (goldMinus < 0) {
                payable = 0;
            }
        }
        Output1.setText("Total Value of the gold: RM " + TotalValue);
        Output2.setText("Payable Zakat RM " + payable);
        Output3.setText("Total Zakat: RM " + zakat);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu,menu);
       return true;

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()){
            case R.id.converter:
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.about:
                intent = new Intent(MainActivity.this,About.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
