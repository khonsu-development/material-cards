package eu.khonsu.libraries.materialcards

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import eu.khonsu.libraries.materialcards.extensions.hideIf

/**
 * Primary text, subtext, supporting text and actions.
 *
 * @see [](http://eugenebrusov.com/using-of-constraintlayout-to-build-out-cardview-2-of-3/)
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class CardView4(context: Context, attrs: AttributeSet) : CardView(context, attrs) {

    var title: TextView? = null
    var subtitle: TextView? = null
    var supportingText: TextView? = null
    var actionButton1: Button? = null
    var actionButton2: Button? = null
    var actionButton3: Button? = null

    private fun init(context: Context, attrs: AttributeSet) {
        View.inflate(context, R.layout.card_view_4, this)
        initComponents()
        setTitleText("")
        setSubtitleText("")
        setAction1Text("")
        setAction2Text("")
        setAction3Text("")
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CardView4)
        for (index in 0 until typedArray.indexCount) {
            when (val attr = typedArray.getIndex(index)) {
                R.styleable.CardView4_cv4_title -> setTitleText(typedArray.getString(attr))
                R.styleable.CardView4_cv4_subtitle -> setSubtitleText(typedArray.getString(attr))
                R.styleable.CardView4_cv4_supportingText -> setSupportingText(
                    typedArray.getString(attr)
                )
                R.styleable.CardView4_cv4_action1Text -> setAction1Text(
                    typedArray.getString(attr)
                )
                R.styleable.CardView4_cv4_action2Text -> setAction2Text(
                    typedArray.getString(attr)
                )
                R.styleable.CardView4_cv4_action3Text -> setAction3Text(
                    typedArray.getString(attr)
                )
            }
        }
        typedArray.recycle()
    }

    private fun initComponents() {
        title = findViewById(R.id.title)
        subtitle = findViewById(R.id.subtitle)
        supportingText = findViewById(R.id.supporting_text)
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

    fun getAction1Text(): CharSequence? = actionButton1?.text

    fun setAction1Text(value: CharSequence?) {
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
