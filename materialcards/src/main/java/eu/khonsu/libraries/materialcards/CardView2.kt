package eu.khonsu.libraries.materialcards

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.cardview.widget.CardView
import eu.khonsu.libraries.materialcards.extensions.hideIf

/**
 * Avatar, media 16:9, supporting text and action buttons.
 *
 * @see [](http://eugenebrusov.com/cardview-with-constraintlayout/)
 */
@Suppress("MemberVisibilityCanBePrivate", "unused")
class CardView2(context: Context, attrs: AttributeSet) : CardView(context, attrs) {

    var avatarImage: ImageView? = null
    var title: TextView? = null
    var subtitle: TextView? = null
    var image: ImageView? = null
    var supportingText: TextView? = null
    var actionButton1: Button? = null
    var actionButton2: Button? = null
    var actionButton3: Button? = null
    var supplementalAction1: ImageButton? = null
    var supplementalAction2: ImageButton? = null
    var supplementalAction3: ImageButton? = null

    private fun init(context: Context, attrs: AttributeSet) {
        View.inflate(context, R.layout.card_view_2, this)
        initComponents()
        setTitleText("")
        setSubtitleText("")
        setSupportingText("")
        setAction1Text("")
        setAction2Text("")
        setAction3Text("")
        setSupplementalAction1Drawable(0)
        setSupplementalAction2Drawable(0)
        setSupplementalAction3Drawable(0)
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CardView2)
        for (index in 0 until typedArray.indexCount) {
            when (val attr = typedArray.getIndex(index)) {
                R.styleable.CardView2_cv2_avatarImage -> setAvatarDrawable(
                    typedArray.getResourceId(attr, R.drawable.ic_avatar)
                )
                R.styleable.CardView2_cv2_title -> setTitleText(typedArray.getString(attr))
                R.styleable.CardView2_cv2_subtitle -> setSubtitleText(typedArray.getString(attr))
                R.styleable.CardView2_cv2_srcImage -> setImageSrc(
                    typedArray.getResourceId(attr, R.drawable.background_image)
                )
                R.styleable.CardView2_cv2_supportingText -> setSupportingText(
                    typedArray.getString(attr)
                )
                R.styleable.CardView2_cv2_action1Text -> setAction1Text(
                    typedArray.getString(attr)
                )
                R.styleable.CardView2_cv2_action2Text -> setAction2Text(
                    typedArray.getString(attr)
                )
                R.styleable.CardView2_cv2_action3Text -> setAction3Text(
                    typedArray.getString(attr)
                )
                R.styleable.CardView2_cv2_supplementalAction1Drawable -> setSupplementalAction1Drawable(
                    typedArray.getResourceId(attr, R.drawable.ic_star_outline)
                )
                R.styleable.CardView2_cv2_supplementalAction2Drawable -> setSupplementalAction2Drawable(
                    typedArray.getResourceId(attr, R.drawable.ic_star_outline)
                )
                R.styleable.CardView2_cv2_supplementalAction3Drawable -> setSupplementalAction3Drawable(
                    typedArray.getResourceId(attr, R.drawable.ic_star_outline)
                )
            }
        }
        typedArray.recycle()
    }

    private fun initComponents() {
        avatarImage = findViewById(R.id.avatar_image)
        title = findViewById(R.id.title)
        subtitle = findViewById(R.id.subtitle)
        image = findViewById(R.id.media_image)
        supportingText = findViewById(R.id.supporting_text)
        actionButton1 = findViewById(R.id.action_button_1)
        actionButton2 = findViewById(R.id.action_button_2)
        actionButton3 = findViewById(R.id.action_button_3)
        supplementalAction1 = findViewById(R.id.supplemental_action_1)
        supplementalAction2 = findViewById(R.id.supplemental_action_2)
        supplementalAction3 = findViewById(R.id.supplemental_action_3)
    }

    fun getAvatarDrawable(): Drawable? = avatarImage?.drawable

    fun setAvatarDrawable(@DrawableRes drawableRes: Int?) {
        drawableRes?.let { avatarImage?.setImageResource(drawableRes) }
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

    fun getImageSrc(): Drawable? = image?.drawable

    fun setImageSrc(@DrawableRes value: Int) {
        image?.setImageResource(value)
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
