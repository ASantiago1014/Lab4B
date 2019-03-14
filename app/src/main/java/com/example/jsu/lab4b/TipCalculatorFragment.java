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
public class TipCalculatorFragment extends Fragment implements View.OnClickListener{


    public TipCalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tip_calculator, container, false);

        Button b = (Button)v.findViewById(R.id.calculateBill); // Acquire button reference
        b.setOnClickListener(this);                     // Set event handler

        TextView bl = (TextView) v.findViewById(R.id.billLabel);
        TextView pl = (TextView) v.findViewById(R.id.peopleLabel);
        TextView tl = (TextView) v.findViewById(R.id.tipPercentLabel);

        bl.setText("Bill: $");
        pl.setText("People:");
        tl.setText("Tip Percent: %");

        return v;
    }

    @Override
    public void onClick(View v) {



        String b = ((EditText) getView().findViewById(R.id.billAmount)).getText().toString();
        String p = ((EditText) getView().findViewById(R.id.numOfPeople)).getText().toString();
        String t = ((EditText) getView().findViewById(R.id.percentAmount)).getText().toString();

        TextView tt = (TextView) getView().findViewById(R.id.totalTip);
        TextView tb = (TextView) getView().findViewById(R.id.totalBill);

        DecimalFormat df = (new DecimalFormat(".##"));

        //if (b.isEmpty() || p.isEmpty());

        if (t.isEmpty() || t =="0") {

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





}
