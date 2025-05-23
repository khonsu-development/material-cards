package eu.khonsu.libraries.materialcards

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageButton
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
 * Media 1:1, primary text, subtext and actions.
 *
 * @see [](http://eugenebrusov.com/using-of-constraintlayout-to-build-out-cardview-3-of-3/)
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class CardView7(
    context: Context,
    attrs: AttributeSet,
) : CardView(context, attrs) {
    var constraintLayout: ConstraintLayout? = null
    var image: ImageView? = null
    var title: TextView? = null
    var subtitle: TextView? = null
    var action1: Button? = null
    var action2: Button? = null
    var supplementalAction1: ImageButton? = null
    var supplementalAction2: ImageButton? = null
    var supplementalAction3: ImageButton? = null

    private fun init(
        context: Context,
        attrs: AttributeSet,
    ) {
        View.inflate(context, R.layout.card_view_7, this)
        initComponents()
        setTitleText("")
        setSubtitleText("")
        setAction1Text("")
        setAction2Text("")
        setSupplementalAction1Drawable(0)
        setSupplementalAction2Drawable(0)
        setSupplementalAction3Drawable(0)
        context.withStyledAttributes(attrs, R.styleable.CardView7) {
            for (index in 0 until indexCount) {
                when (val attr = getIndex(index)) {
                    R.styleable.CardView7_cv7_srcImage ->
                        setImageSrc(
                            getResourceId(attr, R.drawable.background_image),
                        )

                    R.styleable.CardView7_cv7_srcImageTint ->
                        setImageSrcTint(
                            getResourceId(attr, android.R.attr.colorControlHighlight),
                        )

                    R.styleable.CardView7_cv7_title -> setTitleText(getString(attr))
                    R.styleable.CardView7_cv7_subtitle -> setSubtitleText(getString(attr))
                    R.styleable.CardView7_cv7_action1Text -> setAction1Text(getString(attr))
                    R.styleable.CardView7_cv7_action2Text -> setAction2Text(getString(attr))
                    R.styleable.CardView7_cv7_supplementalAction1Drawable ->
                        setSupplementalAction1Drawable(
                            getResourceId(attr, R.drawable.ic_star_outline),
                        )

                    R.styleable.CardView7_cv7_supplementalAction2Drawable ->
                        setSupplementalAction2Drawable(
                            getResourceId(attr, R.drawable.ic_star_outline),
                        )

                    R.styleable.CardView7_cv7_supplementalAction3Drawable ->
                        setSupplementalAction3Drawable(
                            getResourceId(attr, R.drawable.ic_star_outline),
                        )
                }
            }
        }
    }

    private fun initComponents() {
        constraintLayout = findViewById(R.id.constraint_layout)
        image = findViewById(R.id.image)
        title = findViewById(R.id.title)
        subtitle = findViewById(R.id.subtitle)
        action1 = findViewById(R.id.action_button_1)
        action2 = findViewById(R.id.action_button_2)
        supplementalAction1 = findViewById(R.id.supplemental_action_1)
        supplementalAction2 = findViewById(R.id.supplemental_action_2)
        supplementalAction3 = findViewById(R.id.supplemental_action_3)
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

    fun getTitleText(): CharSequence? = title?.text

    fun setTitleText(value: CharSequence?) {
        title!!.text = value
    }

    fun getSubtitleText(): CharSequence? = subtitle?.text

    fun setSubtitleText(value: CharSequence?) {
        subtitle!!.text = value
    }

    fun getAction1Text(): CharSequence? = action1?.text

    fun setAction1Text(value: CharSequence?) {
        action1?.hideIf(value.toString().isBlank())
        action1?.text = value
    }

    fun getAction2Text(): CharSequence? = action2?.text

    fun setAction2Text(value: CharSequence?) {
        action2?.hideIf(value.toString().isBlank())
        action2?.text = value
    }

    fun getSupplementalAction1Drawable(): Drawable? = supplementalAction1?.drawable

    private fun setSupplementalAction1Drawable(
        @DrawableRes drawableRes: Int?,
    ) {
        supplementalAction1?.hideIf(drawableRes == null || drawableRes.toString().isBlank())
        drawableRes?.let { supplementalAction1?.setImageResource(drawableRes) }
    }

    fun getSupplementalAction2Drawable(): Drawable? = supplementalAction2?.drawable

    private fun setSupplementalAction2Drawable(
        @DrawableRes drawableRes: Int?,
    ) {
        supplementalAction2?.hideIf(drawableRes == null || drawableRes.toString().isBlank())
        drawableRes?.let { supplementalAction2?.setImageResource(drawableRes) }
    }

    fun getSupplementalAction3Drawable(): Drawable? = supplementalAction3?.drawable

    private fun setSupplementalAction3Drawable(
        @DrawableRes drawableRes: Int?,
    ) {
        supplementalAction3?.hideIf(drawableRes == null || drawableRes.toString().isBlank())
        drawableRes?.let { supplementalAction3?.setImageResource(drawableRes) }
    }

    init {
        init(context, attrs)
    }
}
