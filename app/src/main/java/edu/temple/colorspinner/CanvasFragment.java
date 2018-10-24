package edu.temple.colorspinner;

import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CanvasFragment extends android.support.v4.app.Fragment {

    View layout,background;
    String color;
    public CanvasFragment() {
        // Required empty public constructor
    }


    public static CanvasFragment newInstance(String color){
        CanvasFragment canvasFragment=new CanvasFragment();
        Bundle bundle=new Bundle();
        bundle.putString("color",color);
        canvasFragment.setArguments(bundle);
        return canvasFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
            color = getArguments().getString("color");
    }




    public void changeColor(String color){
        change(color);
    }

    private void change(String color){
        background.setBackgroundColor(Color.parseColor(color));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_canvas, container, false);
        background = v.findViewById(R.id.fragmentLayout);

        change(color);

        return v;
    }




}
