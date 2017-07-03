package com.example.kringlan.cardopia.views

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.kringlan.cardopia.R
import com.example.kringlan.cardopia.models.Card
import com.example.kringlan.cardopia.models.TheIdiotView
import com.example.kringlan.cardopia.models.TheIdiotModel
import com.example.kringlan.cardopia.models.valueToString
import org.jetbrains.anko.*

val Context.cardWidth: Int
    get() = (displayMetrics.widthPixels - dip(8)) / 5
val Context.cardHeight: Int
    get() = cardWidth * 190 / 140

val cardback = R.drawable.cardback_blue1
val emptyCardback = R.drawable.cardback_red5

fun View.getResIdForCard(card: Card): Int {
    val resourceName = "card${card.suit}${valueToString(card.value)}".toLowerCase()
    return context.resources.getIdentifier(resourceName, "drawable", context.packageName)
}

class MainActivity : AppCompatActivity(), TheIdiotView {

    var drawPileView: DrawPileView? = null
    var foundationPileViews: Array<FoundationPileView?> = arrayOfNulls(4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        TheIdiotPresenter.setGameView(this)
        TheIdiotModel.reset()

        verticalLayout {
            leftPadding = dip(4)
            rightPadding = dip(4)
            topPadding = dip(8)

            linearLayout {
                drawPileView = drawPileView().lparams(cardWidth, cardHeight)
                for (i in 0..3) {
                    foundationPileViews[i] = foundationPileView(i).lparams(cardWidth, matchParent)
                }
            }.lparams(height = matchParent)
        }


    }

    override fun update() {
        drawPileView!!.update()
        for (i in 0..3) {
            foundationPileViews[i]!!.update()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add("Start Over")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        TheIdiotModel.reset()
        update()
        return true
    }
}
