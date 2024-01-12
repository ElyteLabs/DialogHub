package com.elytelabs.dialoghub

import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.elytelabs.dialoghub.dialogs.ColorPickerDialog
import com.elytelabs.dialoghub.dialogs.FontStyleDialog
import com.elytelabs.dialoghub.dialogs.ImageSelectorDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val backgrounds = listOf(R.drawable.bg11, R.drawable.bg22, R.drawable.bg23, R.drawable.bg25, R.drawable.bg5)

        val fonts = listOf(R.font.righteous, R.font.salsa, R.font.schoolbell, R.font.sofadi_one)

        val rootLayout: RelativeLayout = findViewById(R.id.rootLayout)
        val textView: TextView = findViewById(R.id.textView)
        val btnImageSelector: Button = findViewById(R.id.btnImageSelector)
        val btnFontSelector: Button = findViewById(R.id.btnFontSelector)
        val btnColorSelector: Button = findViewById(R.id.btnColorSelector)

        btnImageSelector.setOnClickListener {
            val selectorDialog = ImageSelectorDialog(this)
            selectorDialog.setBackgroundsList(backgrounds = backgrounds)
            selectorDialog.setImageSelectedListener(object : ImageSelectorDialog.ImagePickerListener{
                override fun onImageSelected(imageResource: Int) {
                    rootLayout.setBackgroundResource(imageResource)
                }

                override fun onColorSelected(color: Int) {
                    rootLayout.setBackgroundColor(color)
                }

            })
            selectorDialog.showImageSelectionDialog()
        }
        btnFontSelector.setOnClickListener {
            val styleDialog = FontStyleDialog(this)
            styleDialog.setFontsList(fonts = fonts)
            styleDialog.setFontSelectedListener(object : FontStyleDialog.FontPickerListener{
                override fun onFontSelected(font: Int) {
                    textView.typeface = ResourcesCompat.getFont(this@MainActivity, font)
                }

            })
            styleDialog.showFontSelectionDialog()
        }
        btnColorSelector.setOnClickListener {
            val colorPickerDialog = ColorPickerDialog(this)
            colorPickerDialog.setColorSelectedListener(object : ColorPickerDialog.ColorPickerListener{
                override fun onColorSelected(color: Int) {
                    rootLayout.setBackgroundColor(color)
                }

            })
            colorPickerDialog.showColorPickerDialog()
        }

    }
}