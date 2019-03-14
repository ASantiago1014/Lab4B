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

        switch(v.getId()) {

            case R.id.calculateBill:
                tipButtonClicked(v);
                break;

            case R.id.distButton:
                distButtonClicked(v);
                break;

            case R.id.convertTemp:
                tempButtonClicked(v);


        }


    }

    public void tipButtonClicked(View v) {

        String b = ((EditText) v.findViewById(R.id.billAmount)).getText().toString();
        String p = ((EditText) v.findViewById(R.id.numOfPeople)).getText().toString();
        String t = ((EditText) v.findViewById(R.id.percentAmount)).getText().toString();
        TextView tt = (TextView) v.findViewById(R.id.totalTip);
        TextView tb = (TextView) v.findViewById(R.id.totalBill);
        DecimalFormat df = (new DecimalFormat(".##"));

        if (b.isEmpty() || p.isEmpty())
            ;

        else if (t.isEmpty() || t =="0") {

            double bill = Double.parseDouble(b);
            double people = Double.parseDouble(p);

            tt.setText("0.00");

            double billOwed = (bill / people);

            tb.setText(String.valueOf(df.format(billOwed)));
        }

        else {

            double bill = Double.parseDouble(b);
            double people = Double.parseDouble(p);
            double tip = (Double.parseDouble(t)) / 100;

            double tipOwed = (bill * tip) / people;

            tt.setText(String.valueOf(df.format(tipOwed)));

            double billOwed = (bill / people) + tipOwed;

            tb.setText(String.valueOf(df.format(billOwed)));


        }
    }

    public void distButtonClicked(View v) {

        String m = ((EditText) v.findViewById(R.id.milesValue)).getText().toString();
        String k = ((EditText) v.findViewById(R.id.kilosValue)).getText().toString();

        if (m.isEmpty()) {

            if (!k.isEmpty()) {

                double kilometers = Double.parseDouble(k);
                double miles = (kilometers / 1.60934);

                ((EditText) v.findViewById(R.id.milesValue)).setText(Double.toString(miles));
            }

        }

        else {

            double miles = Double.parseDouble(m);
            double kilometers = (miles * 1.60934);

            ((EditText) v.findViewById(R.id.kilosValue)).setText(Double.toString(kilometers));
        }
    }

    public void tempButtonClicked(View v) {

        String f = ((EditText) v.findViewById(R.id.fValue)).getText().toString();
        String c = ((EditText) v.findViewById(R.id.cValue)).getText().toString();

        if (f.isEmpty()) {

            if (!c.isEmpty()) {

                double celsius = Double.parseDouble(c);
                double fahrenheit = ((celsius * 9 / 5) + 32);

                ((EditText) v.findViewById(R.id.fValue)).setText(Double.toString(fahrenheit));
            }

        }

        else {

            double fahrenheit = Double.parseDouble(f);
            double celsius = ((fahrenheit - 32) * 5 / 9);

            ((EditText) v.findViewById(R.id.cValue)).setText(Double.toString(celsius));
        }
    }

}
