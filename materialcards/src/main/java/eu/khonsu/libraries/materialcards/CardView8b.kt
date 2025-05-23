package eu.khonsu.libraries.materialcards

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.Button
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
 * Media 1x, primary text, subtext, supporting text and actions, image on the left.
 *
 * @see [](http://eugenebrusov.com/using-of-constraintlayout-to-build-out-cardview-3-of-3/)
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class CardView8b(
    context: Context,
    attrs: AttributeSet,
) : CardView(context, attrs) {
    var constraintLayout: ConstraintLayout? = null
    var title: TextView? = null
    var subtitle: TextView? = null
    var supportingText: TextView? = null
    var image: ImageView? = null
    var actionButton1: Button? = null
    var actionButton2: Button? = null
    var actionButton3: Button? = null

    private fun init(
        context: Context,
        attrs: AttributeSet,
    ) {
        View.inflate(context, R.layout.card_view_8_image_left, this)
        initComponents()
        setTitleText("")
        setSubtitleText("")
        setSupportingText("")
        setAction1Text("")
        setAction2Text("")
        setAction3Text("")
        context.withStyledAttributes(attrs, R.styleable.CardView8b) {
            for (index in 0 until indexCount) {
                when (val attr = getIndex(index)) {
                    R.styleable.CardView8b_cv8b_title -> setTitleText(getString(attr))
                    R.styleable.CardView8b_cv8b_subtitle -> setSubtitleText(getString(attr))
                    R.styleable.CardView8b_cv8b_supportingText ->
                        setSupportingText(
                            getString(attr),
                        )

                    R.styleable.CardView8b_cv8b_srcImage ->
                        setImageSrc(
                            getResourceId(attr, R.drawable.background_image),
                        )

                    R.styleable.CardView8b_cv8b_srcImageTint ->
                        setImageSrcTint(
                            getResourceId(attr, android.R.attr.colorControlHighlight),
                        )

                    R.styleable.CardView8b_cv8b_imageHeight ->
                        setImageHeight(
                            getDimensionPixelSize(
                                attr,
                                resources.getDimensionPixelSize(R.dimen.image_default_size),
                            ),
                        )

                    R.styleable.CardView8b_cv8b_imageWidth ->
                        setImageWidth(
                            getDimensionPixelSize(
                                attr,
                                resources.getDimensionPixelSize(R.dimen.image_default_size),
                            ),
                        )

                    R.styleable.CardView8b_cv8b_action1Text ->
                        setAction1Text(
                            getString(attr),
                        )

                    R.styleable.CardView8b_cv8b_action2Text ->
                        setAction2Text(
                            getString(attr),
                        )

                    R.styleable.CardView8b_cv8b_action3Text ->
                        setAction3Text(
                            getString(attr),
                        )
                }
            }
        }
    }

    private fun initComponents() {
        constraintLayout = findViewById(R.id.constraint_layout)
        title = findViewById(R.id.title)
        subtitle = findViewById(R.id.subtitle)
        supportingText = findViewById(R.id.supporting_text)
        image = findViewById(R.id.image)
        actionButton1 = findViewById(R.id.action_button_1)
        actionButton2 = findViewById(R.id.action_button_2)
        actionButton3 = findViewById(R.id.action_button_3)
    }

    fun getTitleText(): CharSequence? = title?.text

    fun setTitleText(value: CharSequence?) {
        title?.text = value
    }

    fun getSubtitleText(): CharSequence? = subtitle?.text

    fun setSubtitleText(value: CharSequence?) {
        subtitle?.hideIf(value.isNullOrBlank())
        subtitle?.text = value
    }

    fun getSupportingText(): CharSequence? = supportingText?.text

    fun setSupportingText(value: CharSequence?) {
        supportingText?.hideIf(value.isNullOrBlank())
        supportingText?.text = value
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

    fun getImageHeight(): Int? = image?.height

    fun setImageHeight(value: Int) {
        image?.layoutParams?.height = value
    }

    fun getImageWidth(): Int? = image?.width

    fun setImageWidth(value: Int) {
        image?.layoutParams?.width = value
    }

    fun getAction1Text(): CharSequence? = actionButton1?.text

    fun setAction1Text(value: CharSequence?) {
        actionButton1?.hideIf(value.toString().isBlank())
        actionButton1?.text = value
    }

    fun getAction2Text(): CharSequence? = actionButton2?.text

    fun setAction2Text(value: CharSequence?) {
        actionButton2?.hideIf(value.toString().isBlank())
        actionButton2?.text = value
    }

    fun getAction3Text(): CharSequence? = actionButton3?.text

    fun setAction3Text(value: CharSequence?) {
        actionButton3?.hideIf(value.toString().isBlank())
        actionButton3?.text = value
    }

    init {
        init(context, attrs)
    }
}
