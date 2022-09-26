package com.learning.thebignumberapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val leftBtn = findViewById<Button>(R.id.leftBtn)
        val rightBtn = findViewById<Button>(R.id.rightBtn)
        generateNewNumber()

        leftBtn.setOnClickListener {
            checkAnswer(true)
            generateNewNumber()
        }
        rightBtn.setOnClickListener {
            checkAnswer(false)
            generateNewNumber()
        }


    }

    private fun checkAnswer(isLeftButtonSelected: Boolean) {
        val leftBtn = findViewById<Button>(R.id.leftBtn)
        val rightBtn = findViewById<Button>(R.id.rightBtn)
        val numLeft = leftBtn.text.toString().toInt()
        val numRight = rightBtn.text.toString().toInt()
        val layoutParent = findViewById<View>(R.id.layoutParent)

        val isAnswerCorrect = if (isLeftButtonSelected) numLeft > numRight else numRight > numLeft
        if (isAnswerCorrect) {
            layoutParent.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "Correct Answer", Toast.LENGTH_SHORT).show()
        } else {
            layoutParent.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show()
        }
    }

    private fun generateNewNumber() {

        val leftBtn = findViewById<Button>(R.id.leftBtn)
        val rightBtn = findViewById<Button>(R.id.rightBtn)

        var leftNum: Int
        val rightNum = (0..10).random()
        leftNum = rightNum
        while (leftNum == rightNum) {
            leftNum = (0..10).random()
        }
        leftBtn.text = leftNum.toString()
        rightBtn.text = rightNum.toString()
    }
}