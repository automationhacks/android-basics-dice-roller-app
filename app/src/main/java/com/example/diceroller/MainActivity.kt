package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        // Do a dice roll when the app starts
        rollDice()
    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll image
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImageResource = getDiceImageToDisplay(diceRoll)
        diceImage.setImageResource(diceImageResource)
        // (Accessibility) Set contentDescription to the dice roll to allow screen readers
        // to read it aloud
        diceImage.contentDescription = diceRoll.toString()
    }

    private fun getDiceImageToDisplay(diceRoll: Int): Int {
        return when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
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