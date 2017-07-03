package com.example.kringlan.cardopia.models

val clubs = "Clubs"
val spades = "Spades"
val hearts = "Hearts"
val diamonds = "Diamonds"

val suits = arrayOf(clubs, spades, hearts, diamonds)

fun valueToString(value: Int): String =
    when(value) {
        9 -> "J"
        10 -> "Q"
        11 -> "K"
        12 -> "A"
        else -> "${value + 2}"
    }

class Card(val value: Int, val suit: String) {
    override fun toString(): String {
        return "${valueToString(value)} of $suit"
    }
}