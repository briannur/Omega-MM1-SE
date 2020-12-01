package com.briannur_18104006.commerc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.hide()

        last_commented.setOnClickListener{
            val moveWithIntent = Intent(this, DescriptionActivity::class.java)
            this?.startActivity(moveWithIntent)
        }
    }
}