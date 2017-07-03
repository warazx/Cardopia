package com.example.kringlan.cardopia.models

object TheIdiotModel {
    var deck: Deck = Deck()
    var piles = Array(4, { Pile() })

    fun reset() {
        deck = Deck()
        piles = Array(4, { Pile() })
        drawCards()
    }

    fun drawCards() {
        if(!deck.isEmpty()) {
            for (i in 0..piles.size-1) {
                piles[i].addCard(deck.drawCard())
            }
        }
    }

    fun moveCard(pileIndex: Int): Boolean {
        val pile = piles[pileIndex]
        if(pile.cards.size > 0) {
            val card = pile.cards.last()
            for (i in 0..piles.size-1) {
                if (i == pileIndex) continue
                if (piles[i].cards.size > 0) {
                    val compareCard = piles[i].cards.last()
                    if (compareCard.suit == card.suit && card.value < compareCard.value) {
                        pile.removeLastCard()
                        return true
                    }
                }
            }
            val index = piles.indexOf(piles.find { it.cards.size == 0 })
            if (index >= 0) {
                piles[index].addCard(pile.removeLastCard())
                return true
            }
        }
        return false
    }

    override fun toString(): String {
        return "- DrawPile -\n" +
                "$deck" +
                "- Pile 1 -\n" +
                "${piles[0]}" +
                "- Pile 2 -\n" +
                "${piles[1]}" +
                "- Pile 3 -\n" +
                "${piles[2]}" +
                "- Pile 4 -\n" +
                "${piles[3]}"
    }
}