package com.example.kringlan.cardopia.views

import android.content.Context
import android.view.ViewManager
import com.example.kringlan.cardopia.models.TheIdiotModel
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView

class FoundationPileView(context: Context, val index: Int) : _RelativeLayout(context) {
    init {
        addViews()
    }

    fun update() {
        removeAllViews()
        addViews()
    }

    private fun addViews() {
        val cards = TheIdiotModel.piles[index].cards
        cards.forEachIndexed { i, card ->
            imageView {
                y = (i * dip(25)).toFloat()
                imageResource = getResIdForCard(card)
                onClick {
                    TheIdiotPresenter.onFoundationTap(index)
                }
            }.lparams(context.cardWidth, context.cardHeight)
        }
    }
}

fun ViewManager.foundationPileView(index: Int, init: FoundationPileView.() -> Unit = {}) =
        ankoView({ FoundationPileView(it, index) }, 0, init)