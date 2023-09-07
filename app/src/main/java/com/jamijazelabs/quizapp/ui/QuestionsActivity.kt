package com.jamijazelabs.quizapp.ui

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.jamijazelabs.quizapp.R
import com.jamijazelabs.quizapp.model.Question
import com.jamijazelabs.quizapp.utils.Constants
import org.w3c.dom.Text

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var progressBar: ProgressBar
    private lateinit var textViewProgress: TextView
    private lateinit var textViewQuestion: TextView
    private lateinit var flagImage: ImageView

    private lateinit var textViewOption1: TextView
    private lateinit var textViewOption2: TextView
    private lateinit var textViewOption3: TextView
    private lateinit var textViewOption4: TextView

    private lateinit var checkButton: Button

    private val questionsCounter = 0
    private lateinit var questionList: MutableList<Question>
    private var selectedAnswer = 0
    private lateinit var currentPosition: Question
    private var answered = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        progressBar = findViewById(R.id.progress_bar)
        textViewProgress = findViewById(R.id.text_view_progress)
        textViewQuestion = findViewById(R.id.question_text)
        flagImage = findViewById(R.id.image_flag)
        checkButton = findViewById(R.id.check_button)
        textViewOption1 = findViewById(R.id.option_one_text)
        textViewOption2 = findViewById(R.id.option_two_text)
        textViewOption3 = findViewById(R.id.option_three_text)
        textViewOption4 = findViewById(R.id.option_four_text)


        textViewOption1.setOnClickListener(this)
        textViewOption2.setOnClickListener(this)
        textViewOption3.setOnClickListener(this)
        textViewOption4.setOnClickListener(this)
        checkButton.setOnClickListener(this)

        questionList = Constants.getQuestions()
        Log.d("Size.", questionList.size.toString())

        setQuestion()


    }

    private fun setQuestion() {
        val question = questionList[questionsCounter - 1]
        flagImage.setImageResource(question.image)
        progressBar.progress = questionsCounter
        textViewProgress.text = "${questionsCounter + 1}/${progressBar.max}"
        textViewQuestion.text = question.question
        textViewOption1.text = question.optionOne
        textViewOption2.text = question.optionTwo
        textViewOption3.text = question.optionThree
        textViewOption4.text = question.optionFour

        if (questionsCounter == questionList.size) {
            checkButton.text = "FINISH"
        } else {
            checkButton.text = "CHECK"
        }
    }

    private fun resetOptions() {
        val options = mutableListOf<TextView>()
        options.add(textViewOption1)
        options.add(textViewOption2)
        options.add(textViewOption3)
        options.add(textViewOption4)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }


    private fun selectedOption(textView: TextView, selectedOptionNumber: Int) {
        resetOptions()

        textView.setTextColor(Color.parseColor("#363a43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.option_one_text -> {
                selectedOption(textViewOption1, 1)
            }

            R.id.option_two_text -> {
                selectedOption(textViewOption2, 2)
            }

            R.id.option_three_text -> {
                selectedOption(textViewOption3, 3)
            }

            R.id.option_four_text -> {
                selectedOption(textViewOption4, 4)
            }

            R.id.check_button -> {
                // Todo
            }
        }
    }


}