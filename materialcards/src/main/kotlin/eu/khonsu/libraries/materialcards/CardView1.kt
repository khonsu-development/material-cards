package eu.khonsu.libraries.materialcards

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.withStyledAttributes
import androidx.core.widget.ImageViewCompat
import eu.khonsu.libraries.materialcards.extensions.hideIf

/**
 * Media 16:9 and supporting text.
 *
 * @see [](http://eugenebrusov.com/cardview-with-constraintlayout/)
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class CardView1(
    context: Context,
    attrs: AttributeSet,
) : CardView(context, attrs) {
    var constraintLayout: ConstraintLayout? = null
    var image: ImageView? = null
    var supportingText: TextView? = null

    private fun init(
        context: Context,
        attrs: AttributeSet,
    ) {
        View.inflate(context, R.layout.card_view_1, this)
        initComponents()
        setSupportingText("")
        context.withStyledAttributes(attrs, R.styleable.CardView1) {
            for (index in 0 until indexCount) {
                when (val attr = getIndex(index)) {
                    R.styleable.CardView1_cv1_srcImage ->
                        setImageSrc(
                            getResourceId(attr, R.drawable.background_image),
                        )

                    R.styleable.CardView1_cv1_srcImageTint ->
                        setImageSrcTint(
                            getResourceId(attr, android.R.attr.colorControlHighlight),
                        )

                    R.styleable.CardView1_cv1_supportingText ->
                        setSupportingText(
                            getString(attr),
                        )
                }
            }
        }
    }

    private fun initComponents() {
        constraintLayout = findViewById(R.id.constraint_layout)
        image = findViewById(R.id.image)
        supportingText = findViewById(R.id.supporting_text)
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

    fun getSupportingText(): CharSequence? = supportingText?.text

    fun setSupportingText(value: CharSequence?) {
        supportingText?.hideIf(value.isNullOrBlank())
        supportingText?.text = value
    }

    init {
        init(context, attrs)
    }
}
