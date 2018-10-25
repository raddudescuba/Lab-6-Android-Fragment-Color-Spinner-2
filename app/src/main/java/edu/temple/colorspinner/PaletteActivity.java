package edu.temple.colorspinner;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity implements GetColor{
    boolean portraitMode;
    FragmentManager fragmentManager;
    CanvasFragment canvasFragment;
    SpinnerFragment spinnerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);


        portraitMode=findViewById(R.id.fragmentLayout2)==null;
        canvasFragment=new CanvasFragment();
        spinnerFragment=new SpinnerFragment();

        fragmentManager=getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.fragmentLayout,spinnerFragment)
                .commit();

        if(!portraitMode){
            fragmentManager.beginTransaction()
                    .replace(R.id.fragmentLayout2,canvasFragment)
                    .commit();
        }


    }

    @Override
    public void colorSelected(String color){
        if(portraitMode){
            CanvasFragment canvasFragment1= CanvasFragment.newInstance(color);
            fragmentManager.beginTransaction()
                    .add(R.id.fragmentLayout,canvasFragment1)
                    .addToBackStack(null)
                    .commit();
        }
        else{
            canvasFragment.changeColor(color);
        }
    }

    static class ColorAdapter extends ArrayAdapter<String>{

        String viewColors[];
        String myColors[];

        public ColorAdapter(@NonNull Context context, int resource, String[] viewColors, String[] myColors) {
            super(context, resource,viewColors);
            this.viewColors=viewColors;
            this.myColors=myColors;
        }
        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            TextView textView = (TextView)super.getDropDownView(position,convertView,parent);

            if(position>0){
                textView.setBackgroundColor(Color.parseColor(myColors[position].toString()));
            }
            else{
                textView.setBackgroundColor(Color.WHITE);
            }
            return textView;
        }
    }
}