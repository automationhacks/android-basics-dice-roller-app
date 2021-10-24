package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows users to roll a dice and view the result on the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        // Set a click listener on the button to roll the dice when user taps the button
        rollButton.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val firstDiceRoll = dice.roll().toString()
        val secondDiceRoll = dice.roll().toString()

        // Update the screen with the dice roll
        val firstDiceTextView: TextView = findViewById(R.id.txtViewFirst)
        firstDiceTextView.text = firstDiceRoll

        // Update the screen for the second dice roll
        val secondDiceTextView: TextView = findViewById(R.id.txtViewSecond)
        secondDiceTextView.text = secondDiceRoll
    }
}

/**
 * Dice with fixed no of sides
 */
class Dice(private val numSides: Int) {
    // Generates a random dice roll
    fun roll(): Int {
        return (1..numSides).random()
    }
}