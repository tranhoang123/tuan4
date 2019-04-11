package com.example.title

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.android.synthetic.main.background.*
import android.widget.ImageView
import android.graphics.drawable.Drawable




class background : AppCompatActivity() {
    private var sourceImage: String? = "facebook"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.background)
        btn_facebook.setOnClickListener { changeBackground("facebook" ) }
        btn_youtube.setOnClickListener { changeBackground("youtube") }
        btn_vivaldi.setOnClickListener {  changeBackground("vivaldi")}
        btn_neon.setOnClickListener { changeBackground("neon") }
        btn_ubuntu.setOnClickListener { changeBackground("ubuntu") }
        btn_android_studio.setOnClickListener {  changeBackground("android_studio")}
        btn_save.setOnClickListener { save() }
    }


    private fun changeBackground(sor  : String){
        val mDrawableName:String? = sor
        sourceImage = sor
        val resID = resources.getIdentifier(mDrawableName, "drawable", packageName)
        img_view.setImageResource(resID)
    }
    private fun save(){
        intent.putExtra("source", sourceImage)
        setResult(Activity.RESULT_OK, intent)
    }
}