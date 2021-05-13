package com.example.finalproject

import androidx.lifecycle.ViewModel

class ResultViewModel : ViewModel() {
    lateinit var answers : Array<ResultContainer>
    val questions : Array<Question> = arrayOf(
        Question("What year did the original pokemon anime series air?", arrayOf("2002", "1998", "1997", "2000"), 3),
        Question("What is the iconic character that always appears to have his eyes closed?", arrayOf("Ash", "Brock", "Misty", "Professor Oak"), 2),
        Question("In the original pokemon anime, what was the first gym leader that Ash had to fight?", arrayOf("Misty", "Brock", "Pikachu", "James"), 2),
        Question("What region does the game pokemon sword and shield take place in?", arrayOf("Galar", "Kantoh", "Sinoh", "Alola"), 1),
        Question("What nintendo console are the heart gold and soul silver pokemon games on?", arrayOf("PS2", "Wii", "3DS", "DS"), 4),
        Question("What is the nintendo 64 pokemon game that came bundled with a mic to talk communicate with pokemon in game?", arrayOf("Lets go eevee", "Lets go Pikachu", "Hey Pikachu", "Pokemon Snap"), 3),
        Question("What was the pokemon fighting game that originally released on the wii u?", arrayOf("Pokemon Sword and shield", "Pokemon Colosseum", "Pokemon Stadium", "Poken Tournement"), 4),
        Question("Which pokemon game(s) received a loss of points in a review for 'having too much water'?", arrayOf("Ruby and Sapphire", "Red and Blue", "Crystal", "Lets go eevee"), 1),
        Question("What is the dungeon crawling spin off pokemon game series that started on the Gameboy Advance", arrayOf("Pokemon Dungeons", "Mystery Dungeon", "Pokemon Go", "Pokemon Gale of Darkness"), 2),
        Question("What were the first pokemon games released in the US?", arrayOf("Black and White", "Emerald and Diamond", "Purple and Green", "Red and Blue"), 4)
    )

}