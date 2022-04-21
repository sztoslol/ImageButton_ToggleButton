package com.example.myapplication

import android.graphics.*
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ToggleButton
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mojprzycisk = findViewById<ImageButton>(R.id.imageButton)
        var kolorRed = findViewById<Button>(R.id.button)
        var kolorGreen = findViewById<ToggleButton>(R.id.toggleButton)

        mojprzycisk.setOnClickListener {
            mojprzycisk.setImageResource(R.drawable.major)
        }
        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.konon)
        var bitmapCzerwony = BitmapFactory.decodeResource(resources, R.drawable.czerwony)
        var filterBitmap = Bitmap.createBitmap(bitmap.width , bitmap.height, Bitmap.Config.ARGB_8888)

        kolorRed.setOnClickListener {
            val paint = Paint()
            paint.alpha = 100
            val canvas = Canvas(filterBitmap)
            canvas.drawARGB(0,0,0,0)
            canvas.drawBitmap(bitmapCzerwony, null, RectF(0f,0f,bitmap.width.toFloat(),bitmap.height.toFloat()), paint)
            canvas.drawBitmap(bitmap, 0f,0f, paint)
            mojprzycisk.setImageBitmap(filterBitmap)
        }

        kolorGreen.setOnClickListener {
            if(kolorGreen.isChecked)
            {
                mojprzycisk.setColorFilter(R.color.purple_700)
                mojprzycisk.background = (ContextCompat.getDrawable(kolorGreen.context, R.color.purple_700))
            }
            else
            {
                mojprzycisk.setColorFilter(null)
                kolorGreen.background = (ContextCompat.getDrawable(kolorGreen.context, R.color.purple_700))
            }
        }
    }
}