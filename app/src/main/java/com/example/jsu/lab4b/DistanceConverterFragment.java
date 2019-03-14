package com.example.jsu.lab4b;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


/**
 * A simple {@link Fragment} subclass.
 */
public class DistanceConverterFragment extends Fragment implements View.OnClickListener{


    public DistanceConverterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.distance_converter_fragment, container, false);

        Button b = (Button)v.findViewById(R.id.distButton); // Acquire button reference
        b.setOnClickListener(this);                     // Set event handler

        TextView ml = (TextView) v.findViewById(R.id.milesLabel);
        TextView kl = (TextView) v.findViewById(R.id.kilosLabel);

        ml.setText("Miles");
        kl.setText("Kilos");

        return v;

    }

    @Override
    public void onClick(View v) {

        String m = ((EditText) getView().findViewById(R.id.milesValue)).getText().toString();
        String k = ((EditText) getView().findViewById(R.id.kilosValue)).getText().toString();

        if (m.isEmpty()) {

            if (!k.isEmpty()) {

                double kilometers = Double.parseDouble(k);
                double miles = (kilometers / 1.60934);

                ((EditText) getView().findViewById(R.id.milesValue)).setText(Double.toString(miles));
            }

        }

        else {

            double miles = Double.parseDouble(m);
            double kilometers = (miles * 1.60934);

            ((EditText) getView().findViewById(R.id.kilosValue)).setText(Double.toString(kilometers));
        }

    }



}
