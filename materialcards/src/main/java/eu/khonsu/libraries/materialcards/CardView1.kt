package eu.khonsu.libraries.materialcards

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.cardview.widget.CardView
import eu.khonsu.libraries.materialcards.extensions.hideIf

/**
 * Media 16:9 and supporting text.
 *
 * @see [](http://eugenebrusov.com/cardview-with-constraintlayout/)
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class CardView1(context: Context, attrs: AttributeSet) : CardView(context, attrs) {

    var image: ImageView? = null
    var supportingText: TextView? = null

    private fun init(context: Context, attrs: AttributeSet) {
        View.inflate(context, R.layout.card_view_1, this)
        initComponents()
        setSupportingText("")
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CardView1)
        for (index in 0 until typedArray.indexCount) {
            when (val attr = typedArray.getIndex(index)) {
                R.styleable.CardView1_cv1_srcImage -> setImageSrc(
                    typedArray.getResourceId(attr, R.drawable.background_image)
                )
                R.styleable.CardView1_cv1_supportingText -> setSupportingText(
                    typedArray.getString(attr)
                )
            }
        }
        typedArray.recycle()
    }

    private fun initComponents() {
        image = findViewById(R.id.image)
        supportingText = findViewById(R.id.supporting_text)
    }

    fun getImageSrc(): Drawable? = image?.drawable

    fun setImageSrc(@DrawableRes value: Int) {
        image?.setImageResource(value)
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
