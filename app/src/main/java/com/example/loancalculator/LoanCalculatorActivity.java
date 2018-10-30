package com.example.loancalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class LoanCalculatorActivity extends AppCompatActivity
{

    private EditText LoanAmount, InterestRate, LoanPeriod;
    private TextView MonthlyPaymentResult, TotalPaymentsResult;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_calculator);

        LoanAmount = findViewById(R.id.loan_amount);
        InterestRate = findViewById(R.id.interest_rate);
        LoanPeriod = findViewById(R.id.loan_period);
        MonthlyPaymentResult = findViewById(R.id.monthly_payment_result);
        TotalPaymentsResult = findViewById(R.id.total_payments_result);

    }

    public void showLoanPayments(View clickedButton)
    {

        double loanAmount = Integer.parseInt(LoanAmount.getText().toString());
        double interestRate = (Integer.parseInt(InterestRate.getText().toString()));
        double loanPeriod = Integer.parseInt(LoanPeriod.getText().toString());
        double r = interestRate / 1200;
        double r1 = Math.pow(r + 1, loanPeriod);

        double monthlyPayment = ((r + (r / (r1 - 1))) * loanAmount);
        double totalPayment = monthlyPayment * loanPeriod;

        MonthlyPaymentResult.setText(new DecimalFormat("##.##").format(monthlyPayment));
        TotalPaymentsResult.setText(new DecimalFormat("##.##").format(totalPayment));
    }




}

