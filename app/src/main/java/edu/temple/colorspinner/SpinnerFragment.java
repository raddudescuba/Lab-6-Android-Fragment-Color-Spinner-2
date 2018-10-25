package edu.temple.colorspinner;

import android.content.Context;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

public class SpinnerFragment extends android.support.v4.app.Fragment {
    Spinner spinner;
    Context parent;
    final String[] englishColors = {"Choose a Color","Red","Blue","Green","Black","Grey"};
    String[] colors = getResources().getStringArray(R.array.Colors);

    public SpinnerFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_spinner, container, false);
        spinner = v.findViewById(R.id.spinner);

        spinner.setAdapter(new PaletteActivity.ColorAdapter(parent,android.R.layout.simple_spinner_dropdown_item,colors,englishColors));
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View view, int position, long id) {
                String colorName = (String) parentView.getItemAtPosition(position);
                if(getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE){
                    parentView.setBackgroundColor(Color.parseColor(colorName));
                }

            }
        });

        return v;
    }
}
