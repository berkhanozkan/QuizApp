package com.jamijazelabs.quizapp.utils

import com.jamijazelabs.quizapp.R
import com.jamijazelabs.quizapp.model.Question

object Constants {
    fun getQuestions(): MutableList<Question> {
        val questions = mutableListOf<Question>(
            Question(
                1,
                "What country does this flag belong?",
                R.drawable.argentina_flag,
                "Italy",
                "Argentina",
                "Iran",
                "Ireland",
                2
            ),
            Question(
                2,
                "What country does this flag belong?",
                R.drawable.brazil_flag,
                "Brazil",
                "Argentina",
                "Spain",
                "Mexico",
                1
            ),
            Question(
                3,
                "What country is known for its education system and the Northern Lights?",
                R.drawable.finland_flag,
                "Italy",
                "Finland",
                "Sweden",
                "Norway",
                2
            ),
            Question(
                4,
                "What country is renowned for its Eiffel Tower and delicious cuisine?",
                R.drawable.france_flag,
                "Italy",
                "France",
                "Spain",
                "Greece",
                2
            ),
            Question(
                5,
                "Which European country is famous for its engineering prowess and the Autobahn?",
                R.drawable.germany_flag,
                "Germany",
                "Brazil",
                "Italy",
                "Austria",
                1
            ),
            Question(
                6,
                "What country shares the island of Hispaniola with the Dominican Republic?",
                R.drawable.haiti_flag,
                "Haiti",
                "Cuba",
                "Jamaica",
                "Puerto Rico",
                1
            ),
            Question(
                7,
                "What country is known for the Taj Mahal and a diverse culture?",
                R.drawable.india_flag,
                "Russia",
                "India",
                "China",
                "Pakistan",
                2
            ),
            Question(
                8,
                "What country is famous for its Roman history and delicious pasta?",
                R.drawable.italy_flag,
                "Greece",
                "Italy",
                "Portugal",
                "Spain",
                2
            ),
            Question(
                9,
                "What country is the most populous in Africa and known for its diverse culture?",
                R.drawable.nigeria_flag,
                "Kenya",
                "Egypt",
                "Nigeria",
                "South Africa",
                3
            ),
            Question(
                10,
                "What country is located in Eastern Europe and is famous for its Dracula legend?",
                R.drawable.romania_flag,
                "Hungary",
                "Czech Republic",
                "Romania",
                "Poland",
                3
            ),
            Question(
                11,
                "What country is known for its vibrant culture, Flamenco dance, and beautiful beaches?",
                R.drawable.spain_flag,
                "Italy",
                "France",
                "Spain",
                "Greece",
                3
            )
        )


        return questions
    }
}