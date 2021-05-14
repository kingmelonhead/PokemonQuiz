package com.example.finalproject


import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var growAnim : Animation
    lateinit var mediaPlayer : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaPlayer = MediaPlayer.create(this, R.raw.btn_sound)

        startBtn.setOnClickListener(startGame)

        val animFadeIn: Animation = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
        growAnim = AnimationUtils.loadAnimation(applicationContext, R.anim.grow)
        startBtn.startAnimation(animFadeIn)
        titleText.startAnimation(animFadeIn)
        info.startAnimation(animFadeIn)
    }

    private val startGame = View.OnClickListener {
        mediaPlayer.start()
        startBtn.startAnimation(growAnim)
            start()
    }

    private fun start(){
        intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
}