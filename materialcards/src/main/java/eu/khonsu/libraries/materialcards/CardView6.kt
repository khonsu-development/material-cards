package eu.khonsu.libraries.materialcards

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageButton
import androidx.annotation.DrawableRes
import androidx.cardview.widget.CardView
import eu.khonsu.libraries.materialcards.extensions.hideIf

/**
 * Media 16:9 and actions.
 *
 * @see [](http://eugenebrusov.com/using-of-constraintlayout-to-build-out-cardview-2-of-3/)
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class CardView6(context: Context, attrs: AttributeSet) : CardView(context, attrs) {

    var actionButton1: ImageButton? = null
    var actionButton2: ImageButton? = null
    var actionButton3: ImageButton? = null

    private fun init(context: Context, attrs: AttributeSet) {
        View.inflate(context, R.layout.card_view_6, this)
        initComponents()
        setAction1Drawable(0)
        setAction2Drawable(0)
        setAction3Drawable(0)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CardView6)
        for (index in 0 until typedArray.indexCount) {
            when (val attr = typedArray.getIndex(index)) {
                R.styleable.CardView6_cv6_action1Drawable -> setAction1Drawable(
                    typedArray.getResourceId(attr, R.drawable.ic_star_outline_white)
                )
                R.styleable.CardView6_cv6_action2Drawable -> setAction2Drawable(
                    typedArray.getResourceId(attr, R.drawable.ic_star_outline_white)
                )
                R.styleable.CardView6_cv6_action3Drawable -> setAction3Drawable(
                    typedArray.getResourceId(attr, R.drawable.ic_star_outline_white)
                )
            }
        }
        typedArray.recycle()
    }

    private fun initComponents() {
        actionButton1 = findViewById(R.id.action_1)
        actionButton2 = findViewById(R.id.action_2)
        actionButton2 = findViewById(R.id.action_3)
    }

    fun getAction1Drawable(): Drawable? = actionButton1?.drawable

    private fun setAction1Drawable(@DrawableRes drawableRes: Int?) {
        actionButton1?.hideIf(drawableRes.toString().isBlank())
        drawableRes?.let { actionButton1?.setImageResource(drawableRes) }
    }

    fun getAction2Drawable(): Drawable? = actionButton2?.drawable

    private fun setAction2Drawable(@DrawableRes drawableRes: Int?) {
        actionButton2?.hideIf(drawableRes.toString().isBlank())
        drawableRes?.let { actionButton2?.setImageResource(drawableRes) }
    }

    fun getAction3Drawable(): Drawable? = actionButton3?.drawable

    private fun setAction3Drawable(@DrawableRes drawableRes: Int?) {
        actionButton3?.hideIf(drawableRes.toString().isBlank())
        drawableRes?.let { actionButton3?.setImageResource(drawableRes) }
    }

    init {
        init(context, attrs)
    }
}
