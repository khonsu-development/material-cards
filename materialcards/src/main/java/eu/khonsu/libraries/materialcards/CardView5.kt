package eu.khonsu.libraries.materialcards

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import eu.khonsu.libraries.materialcards.extensions.hideIf

/**
 * Primary text, subtext, supporting text and actions.
 *
 * @see [](http://eugenebrusov.com/using-of-constraintlayout-to-build-out-cardview-2-of-3/)
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class CardView5(
    context: Context,
    attrs: AttributeSet,
) : CardView(context, attrs) {
    var constraintLayout: ConstraintLayout? = null
    var title: TextView? = null
    var subtitle: TextView? = null
    var supportingText: TextView? = null
    var actionButton1: Button? = null
    var actionButton2: Button? = null
    var supplementalAction1: ImageButton? = null
    var supplementalAction2: ImageButton? = null
    var supplementalAction3: ImageButton? = null

    private fun init(
        context: Context,
        attrs: AttributeSet,
    ) {
        View.inflate(context, R.layout.card_view_5, this)
        initComponents()
        setTitleText("")
        setSubtitleText("")
        setSupportingText("")
        setAction1Text("")
        setAction2Text("")
        setSupplementalAction1Drawable(0)
        setSupplementalAction2Drawable(0)
        setSupplementalAction3Drawable(0)
        context.withStyledAttributes(attrs, R.styleable.CardView5) {
            for (index in 0 until indexCount) {
                when (val attr = getIndex(index)) {
                    R.styleable.CardView5_cv5_title -> setTitleText(getString(attr))
                    R.styleable.CardView5_cv5_subtitle -> setSubtitleText(getString(attr))
                    R.styleable.CardView5_cv5_supportingText ->
                        setSupportingText(
                            getString(attr),
                        )

                    R.styleable.CardView5_cv5_action1Text ->
                        setAction1Text(
                            getString(attr),
                        )

                    R.styleable.CardView5_cv5_action2Text ->
                        setAction2Text(
                            getString(attr),
                        )

                    R.styleable.CardView5_cv5_supplementalAction1Drawable ->
                        setSupplementalAction1Drawable(
                            getResourceId(attr, R.drawable.ic_star_outline),
                        )

                    R.styleable.CardView5_cv5_supplementalAction2Drawable ->
                        setSupplementalAction2Drawable(
                            getResourceId(attr, R.drawable.ic_star_outline),
                        )

                    R.styleable.CardView5_cv5_supplementalAction3Drawable ->
                        setSupplementalAction3Drawable(
                            getResourceId(attr, R.drawable.ic_star_outline),
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
        actionButton1 = findViewById(R.id.action_button_1)
        actionButton2 = findViewById(R.id.action_button_2)
        supplementalAction1 = findViewById(R.id.supplemental_action_1)
        supplementalAction2 = findViewById(R.id.supplemental_action_2)
        supplementalAction3 = findViewById(R.id.supplemental_action_3)
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
