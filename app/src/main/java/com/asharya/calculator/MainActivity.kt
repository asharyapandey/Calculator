package com.asharya.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvEquation: TextView
    private lateinit var tvAnswer: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvAnswer= findViewById(R.id.tvAnswer)
        tvEquation= findViewById(R.id.tvEquation)
        val btnOne : Button = findViewById(R.id.btnOne)
        val btnTwo: Button = findViewById(R.id.btnTwo)
        val btnThree: Button = findViewById(R.id.btnThree)
        val btnFour: Button = findViewById(R.id.btnFour)
        val btnFive: Button = findViewById(R.id.btnFive)
        val btnSix: Button = findViewById(R.id.btnSix)
        val btnSeven: Button = findViewById(R.id.btnSeven)
        val btnEight: Button = findViewById(R.id.btnEight)
        val btnNine: Button = findViewById(R.id.btnNine)
    }
}