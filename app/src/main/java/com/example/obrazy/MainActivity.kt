package com.example.obrazy

import android.R.attr.*
import android.graphics.Matrix
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val CheckWidok: CheckBox =findViewById(R.id.CheckWidoczny);
        val Obrazek: ImageView =findViewById(R.id.Obrazek);

        val Obracacz: EditText =findViewById(R.id.Obrot);
        val SkalaX: EditText =findViewById(R.id.SkalaX);
        val SkalaY: EditText =findViewById(R.id.SkalaY);

        CheckWidok.setOnClickListener(){
            if(CheckWidok.isChecked()){
                Obrazek.setVisibility(View.VISIBLE);
            }else{
                Obrazek.setVisibility(View.INVISIBLE);
            }
        }
        Obracacz.setOnClickListener(){
            var ScaleY =SkalaY.text.toString().toInt().toFloat();
            Obrazek.setScaleType(ImageView.ScaleType.CENTER_INSIDE)
            Obrazek.setScaleY(ScaleY)
        }
        SkalaY.setOnClickListener(){
            var ScaleY =SkalaY.text.toString().toInt().toFloat();
            Obrazek.setScaleType(ImageView.ScaleType.CENTER_INSIDE)
            Obrazek.setScaleY(ScaleY)
        }
        SkalaX.setOnClickListener(){
            var ScaleX =SkalaX.text.toString().toInt().toFloat();
            Obrazek.setScaleType(ImageView.ScaleType.CENTER_INSIDE)
            Obrazek.setScaleX(ScaleX)
        }

    }
}

