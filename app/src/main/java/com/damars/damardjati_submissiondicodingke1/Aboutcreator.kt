package com.damars.damardjati_submissiondicodingke1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Aboutcreator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aboutcreator)

        val foractionbar = supportActionBar
        foractionbar!!.title= "About Me!"
        foractionbar.setDisplayHomeAsUpEnabled(true)
    }
}