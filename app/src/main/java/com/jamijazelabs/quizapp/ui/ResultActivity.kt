package com.jamijazelabs.quizapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.jamijazelabs.quizapp.MainActivity
import com.jamijazelabs.quizapp.R
import com.jamijazelabs.quizapp.utils.Constants
import kotlin.properties.Delegates

class ResultActivity : AppCompatActivity() {

    private lateinit var textViewResult: TextView
    private lateinit var scoree: String
    private lateinit var totalQuestion: String
    private lateinit var name: String
    private lateinit var finishButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textViewResult = findViewById(R.id.txtresult)
        finishButton = findViewById(R.id.finish_button)
        scoree = intent.getIntExtra(Constants.SCORE, 0).toString()
        totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0).toString()
        name = intent.getStringExtra(Constants.USER_NAME)!!

        textViewResult.text = "$name, Your score is $scoree/$totalQuestion"

        finishButton.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }


    }
}