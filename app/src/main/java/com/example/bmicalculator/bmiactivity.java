package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class bmiactivity extends AppCompatActivity {

    android.widget.Button recalculatebmi;
    TextView bmidisplay,genderdisplay,bmicategory;
    Intent intent;
    ImageView imageView;
    String bmi;
    float intbmi;

    String height,weight;
    float intheight,intweight;
    RelativeLayout mbackground;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);



        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\"</font>"));
        getSupportActionBar().setTitle("Result");

        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        intent=getIntent();
        bmicategory=findViewById(R.id.bmicategory);
        genderdisplay=findViewById(R.id.genderdisplay);
        bmidisplay=findViewById(R.id.bmidisplay);
        mbackground=findViewById(R.id.contentlayout);
        imageView=findViewById(R.id.imageview);

        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;
        intbmi=intweight/(intheight*intheight);

        bmi=Float.toString(intbmi);

        if(intbmi<=17)
        {
            bmicategory.setText("UnderWeight");
            mbackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.crosss);

        }
        else if(intbmi>17 && intbmi<=24)
        {
            bmicategory.setText("Healthy");
        //    mbackground.setBackgroundColor(Color.YELLOW);
            imageView.setImageResource(R.drawable.ok);
        }
        else
        {
            bmicategory.setText("Overweight");
            mbackground.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }


        genderdisplay.setText(intent.getStringExtra("gender"));
        bmidisplay.setText(bmi);

        getSupportActionBar().hide();
        recalculatebmi=findViewById(R.id.recalculatebmi);

        recalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(bmiactivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}