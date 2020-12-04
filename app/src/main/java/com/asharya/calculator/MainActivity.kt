package com.asharya.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tvEquation: TextView
    private lateinit var tvAnswer: TextView
    private var numberOne = ""
    private var operator = ""
    private var numberTwo = ""
    private var finalExpression = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvAnswer = findViewById(R.id.tvAnswer)
        tvEquation = findViewById(R.id.tvEquation)
        val btnOne: Button = findViewById(R.id.btnOne)
        val btnTwo: Button = findViewById(R.id.btnTwo)
        val btnThree: Button = findViewById(R.id.btnThree)
        val btnFour: Button = findViewById(R.id.btnFour)
        val btnFive: Button = findViewById(R.id.btnFive)
        val btnSix: Button = findViewById(R.id.btnSix)
        val btnSeven: Button = findViewById(R.id.btnSeven)
        val btnEight: Button = findViewById(R.id.btnEight)
        val btnZero: Button = findViewById(R.id.btnZero)
        val btnNine: Button = findViewById(R.id.btnNine)
        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnMultiply: Button = findViewById(R.id.btnMultiply)
        val btnDivide: Button = findViewById(R.id.btnDivide)
        val btnSubtract: Button = findViewById(R.id.btnSubtract)
        val btnEquals: Button = findViewById(R.id.btnEquals)
        val btnClear: Button = findViewById(R.id.btnClear)

        val buttons = mutableListOf<Button>(
            btnOne,
            btnTwo,
            btnThree,
            btnFour,
            btnFive,
            btnSix,
            btnSeven,
            btnEight,
            btnNine,
            btnZero,
            btnAdd,
            btnSubtract,
            btnDivide,
            btnMultiply
        )

        for (button in buttons) {
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
        finalExpression = ""
        operator = ""
        numberTwo = ""
        numberOne = ""
        tvEquation.text = "0"
        tvAnswer.text = "0"
    }

    private fun set(text: String) {
        // to reset if the button is clicked after calculation
        if (finalExpression != "") {
            reset()
        }
        when (text) {
            "+", "-", "*", "/", "%" -> {
                operator = text
                tvAnswer.text = "$numberOne $operator"
            }
            else -> {
                if (operator == "") {
                    numberOne += text
                    tvAnswer.text = numberOne
                } else {
                    numberTwo += text
                    tvAnswer.text = "$numberOne $operator $numberTwo"
                }

            }
        }
    }

    private fun calculate() {
        finalExpression = "$numberOne $operator $numberTwo"
        tvEquation.text = finalExpression
        val result = when (operator) {
            "+" -> numberOne.toInt() + numberTwo.toInt()
            "-" -> numberOne.toInt() - numberTwo.toInt()
            "*" -> numberOne.toInt() * numberTwo.toInt()
            "%" -> numberOne.toInt() / numberTwo.toInt()
            else -> ""
        }
        tvAnswer.text = result.toString()
    }
}