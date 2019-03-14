package com.example.jsu.lab4b;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class TempConverterFragment extends Fragment implements View.OnClickListener{


    public TempConverterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.temperature_converter_fragment, container, false);

        Button b = (Button)v.findViewById(R.id.convertTemp); // Acquire button reference
        b.setOnClickListener(this);                     // Set event handler

        TextView f = (TextView) v.findViewById(R.id.fLabel);
        TextView c = (TextView) v.findViewById(R.id.cLabel);

        f.setText("Fahrenheit");
        c.setText("Celsius");

        return v;

    }

    @Override
    public void onClick(View v) {

        String f = ((EditText) getView().findViewById(R.id.fValue)).getText().toString();
        String c = ((EditText) getView().findViewById(R.id.cValue)).getText().toString();

        if (f.isEmpty()) {

            if (!c.isEmpty()) {

                double celsius = Double.parseDouble(c);
                double fahrenheit = ((celsius * 9 / 5) + 32);

                ((EditText) getView().findViewById(R.id.fValue)).setText(Double.toString(fahrenheit));
            }

        }

        else {

            double fahrenheit = Double.parseDouble(f);
            double celsius = ((fahrenheit - 32) * 5 / 9);

            ((EditText) getView().findViewById(R.id.cValue)).setText(Double.toString(celsius));
        }


    }



}
