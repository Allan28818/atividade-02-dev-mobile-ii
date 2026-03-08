package com.example.challenge2

import android.content.Intent
import android.graphics.Color

import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Button

import utils.dynamicColors

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ColorsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_colors_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val linearLayout = findViewById<LinearLayout>(R.id.main)
        val colorIndicator =  findViewById<TextView>(R.id.color_indicator)
        val currentColor = intent.getStringExtra("TARGET_COLOR")


        colorIndicator.text = currentColor

        linearLayout.setBackgroundColor(Color.parseColor(dynamicColors[currentColor]))

        val goBackBtn = findViewById<Button>(R.id.go_back)

        goBackBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}