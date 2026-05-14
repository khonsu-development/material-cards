package eu.khonsu.libraries.materialcards

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import eu.khonsu.libraries.materialcards.extensions.hide
import eu.khonsu.libraries.materialcards.extensions.hideIf
import eu.khonsu.libraries.materialcards.extensions.show

/**
 * Primary text, subtext, supporting text and expand button.
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class CardView12(
    context: Context,
    attrs: AttributeSet,
) : CardView(context, attrs) {
    var constraintLayout: ConstraintLayout? = null
    var title: TextView? = null
    var subtitle: TextView? = null
    var supportingText: TextView? = null
    var expandButton: ImageButton? = null

    private fun init(
        context: Context,
        attrs: AttributeSet,
    ) {
        View.inflate(context, R.layout.card_view_12, this)
        initComponents()
        setTitleText("")
        setSubtitleText("")
        setSupportingText("")
        expandButton?.setOnClickListener {
            if (supportingText?.visibility == View.VISIBLE) {
                supportingText?.hide()
                expandButton?.setImageResource(R.drawable.ic_expand_more)
            } else {
                supportingText?.show()
                expandButton?.setImageResource(R.drawable.ic_expand_less)
            }
        }
        context.withStyledAttributes(attrs, R.styleable.CardView12) {
            for (index in 0 until indexCount) {
                when (val attr = getIndex(index)) {
                    R.styleable.CardView12_cv12_title -> setTitleText(getString(attr))
                    R.styleable.CardView12_cv12_subtitle -> setSubtitleText(getString(attr))
                    R.styleable.CardView12_cv12_supportingText ->
                        setSupportingText(
                            getString(attr),
                        )
                }
            }
        }
        supportingText?.hide()
        expandButton?.setImageResource(R.drawable.ic_expand_more)
    }

    private fun initComponents() {
        constraintLayout = findViewById(R.id.constraint_layout)
        title = findViewById(R.id.title)
        subtitle = findViewById(R.id.subtitle)
        supportingText = findViewById(R.id.supporting_text)
        expandButton = findViewById(R.id.expand_button)
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

    init {
        init(context, attrs)
    }
}
