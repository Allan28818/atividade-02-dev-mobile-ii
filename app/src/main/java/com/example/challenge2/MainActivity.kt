package com.example.challenge2

import android.content.Intent
import android.widget.EditText
import android.widget.Button
import android.widget.TextView

import utils.dynamicColors

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val colorInput = findViewById<EditText>(R.id.color_input)
        val colorButton = findViewById<Button>(R.id.color_btn)
        val warnTextView = findViewById<TextView>(R.id.warns)

        colorButton.setOnClickListener {
            val inputText = colorInput.text.toString()

            if (inputText.isBlank()) {
                warnTextView.text = "Preencha com um nome de cor"
            } else if (!dynamicColors.containsKey(inputText)) {
                warnTextView.text = "Cor não é válida"
            }
            else {
                warnTextView.text = ""
                handleVisualize(inputText)
            }
        }
    }

    fun handleVisualize(color: String?) {
        val treatedColor = color?.lowercase()

        val intent = Intent(this, ColorsScreen::class.java)

        intent.putExtra("TARGET_COLOR", treatedColor)

        startActivity(intent)
    }
}