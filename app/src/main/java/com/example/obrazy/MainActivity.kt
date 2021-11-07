package com.example.obrazy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val CheckWidok: CheckBox =findViewById(R.id.CheckWidoczny);
        val Obrazek: ImageView =findViewById(R.id.Obrazek);

        CheckWidok.setOnClickListener(){
            if(CheckWidok.isChecked()){
                Obrazek.setVisibility(View.INVISIBLE);
            }else{
                Obrazek.setVisibility(View.VISIBLE);
            }
        }

    }
}