package eu.khonsu.libraries.materialcards

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import eu.khonsu.libraries.materialcards.extensions.hideIf

/**
 * Media 1:1, primary text, subtext and actions.
 *
 * @see [](http://eugenebrusov.com/using-of-constraintlayout-to-build-out-cardview-3-of-3/)
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class CardView7(context: Context, attrs: AttributeSet) : CardView(context, attrs) {

    var image: AppCompatImageView? = null
    var title: AppCompatTextView? = null
    var subtitle: AppCompatTextView? = null
    var action1: AppCompatButton? = null
    var action2: AppCompatButton? = null
    var supplementalAction1: AppCompatImageButton? = null
    var supplementalAction2: AppCompatImageButton? = null
    var supplementalAction3: AppCompatImageButton? = null

    private fun init(context: Context, attrs: AttributeSet) {
        View.inflate(context, R.layout.card_view_7, this)
        initComponents()
        setAction1Text("")
        setAction2Text("")
        setSupplementalAction1Drawable(0)
        setSupplementalAction2Drawable(0)
        setSupplementalAction3Drawable(0)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CardView7)
        for (index in 0 until typedArray.indexCount) {
            when (val attr = typedArray.getIndex(index)) {
                R.styleable.CardView7_cv7_srcImage -> setImageSrc(
                    typedArray.getResourceId(attr, R.drawable.background_image)
                )
                R.styleable.CardView7_cv7_title -> setTitleText(typedArray.getString(attr))
                R.styleable.CardView7_cv7_subtitle -> setSubtitleText(typedArray.getString(attr))
                R.styleable.CardView7_cv7_action1Text -> setAction1Text(typedArray.getString(attr))
                R.styleable.CardView7_cv7_action2Text -> setAction2Text(typedArray.getString(attr))
                R.styleable.CardView7_cv7_supplementalAction1Drawable -> setSupplementalAction1Drawable(
                    typedArray.getResourceId(attr, R.drawable.ic_star_outline)
                )
                R.styleable.CardView7_cv7_supplementalAction2Drawable -> setSupplementalAction2Drawable(
                    typedArray.getResourceId(attr, R.drawable.ic_star_outline)
                )
                R.styleable.CardView7_cv7_supplementalAction3Drawable -> setSupplementalAction3Drawable(
                    typedArray.getResourceId(attr, R.drawable.ic_star_outline)
                )
            }
        }
        typedArray.recycle()
    }

    private fun initComponents() {
        image = findViewById(R.id.image)
        title = findViewById(R.id.title)
        subtitle = findViewById(R.id.subtitle)
        action1 = findViewById(R.id.action_1)
        action2 = findViewById(R.id.action2)
        supplementalAction1 = findViewById(R.id.supplemental_action_1)
        supplementalAction2 = findViewById(R.id.supplemental_action_2)
        supplementalAction3 = findViewById(R.id.supplemental_action_3)
    }

    fun getImageSrc(): Drawable? = image?.drawable

    fun setImageSrc(@DrawableRes value: Int) {
        image?.setImageResource(value)
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
        action1?.text = value
    }

    fun getAction2Text(): CharSequence? = action2?.text

    fun setAction2Text(value: CharSequence?) {
        action2?.hideIf(value.toString().isBlank())
        action2?.text = value
    }

    fun getSupplementalAction1Drawable(): Drawable? = supplementalAction1?.drawable

    private fun setSupplementalAction1Drawable(@DrawableRes drawableRes: Int?) {
        supplementalAction1?.hideIf(drawableRes.toString().isBlank())
        drawableRes?.let { supplementalAction1?.setImageResource(drawableRes) }
    }

    fun getSupplementalAction2Drawable(): Drawable? = supplementalAction2?.drawable

    private fun setSupplementalAction2Drawable(@DrawableRes drawableRes: Int?) {
        supplementalAction2?.hideIf(drawableRes.toString().isBlank())
        drawableRes?.let { supplementalAction2?.setImageResource(drawableRes) }
    }

    fun getSupplementalAction3Drawable(): Drawable? = supplementalAction3?.drawable

    private fun setSupplementalAction3Drawable(@DrawableRes drawableRes: Int?) {
        supplementalAction3?.hideIf(drawableRes.toString().isBlank())
        drawableRes?.let { supplementalAction3?.setImageResource(drawableRes) }
    }

    init {
        init(context, attrs)
    }
}
