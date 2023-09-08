package com.jamijazelabs.quizapp.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.jamijazelabs.quizapp.R
import com.jamijazelabs.quizapp.model.Question
import com.jamijazelabs.quizapp.utils.Constants

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

    private var questionsCounter = 0
    private lateinit var questionList: MutableList<Question>
    private var selectedAnswer = 0
    private lateinit var currentQuestion: Question
    private var answered = false
    private var score = 0

    private lateinit var userName: String
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

        showNextQuestion()
        if (intent.hasExtra(Constants.USER_NAME)) {
            userName = intent.getStringExtra(Constants.USER_NAME)!!
        }

    }

    private fun showNextQuestion() {


        if (questionsCounter < questionList.size) {
            checkButton.text = "CHECK"
            currentQuestion = questionList[questionsCounter]

            val question = questionList[questionsCounter]
            flagImage.setImageResource(question.image)
            progressBar.progress = questionsCounter
            textViewProgress.text = "${questionsCounter + 1}/${progressBar.max}"
            textViewQuestion.text = question.question
            textViewOption1.text = question.optionOne
            textViewOption2.text = question.optionTwo
            textViewOption3.text = question.optionThree
            textViewOption4.text = question.optionFour
        } else {
            checkButton.text = "FINISH"
            Intent(this, ResultActivity::class.java).also {
                it.putExtra(Constants.USER_NAME, userName)
                it.putExtra(Constants.SCORE, score)
                it.putExtra(Constants.TOTAL_QUESTIONS, questionList.size)
                startActivity(it)
            }
        }

        questionsCounter++
        answered = false

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
                this, R.drawable.default_option_border_bg
            )
        }
    }


    private fun selectedOption(textView: TextView, selectedOptionNumber: Int) {
        resetOptions()

        textView.setTextColor(Color.parseColor("#363a43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)

        selectedAnswer = selectedOptionNumber;
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
                if (!answered) {
                    checkAnswer()
                } else {
                    resetOptions()
                    showNextQuestion()
                }

            }
        }
    }

    private fun checkAnswer() {
        answered = true
        if (selectedAnswer == currentQuestion.correctAnswer) {
            score++
            highlightAnswer(selectedAnswer, true)
        } else {
            highlightAnswer(selectedAnswer, false)
        }

        checkButton.text = "NEXT"
        showSolution()
        selectedAnswer = 0
    }

    private fun showSolution() {
        selectedAnswer = currentQuestion.correctAnswer
        highlightAnswer(selectedAnswer, true)
    }

    private fun highlightAnswer(answer: Int, isCorrect: Boolean) {
        when (answer) {
            1 -> {
                textViewOption1.background = ContextCompat.getDrawable(
                    this,
                    if (isCorrect) R.drawable.correct_option_border else R.drawable.wrong_option_border
                )
                textViewOption1.setTextColor(Color.WHITE)
            }

            2 -> {
                textViewOption2.background = ContextCompat.getDrawable(
                    this,
                    if (isCorrect) R.drawable.correct_option_border else R.drawable.wrong_option_border
                )
                textViewOption2.setTextColor(Color.WHITE)
            }

            3 -> {
                textViewOption3.background = ContextCompat.getDrawable(
                    this,
                    if (isCorrect) R.drawable.correct_option_border else R.drawable.wrong_option_border
                )
                textViewOption3.setTextColor(Color.WHITE)
            }

            4 -> {
                textViewOption4.background = ContextCompat.getDrawable(
                    this,
                    if (isCorrect) R.drawable.correct_option_border else R.drawable.wrong_option_border
                )
                textViewOption4.setTextColor(Color.WHITE)
            }
        }
    }
}