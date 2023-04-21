package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    android.widget.Button calculatebmi;

    RelativeLayout male,female;
    SeekBar seekbarheight;
    ImageView decrementweight,decrementage,incrementweight,incrementage;
    TextView currentage,currentweight,currentheight;

    int intweight=26;
    int intage=15;
    int currentprogress;
    String mintprogress="80";
    String typeofuser="0";
    String weight2="55";
    String age2="22";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        calculatebmi=findViewById(R.id.calculatebmi);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        seekbarheight=findViewById(R.id.seekbarheight);
        decrementweight=findViewById(R.id.decrementweight);
        decrementage=findViewById(R.id.decrementage);
        incrementweight=findViewById(R.id.incrementweight);
        incrementage=findViewById(R.id.incrementage);
        currentage=findViewById(R.id.currentage);
        currentheight=findViewById(R.id.currentheight);
        currentweight=findViewById(R.id.currentweight);


        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Male";
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalefocus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotfocus));
                typeofuser="Female";
            }
        });

        seekbarheight.setMax(300);
        seekbarheight.setProgress(80);
        seekbarheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentprogress=progress;
                mintprogress=String.valueOf(currentprogress);
                currentheight.setText(mintprogress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        incrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage+1;
                age2=String.valueOf(intage);
                currentage.setText(age2);
            }
        });


        incrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight+1;
                weight2=String.valueOf(intweight);
                currentweight.setText(weight2);
            }
        });

        decrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intweight=intweight-1;
                weight2=String.valueOf(intweight);
                currentweight.setText(weight2);
            }
        });


        decrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intage=intage-1;
                age2=String.valueOf(intage);
                currentage.setText(age2);
            }
        });




        calculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(typeofuser.equals("0"))
                {
                    Toast.makeText(MainActivity.this, "Select Your gender first..", Toast.LENGTH_SHORT).show();
                }
                else if(mintprogress.equals("0"))
                {
                    Toast.makeText(MainActivity.this, "Select Your Height first..", Toast.LENGTH_SHORT).show();
                }
                else if(intage<=0)
                {
                    Toast.makeText(MainActivity.this, "Select Your correct age first..", Toast.LENGTH_SHORT).show();
                }
                else if(intweight<=0)
                {
                    Toast.makeText(MainActivity.this, "Select Your correct weight first..", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Intent intent=new Intent(MainActivity.this,bmiactivity.class);
                    intent.putExtra("gender",typeofuser);
                    intent.putExtra("age",age2);
                    intent.putExtra("height",mintprogress);
                    intent.putExtra("weight",weight2);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                }

            }
        });
    }
}