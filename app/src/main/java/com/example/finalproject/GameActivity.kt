package com.example.finalproject

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*

class GameActivity : AppCompatActivity() {

    private lateinit var viewModel: GameViewModel
    lateinit var mediaPlayer : MediaPlayer
    lateinit var growAnim : Animation


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

        growAnim= AnimationUtils.loadAnimation(applicationContext, R.anim.grow)


        displayQuestion()

    }

    private val buttonOneListener = View.OnClickListener {
        if (viewModel.isReady) {
            viewModel.isReady = false
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                mediaPlayer.seekTo(0)
            }
            mediaPlayer.start()
            button1.startAnimation(growAnim)
            onPress(1)
        }
    }
    private val buttonTwoListener = View.OnClickListener {
        if (viewModel.isReady) {
            viewModel.isReady = false
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                mediaPlayer.seekTo(0)
            }
            mediaPlayer.start()
            button2.startAnimation(growAnim)
            onPress(2)
        }
    }
    private val buttonThreeListener = View.OnClickListener {
        if (viewModel.isReady) {
            viewModel.isReady = false
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                mediaPlayer.seekTo(0)
            }
            mediaPlayer.start()
            button3.startAnimation(growAnim)
            onPress(3)
        }
    }
    private val buttonFourListener = View.OnClickListener {
        if (viewModel.isReady) {
            viewModel.isReady = false
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                mediaPlayer.seekTo(0)
            }
            mediaPlayer.start()
            button4.startAnimation(growAnim)
            onPress(4)
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
    private fun onPress(i : Int){
        //call view model check answer function with ans 1
        if (viewModel.checkAnswer(i) == -1){
            goToResults()
        }
        else {
            displayQuestion() // display the next question
        }
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