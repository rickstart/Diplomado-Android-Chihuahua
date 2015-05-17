package com.mobintum.calculator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private TextView txtResult;
    private Button btnAC, btnSign, btnPercent, btnDivision, btnMultiply, btnLess, btnPlus, btnEqual,
    btnDot, btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;

    private double oper1 = 0.0;
    private double oper2 = 0.0;

    private boolean flag = true;
    private int operation=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = (TextView) findViewById(R.id.txtResult);
        btnAC = (Button) findViewById(R.id.btnAC);
        btnSign = (Button) findViewById(R.id.btnSign);
        btnPercent = (Button) findViewById(R.id.btnPercent);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnLess = (Button) findViewById(R.id.btnLess);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnZero = (Button) findViewById(R.id.btnZero);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnNine = (Button) findViewById(R.id.btnNine);

        btnAC.setOnClickListener(this);
        btnSign.setOnClickListener(this);
        btnPercent.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnLess.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){


            case R.id.btnDot:

                String number = txtResult.getText().toString();
                if(!number.contains(".")){
                    txtResult.append(".");
                    flag = true;

                }
                break;

            case R.id.btnEqual:

                if(oper1 != 0.0 && flag){

                    oper2 = Double.valueOf(txtResult.getText().toString());
                    double result = operation(operation,oper1,oper2);
                    String sresult = Double.toString(result);
                    sresult = sresult.replace(".0","");
                    txtResult.setText(sresult);
                    oper2 = 0.0;
                    oper1 = result;
                    flag = false;

                }

                break;

            case R.id.btnAC:
                txtResult.setText("");
                flag = true;
                oper1 = 0.0;
                oper2 = 0.0;
                break;

            case R.id.btnMultiply:

                if(oper1==0.0){
                    oper1 = Double.valueOf(txtResult.getText().toString());
                    flag = false;

                }else if(oper2==0.0 && flag){
                    oper2 = Double.valueOf(txtResult.getText().toString());

                    double result = operation(operation, oper1, oper2);
                    txtResult.setText(Double.toString(result));
                    oper2 = 0.0;
                    oper1 = result;
                    flag = false;
                }
                operation = Constants.MULTIPLY;
                break;

            case R.id.btnLess:

                if(oper1==0.0){
                    oper1 = Double.valueOf(txtResult.getText().toString());
                    flag = false;

                }else if(oper2==0.0 && flag){
                    oper2 = Double.valueOf(txtResult.getText().toString());

                    double result = operation(operation, oper1, oper2);
                    txtResult.setText(Double.toString(result));
                    oper2 = 0.0;
                    oper1 = result;
                    flag = false;
                }
                operation = Constants.LESS;
                break;

            case R.id.btnDivision:

                if(oper1==0.0){
                    oper1 = Double.valueOf(txtResult.getText().toString());
                    flag = false;

                }else if(oper2==0.0 && flag){
                    oper2 = Double.valueOf(txtResult.getText().toString());

                    double result = operation(operation, oper1, oper2);
                    txtResult.setText(Double.toString(result));
                    oper2 = 0.0;
                    oper1 = result;
                    flag = false;
                }
                operation = Constants.DIVISION;
                break;

            case R.id.btnPlus:

                if(oper1==0.0){
                    oper1 = Double.valueOf(txtResult.getText().toString());
                    flag = false;

                }else if(oper2==0.0 && flag){
                    oper2 = Double.valueOf(txtResult.getText().toString());

                    double result = operation(operation, oper1, oper2);
                    txtResult.setText(Double.toString(result));
                    oper2 = 0.0;
                    oper1 = result;
                    flag = false;
                }
                operation = Constants.PLUS;
                break;

            default:
                Button btnTemp = (Button) findViewById(v.getId());

                if(flag) {
                    txtResult.append(btnTemp.getText());
                }else{
                    txtResult.setText(btnTemp.getText());
                    flag = true;
                }
                break;


        }

    }


    public double operation(int typeOper,double oper1, double oper2){

        double result = 0.0;

        switch (typeOper){

            case Constants.PLUS:
                result = oper1 + oper2;

                break;
            case Constants.DIVISION:
                result = oper1 / oper2;
                break;
            case Constants.LESS:
                result = oper1 - oper2;
                break;
            case Constants.MULTIPLY:
                result = oper1 * oper2;
                break;

        }
        return result;
    }
}
