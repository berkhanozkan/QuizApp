package com.jamijazelabs.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.jamijazelabs.quizapp.ui.QuestionsActivity
import com.jamijazelabs.quizapp.utils.Constants

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startbutton: Button = findViewById(R.id.buttonStart)
        val editTextName: EditText = findViewById(R.id.name)

        startbutton.setOnClickListener {
            if (editTextName.text.isNotEmpty()) {

//                val intent = Intent(this@MainActivity,QuestionsActivity::class.java)
//                startActivity(intent)
                Intent(this@MainActivity, QuestionsActivity::class.java).also {
                    it.putExtra(Constants.USER_NAME, editTextName.text.toString())
                    startActivity(it)
                    finish()
                }
            } else {
                Toast.makeText(this@MainActivity, "Please enter your name", Toast.LENGTH_LONG)
                    .show()
            }
        }

    }
}