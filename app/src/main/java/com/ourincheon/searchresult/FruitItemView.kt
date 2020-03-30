package com.ourincheon.searchresult

import android.content.Context
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class FruitItemView(context: Context) : LinearLayout(context) {
    lateinit var txtView: TextView
    lateinit var imgView: ImageView

    init {
        LinearLayout(context)

        val inflater = context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE)
                as LayoutInflater
        inflater.inflate(R.layout.fruit_item, this, true)

        txtView = findViewById<TextView>(R.id.textView)
        imgView = findViewById<ImageView>(R.id.imageView)
    }
}