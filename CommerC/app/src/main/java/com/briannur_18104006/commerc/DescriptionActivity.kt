package com.briannur_18104006.commerc

import android.app.Activity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.briannur_18104006.commerc.databinding.ActivityDescriptionBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.content_scrolling.*

class DescriptionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDescriptionBinding

    companion object{
        const val EXTRA_TITLE = "mydata"
        const val EXTRA_IMAGE = "thisdata"
        const val EXTRA_DESC = "thedata"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(findViewById(R.id.toolbar))

        val myData = intent.getStringExtra(EXTRA_TITLE)
        val thisData = intent.getIntExtra(EXTRA_IMAGE, 0)
        val theData = intent.getStringExtra(EXTRA_DESC)
        Log.d("DescriptionActivity", "onCreate: $thisData")
        supportActionBar?.title = myData
        binding.apply {
            Glide.with(this@DescriptionActivity)
                .load(thisData)
                .apply(RequestOptions().override(700, 700))
                .into(tvDescimg)
            deskripsilah.text = theData
        }

    }
}