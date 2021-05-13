package com.example.finalproject

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private lateinit var viewModel: GameViewModel
    lateinit var mediaPlayer : MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        mediaPlayer = MediaPlayer.create(this, R.raw.btn_sound)

        //setup link to view model
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        //setup link to buttons
        button1.setOnClickListener(buttonOneListener)
        button2.setOnClickListener(buttonTwoListener)
        button3.setOnClickListener(buttonThreeListener)
        button4.setOnClickListener(buttonFourListener)

        displayQuestion()

    }

    private val buttonOneListener = View.OnClickListener {
        if (viewModel.ready() && !mediaPlayer.isPlaying){

            mediaPlayer.start()
            onPressOne()
        }

    }
    private val buttonTwoListener = View.OnClickListener {
        if (viewModel.ready() && !mediaPlayer.isPlaying) {

            mediaPlayer.start()
            onPressTwo()
        }
    }
    private val buttonThreeListener = View.OnClickListener {
        if (viewModel.ready() && !mediaPlayer.isPlaying){

            mediaPlayer.start()
            onPressThree()
        }
    }
    private val buttonFourListener = View.OnClickListener {
        if (viewModel.ready() && !mediaPlayer.isPlaying) {

            mediaPlayer.start()
            onPressFour()
        }
    }

    private fun displayQuestion(){
        val temp = viewModel.getQuestion()
        questionView.text = temp.question
        button1.text = temp.options[0]
        button2.text = temp.options[1]
        button3.text = temp.options[2]
        button4.text = temp.options[3]
    }
    private fun onPressOne(){
        //call view model check answer function with ans 1
        viewModel.checkAnswer(1)
        val temp = viewModel.getQuestionNo()
        if (temp == 10){
            goToResults()
        }
        displayQuestion() // display the next question
    }
    private fun onPressTwo(){
        //call view model check answer function with ans 2
        viewModel.checkAnswer(2)
        val temp = viewModel.getQuestionNo()
        if (temp == 10){
            goToResults()
        }
        displayQuestion()
    }
    private fun onPressThree(){
        //call view model check answer function with ans 3
        viewModel.checkAnswer(3)
        val temp = viewModel.getQuestionNo()
        if (temp == 10){
            goToResults()
        }
        displayQuestion()
    }
    private fun onPressFour(){
        //call view model check answer function with ans 4
        viewModel.checkAnswer(4)
        val temp = viewModel.getQuestionNo()
        if (temp == 10){
            goToResults()
        }
        displayQuestion()
    }
    private fun goToResults(){
        val score = viewModel.getScore()
        val temp = viewModel.getAnswers()
        intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("Score", score)
        intent.putExtra("Data", temp)
        startActivity(intent)
    }
}