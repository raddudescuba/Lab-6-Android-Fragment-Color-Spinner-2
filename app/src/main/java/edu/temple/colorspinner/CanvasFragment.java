package edu.temple.colorspinner;

import android.content.res.Configuration;
import android.graphics.Color;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CanvasFragment extends android.support.v4.app.Fragment {


    private String mParam1;

    View layout;
    public CanvasFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        layout=inflater.inflate(R.layout.fragment_canvas,container,false);
        layout.setBackgroundColor(Color.parseColor(getArguments().getString("color")));
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            layout.setBackgroundColor(Color.parseColor(getArguments().getString("color")));
        }
        return layout;
    }




}
