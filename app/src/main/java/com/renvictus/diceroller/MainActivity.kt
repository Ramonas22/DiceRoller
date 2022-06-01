package com.renvictus.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        //Create a new dice with 6 sides and roll it
        val dice = Dice(1,6)
        val diceRoll = dice.roll()
        val diceRoll2 = dice.roll()

        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)



        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(dice.imageUpdate(diceRoll))
        diceImage2.setImageResource(dice.imageUpdate(diceRoll2))

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        diceImage2.contentDescription = diceRoll2.toString()
    }
}

class Dice(private val numOfDices: Int , private val numSides: Int) {
    /**
     * Roll the dice and update the screen with the result.
     */
    fun roll(): Int {
        return (numOfDices..numOfDices*numSides).random()
    }

   fun imageUpdate(diceRoll: Int): Int {
       // Determine which drawable resource ID to use based on the dice roll
       val drawableResource = when (diceRoll){
           1 -> R.drawable.dice_1
           2 -> R.drawable.dice_2
           3 -> R.drawable.dice_3
           4 -> R.drawable.dice_4
           5 -> R.drawable.dice_5
           else -> R.drawable.dice_6
       }
       return drawableResource
    }
}
