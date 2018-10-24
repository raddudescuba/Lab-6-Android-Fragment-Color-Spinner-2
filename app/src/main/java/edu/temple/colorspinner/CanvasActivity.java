package edu.temple.colorspinner;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Intent intentData=getIntent();
        String color=intentData.getStringExtra("color");
        View layout=findViewById(R.id.color_layout);
        layout.setBackgroundColor(Color.parseColor(color));
    }
}
