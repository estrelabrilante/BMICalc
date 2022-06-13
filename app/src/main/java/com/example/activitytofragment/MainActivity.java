package com.example.activitytofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
  EditText weight,height;
  Button calculate;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //object for Fragment
        MyFirstFragment myFirstFragment = new  MyFirstFragment();

        //matching with Id
        weight = (EditText) findViewById(R.id.editTextNumberWeight);
        height = (EditText) findViewById(R.id.editTextNumberHeight);
        calculate = (Button) findViewById(R.id.buttonCalculate);
        //clicking button
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View view ) {
                int userWeight = Integer.parseInt(weight.getText().toString());
                int userHeight = Integer.valueOf(height.getText().toString());

                //bundle method is used for data transformation from Activity to fragment
                Bundle bundle = new Bundle();
                bundle.putInt("WEIGHT",userWeight);
                bundle.putInt("HEIGHT",userHeight);
                //define where to send(here it is to fragment)
                myFirstFragment.setArguments(bundle);
                //In fragment data is display in frame
                fragmentTransaction.add(R.id.frame,myFirstFragment);
                fragmentTransaction.commit();


            }
        });



    }
}