package com.example.kringlan.cardopia.views

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import com.example.kringlan.cardopia.models.TheIdiotModel
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

class DrawPileView(context: Context) : ImageView(context) {
    init {
        imageResource = cardback
        onClick {
            TheIdiotPresenter.onDeckTap()
        }
    }

    fun update() {
        imageResource = if (TheIdiotModel.deck.cardsInDeck.isEmpty()) emptyCardback else cardback
    }
}

fun ViewManager.drawPileView(init: DrawPileView.() -> Unit = {}) =
        ankoView({ DrawPileView(it) }, 0, init)