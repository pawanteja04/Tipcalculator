package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextBillAmount;
    private EditText editTextTipPercentage;
    private Button buttonCalculateTip;
    private TextView textViewTipAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBillAmount = findViewById(R.id.editTextBillAmount);
        editTextTipPercentage = findViewById(R.id.editTextTipPercentage);
        buttonCalculateTip = findViewById(R.id.buttonCalculateTip);
        textViewTipAmount = findViewById(R.id.textViewTipAmount);

        buttonCalculateTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTip();
            }
        });
    }

    private void calculateTip() {
        String billAmountString = editTextBillAmount.getText().toString();
        String tipPercentageString = editTextTipPercentage.getText().toString();

        if (billAmountString.isEmpty() || tipPercentageString.isEmpty()) {
            textViewTipAmount.setText("Please enter bill amount and tip percentage.");
            return;
        }

        double billAmount = Double.parseDouble(billAmountString);
        int tipPercentage = Integer.parseInt(tipPercentageString);

        double tipAmount = billAmount * tipPercentage / 100.0;

        textViewTipAmount.setText("Tip Amount: " + String.format("%.2f", tipAmount));
    }
}
