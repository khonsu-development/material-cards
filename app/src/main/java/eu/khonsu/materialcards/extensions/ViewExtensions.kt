package eu.khonsu.materialcards.extensions

import android.view.View

fun View?.show(): View? {
    this?.visibility = View.VISIBLE
    return this
}

fun View?.hide(): View? {
    this?.visibility = View.GONE
    return this
}

fun View?.hideIf(condition: Boolean?): View? {
    if (condition == null) {
        this?.hide()
    } else {
        if (condition) this.hide() else this.show()
    }
    return this
}
