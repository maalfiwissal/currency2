package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner spinner1;
    Spinner spinner2;
    TextView textView1;
    EditText textView2;
    Button button3;
    String[] currency = {"dollar","euro", "mad"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 =findViewById(R.id.spinner1);
        spinner2 =findViewById(R.id.spinner2);

        textView1 =findViewById(R.id.textView1);
        textView2 =findViewById(R.id.textView2);
        button3= findViewById(R.id.button3);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,currency);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value =parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });

        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,currency);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value =parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });



       button3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Convert();
           }
       });

    }
    public void Convert() {
        String input = spinner1.getSelectedItem().toString();
        String output = spinner2.getSelectedItem().toString();

      //  if(textView2.getText().toString().equals("")){
        //    Toast.makeText(this, "Enter valid number", Toast.LENGTH_SHORT).show();

        if(input.equals("euro") & output.equals("mad")){
            Double amountcurrency = Double.parseDouble(textView2.getText().toString());
            Double result = amountcurrency * 11.01;
            textView1.setText(String.valueOf(result));
        }else if (input.equals("euro") & output.equals("dollar")) {
            Double amountcurrency = Double.parseDouble(textView2.getText().toString());
            Double result = amountcurrency * 1.06;
            textView1.setText(String.valueOf(result));

        }else if (input.equals("dollar") & output.equals("mad")) {
            Double amountcurrency = Double.parseDouble(textView2.getText().toString());
            Double result = amountcurrency * 10.34;
            textView1.setText(String.valueOf(result));
        }else if(input.equals("dollar") & output.equals("euro")) {
            Double amountcurrency = Double.parseDouble(textView2.getText().toString());
            Double result = amountcurrency * 0.94;
            textView1.setText(String.valueOf(result));
        } else if(input.equals("mad") & output.equals("euro")) {
        Double amountcurrency = Double.parseDouble(textView2.getText().toString());
        Double result = amountcurrency * 0.091;
        textView1.setText(String.valueOf(result));
        } else if(input.equals("mad") & output.equals("dollar")) {
        Double amountcurrency = Double.parseDouble(textView2.getText().toString());
        Double result = amountcurrency * 0.097;
        textView1.setText(String.valueOf(result));
       }else if (textView2.getText().toString().equals("") || textView2.getText().toString().equals("input")){
            Toast.makeText(this, "Enter valid number", Toast.LENGTH_SHORT).show();
        }

    }
}