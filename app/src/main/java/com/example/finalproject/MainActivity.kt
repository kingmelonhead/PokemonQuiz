package com.example.finalproject

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var mediaPlayer : MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mediaPlayer = MediaPlayer.create(this, R.raw.btn_sound)

        startBtn.setOnClickListener(startGame)
    }

    private val startGame = View.OnClickListener {
        mediaPlayer.start()
            start()
    }

    private fun start(){
        intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }
}