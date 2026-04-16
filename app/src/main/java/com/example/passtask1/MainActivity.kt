package com.example.passtask1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var playerOneScore : Int = 0
    var playerTwoScore : Int = 0

    override fun onStart(){
        super.onStart()
        Log.i("LIFECYCLE","onStart")
        val playerOneDisplay = findViewById<TextView>(R.id.playerOneDisplay)
        val playerTwoDisplay = findViewById<TextView>(R.id.playerTwoDisplay)

        playerOneDisplay.text = playerOneScore.toString()
        playerTwoDisplay.text = playerTwoScore.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("LIFECYCLE","onCreate")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val playerOneButton = findViewById<Button>(R.id.playerOneButton)
        val playerTwoButton = findViewById<Button>(R.id.playerTwoButton)
        val resetButton = findViewById<Button>(R.id.resetButton)

        val playerOneDisplay = findViewById<TextView>(R.id.playerOneDisplay)
        val playerTwoDisplay = findViewById<TextView>(R.id.playerTwoDisplay)

        playerOneButton.setOnClickListener{
            playerOneScore ++
            playerOneDisplay.text = playerOneScore.toString()
        }
        playerTwoButton.setOnClickListener{
            playerTwoScore ++
            playerTwoDisplay.text = playerTwoScore.toString()
        }
        resetButton.setOnClickListener{
            playerTwoScore = 0
            playerOneScore = 0
            playerOneDisplay.text = playerOneScore.toString()
            playerTwoDisplay.text = playerTwoScore.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)
        outState.putInt("PLAYER1",playerOneScore)
        outState.putInt("PLAYER2",playerTwoScore)
        Log.i("LIFECYCLE","onSaveInstanceState P1 $playerOneScore")
        Log.i("LIFECYCLE","onSaveInstanceState P2 $playerTwoScore")
    }

    override fun onRestoreInstanceState(inState: Bundle){
        super.onRestoreInstanceState(inState)
        playerOneScore = inState.getInt("PLAYER1")
        playerTwoScore = inState.getInt("PLAYER2")
        Log.i("LIFECYCLE","onRestoreInstanceState P1 $playerOneScore")
        Log.i("LIFECYCLE","onRestoreInstanceState P2 $playerTwoScore")

        val playerOneDisplay = findViewById<TextView>(R.id.playerOneDisplay)
        val playerTwoDisplay = findViewById<TextView>(R.id.playerTwoDisplay)

        playerOneDisplay.text = playerOneScore.toString()
        playerTwoDisplay.text = playerTwoScore.toString()
    }
}