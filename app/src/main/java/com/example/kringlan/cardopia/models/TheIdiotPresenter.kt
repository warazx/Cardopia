import com.example.kringlan.cardopia.models.TheIdiotView
import com.example.kringlan.cardopia.models.TheIdiotModel

object TheIdiotPresenter {
    var view: TheIdiotView? = null

    fun setGameView(theIdiotView: TheIdiotView) {
        view = theIdiotView
    }

    fun onDeckTap() {
        TheIdiotModel.drawCards()
        view?.update()
    }

    fun onFoundationTap(foundationIndex: Int) {
        TheIdiotModel.moveCard(foundationIndex)
        view?.update()
    }
}