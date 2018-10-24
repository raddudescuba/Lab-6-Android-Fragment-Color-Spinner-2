package edu.temple.colorspinner;

import android.content.Context;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class SpinnerFragment extends android.support.v4.app.Fragment {
    ListView listView;
    Context parent;
    final String[] englishColors= {"Choose a Color","Red","Blue","Green","Black","Grey"};
    final String[] colors=getResources().getStringArray(R.array.Colors);

    public SpinnerFragment() {

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        this.parent=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_color, container, false);
        listView = v.findViewById(R.id.listView);

        listView.setAdapter(new PaletteActivity.ColorAdapter(parent,android.R.layout.simple_list_item_1,colors,englishColors));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View view, int position, long id) {
                String colorName = (String) parentView.getItemAtPosition(position);
                ((GetColorInterface) parent).colorSelected(colorName);
            }
        });

        return v;
    }


    interface GetColorInterface{
        void colorSelected(String color);
    }
}
