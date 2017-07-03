package com.example.kringlan.cardopia.models

import java.util.*

class Deck {
    val cards = Array(52, { Card(it / 4, getSuit(it % 4)) })
    var cardsInDeck: MutableList<Card> = cards.toMutableList()

    init {
        Collections.shuffle(cardsInDeck)
    }

    fun drawCard(): Card = cardsInDeck.removeAt(0)

    fun isEmpty(): Boolean = cardsInDeck.size == 0

    private fun getSuit(i: Int): String = suits[i % 4]

    override fun toString(): String {
        var string = ""
        cardsInDeck.forEachIndexed { i, card -> string += "${i+1}: $card\n" }
        return string
    }
}