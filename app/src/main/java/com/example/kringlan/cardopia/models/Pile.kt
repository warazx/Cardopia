package com.example.kringlan.cardopia.models

class Pile {
    val cards: MutableList<Card> = mutableListOf()

    fun addCard(card: Card) {
        cards.add(card)
    }

    fun removeLastCard(): Card {
        return cards.removeAt(cards.size-1)
    }

    override fun toString(): String {
        var string = ""
        cards.forEachIndexed { i, card -> string += "${i+1}: $card\n" }
        return string
    }
}