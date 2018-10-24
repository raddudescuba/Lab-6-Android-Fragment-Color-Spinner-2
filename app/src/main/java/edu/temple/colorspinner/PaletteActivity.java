package edu.temple.colorspinner;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PaletteActivity extends AppCompatActivity {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        final Spinner spinner = findViewById(R.id.spinner);
        Resources res=getResources();
        String[] colors = res.getStringArray(R.array.Colors);
        final String[] englishColors= {"Choose a Color","Red","Blue","Green","Black","Grey"};
        ColorAdapter colorAdapter = new ColorAdapter(this,android.R.layout.simple_spinner_dropdown_item,colors,englishColors);
        colorAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);





        spinner.setAdapter(colorAdapter);




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position!=0) {
                    CanvasFragment canvasFragment = new CanvasFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("color",englishColors[position].toString());
                    canvasFragment.setArguments(bundle);
                    FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

                    if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
                        fragmentTransaction.replace(R.id.fragmentLayout,canvasFragment);
                        fragmentTransaction.replace(R.id.fragmentLayout2,canvasFragment);
                    }
                    else{
                        fragmentTransaction.replace(R.id.fragmentLayout,canvasFragment);
                    }

                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    class ColorAdapter extends ArrayAdapter<String>{

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