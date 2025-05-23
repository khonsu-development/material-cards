package eu.khonsu.libraries.materialcards

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import androidx.core.widget.ImageViewCompat
import eu.khonsu.libraries.materialcards.extensions.hideIf

/**
 * Media 16:9 and actions.
 *
 * @see [](http://eugenebrusov.com/using-of-constraintlayout-to-build-out-cardview-2-of-3/)
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class CardView6(
    context: Context,
    attrs: AttributeSet,
) : CardView(context, attrs) {
    var constraintLayout: ConstraintLayout? = null
    var image: ImageView? = null
    var actionButton1: ImageButton? = null
    var actionButton2: ImageButton? = null
    var actionButton3: ImageButton? = null

    private fun init(
        context: Context,
        attrs: AttributeSet,
    ) {
        View.inflate(context, R.layout.card_view_6, this)
        initComponents()
        setActionButton1Drawable(0)
        setActionButton2Drawable(0)
        setActionButton3Drawable(0)
        context.withStyledAttributes(attrs, R.styleable.CardView6) {
            for (index in 0 until indexCount) {
                when (val attr = getIndex(index)) {
                    R.styleable.CardView6_cv6_srcImage ->
                        setImageSrc(
                            getResourceId(attr, R.drawable.background_image),
                        )

                    R.styleable.CardView6_cv6_srcImageTint ->
                        setImageSrcTint(
                            getResourceId(attr, android.R.attr.colorControlHighlight),
                        )

                    R.styleable.CardView6_cv6_action1Drawable ->
                        setActionButton1Drawable(
                            getResourceId(attr, R.drawable.ic_star_outline),
                        )

                    R.styleable.CardView6_cv6_action2Drawable ->
                        setActionButton2Drawable(
                            getResourceId(attr, R.drawable.ic_star_outline),
                        )

                    R.styleable.CardView6_cv6_action3Drawable ->
                        setActionButton3Drawable(
                            getResourceId(attr, R.drawable.ic_star_outline),
                        )
                }
            }
        }
    }

    private fun initComponents() {
        constraintLayout = findViewById(R.id.constraint_layout)
        image = findViewById(R.id.image)
        actionButton1 = findViewById(R.id.action_button_1)
        actionButton2 = findViewById(R.id.action_button_2)
        actionButton3 = findViewById(R.id.action_button_3)
    }

    fun getImageSrc(): Drawable? = image?.drawable

    fun setImageSrc(
        @DrawableRes value: Int,
    ) {
        image?.setImageResource(value)
    }

    fun getImageSrcTint(): ColorStateList? = image?.imageTintList

    fun setImageSrcTint(
        @ColorRes tintRes: Int?,
    ) {
        tintRes?.let {
            image?.let { imageView ->
                ImageViewCompat.setImageTintList(
                    imageView,
                    ColorStateList.valueOf(ContextCompat.getColor(context, tintRes)),
                )
            }
        }
    }

    fun getActionButton1Drawable(): Drawable? = actionButton1?.drawable

    private fun setActionButton1Drawable(
        @DrawableRes drawableRes: Int?,
    ) {
        actionButton1?.hideIf(drawableRes == null || drawableRes.toString().isBlank())
        drawableRes?.let { actionButton1?.setImageResource(drawableRes) }
    }

    fun getActionButton2Drawable(): Drawable? = actionButton2?.drawable

    private fun setActionButton2Drawable(
        @DrawableRes drawableRes: Int?,
    ) {
        actionButton2?.hideIf(drawableRes == null || drawableRes.toString().isBlank())
        drawableRes?.let { actionButton2?.setImageResource(drawableRes) }
    }

    fun getActionButton3Drawable(): Drawable? = actionButton3?.drawable

    private fun setActionButton3Drawable(
        @DrawableRes drawableRes: Int?,
    ) {
        actionButton3?.hideIf(drawableRes == null || drawableRes.toString().isBlank())
        drawableRes?.let { actionButton3?.setImageResource(drawableRes) }
    }

    init {
        init(context, attrs)
    }
}
