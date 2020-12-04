package com.asharya.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvEquation: TextView
    private lateinit var tvAnswer: TextView
    private var numberOne = ""
    private var expression = ""
    private var numberTwo = ""
    private var finalExpression = ""
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
        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnMultiply: Button = findViewById(R.id.btnMultiply)
        val btnDivide: Button = findViewById(R.id.btnDivide)
        val btnSubtract: Button = findViewById(R.id.btnSubtract)
        val btnEquals: Button = findViewById(R.id.btnEquals)
        val btnClear: Button = findViewById(R.id.btnClear)

        val buttons = mutableListOf<Button>(btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnAdd, btnSubtract, btnDivide, btnMultiply)

        for(button in buttons) {
            button.setOnClickListener {
                set(button.text.toString())
            }
        }

        btnEquals.setOnClickListener {
            calculate()
        }

        btnClear.setOnClickListener {
            reset()
        }
    }

    private fun reset() {
        // resets all the values
        finalExpression  = ""
        expression = ""
        numberTwo = ""
        numberOne = ""
        tvEquation.text = "0"
        tvAnswer.text = "0"
    }

    private fun set(text: String) {
        if (finalExpression != "") {
            reset()
        }
        when(text) {
            "+", "-", "*","/", "%" -> {
                expression = text
                tvAnswer.text = "$numberOne $expression"
            }
            else -> {
               if (expression == "") {
                   numberOne += text
                   tvAnswer.text = numberOne
               } else {
                   numberTwo += text
                   tvAnswer.text = "$numberOne $expression $numberTwo"
               }

            }
        }
    }
    private fun calculate() {
        finalExpression = "$numberOne $expression $numberTwo"
        tvEquation.text = finalExpression
        val result = when(expression) {
            "+" -> numberOne.toInt() + numberTwo.toInt()
            "-" -> numberOne.toInt() - numberTwo.toInt()
            "*" -> numberOne.toInt() * numberTwo.toInt()
            "%" -> numberOne.toInt() / numberTwo.toInt()
            else -> ""
        }
        tvAnswer.text = result.toString()
    }
}