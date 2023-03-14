package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Currency> currencyList;
    EditText text;
    Integer idCurrency = 0;
    EditText inputValue;
    EditText outputValue;
    Spinner selectCurrency;
    Spinner selectCurrencyConvertTo;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //text = findViewById(R.id.out);

        inputValue = findViewById(R.id.inputValue);
        outputValue = findViewById(R.id.outputValue);
        selectCurrency = findViewById(R.id.selectCurrency);
       // selectCurrencyConvertTo = findViewById(R.id.selectCurrencyConvertTo);
        convert = findViewById(R.id.convert);

        convert.setOnClickListener(v -> {
            double amount = Double.parseDouble( inputValue.getText().toString());
            double buy = currencyList.get(idCurrency).getRateBuy();
            if(amount <= 0){
                return;
            }

            if (buy == 0)
            {
                outputValue.setText("Zero");
                return;
            }

            double res = amount * buy ;
            outputValue.setText( String.valueOf(res) );
        });

         selectCurrency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 idCurrency = position;
             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {
             }
         });


        NetworkService.getInstance()
        .getJSONApi()
        .getData().
        enqueue(new Callback<List<Currency>>() {
            @Override
            public void onResponse(Call<List<Currency>> call, Response<List<Currency>> response) {

                if (!response.isSuccessful()) {
                    return;
                }
                currencyList = new ArrayList<Currency>(10);
                currencyList.add(new Currency());
                currencyList.add(new Currency());
                currencyList.add(new Currency());
                currencyList.add(new Currency());
                List<Currency> dataL = response.body();

                for (Currency currency : Objects.requireNonNull(dataL)) {
                    int code = currency.getCurrencyCodeA();
                    int codeB = currency.getCurrencyCodeB();

                    if( code == 840 ){

                        currencyList.set (0,currency);
                    } else if ( code == 978 && codeB==980) {

                        currencyList.set (1,currency);
                    } else if (code == 826 ) {

                        currencyList.set (2,currency);
                    } else if ( code == 985 ) {

                        currencyList.set (3,currency);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Currency>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Errrrrrroooo" + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
                Log.d("TT1",t.getMessage());
                text.setText(t.getMessage());
            }
        });
    }
}