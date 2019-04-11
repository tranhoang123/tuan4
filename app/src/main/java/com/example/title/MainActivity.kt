package com.example.title

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main1.*
import kotlinx.android.synthetic.main.background.*
import android.graphics.Color.parseColor
import android.widget.TextView



class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        btnTitle.setOnClickListener(toTitle)
        btnBackground.setOnClickListener(toBackground)
    }
    private val toTitle = View.OnClickListener {
        val intent = Intent(this, Title::class.java)
        startActivityForResult(intent, REQUEST_SETTING_TITLE)
    }
    private val toBackground = View.OnClickListener {
        val intent = Intent(this, background::class.java)
        startActivityForResult(intent, REQUEST_SETTING_BACKGROUND)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_SETTING_TITLE && resultCode == Activity.RESULT_OK){
            val Text = data?.getStringExtra("Text")
            val Color = data?.getStringExtra("Color")
            handleSettingTitle(Text, Color)
        }
        if(requestCode == REQUEST_SETTING_BACKGROUND && resultCode == Activity.RESULT_OK){
            val sourceImage = data?.getStringExtra("source")
            handleSettingBackground(sourceImage)
        }
    }
    companion object {
        const val REQUEST_SETTING_TITLE = 1099
        const val REQUEST_SETTING_BACKGROUND=1100
    }
    private fun handleSettingTitle(Text: String?, cl: String?){
        text.setText(Text)
        val myColor = Color.parseColor(cl)
        text.setTextColor(myColor)
    }
    private fun handleSettingBackground(sourceImage: String?){
        val image = sourceImage
        val resID = resources.getIdentifier(image, "drawable", packageName)
        imageView.setImageResource(resID)
    }
}
