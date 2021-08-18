package com.roberts.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import com.roberts.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        createPaletteAsync((ContextCompat.getDrawable(this,R.drawable.index) as BitmapDrawable).bitmap)

    }

    private fun createPaletteAsync(bitmap: Bitmap) {
        Palette.from(bitmap).generate(){ palette ->

            binding.changeToolbarColorBtn.setOnClickListener {
                binding.toolbar.setBackgroundColor(palette?.vibrantSwatch!!.rgb)
            }
            binding.lightVibrant.apply {

                setBackgroundColor(palette?.lightVibrantSwatch!!.rgb)
            }

            binding.vibrant.apply {

                setBackgroundColor(palette?.vibrantSwatch!!.rgb)
            }

            binding.lightMuted.apply {

                Log.d(TAG, "createPaletteAsync: ${palette?.lightMutedSwatch?.rgb}")
               // setBackgroundColor(palette?.lightMutedSwatch!!.rgb)
            }

            binding.muted.apply {

                setBackgroundColor(palette?.mutedSwatch!!.rgb)
            }

            binding.darkMuted.apply {

                setBackgroundColor(palette?.darkMutedSwatch!!.rgb)
            }
            binding.darkVibrant.apply {

                setBackgroundColor(palette?.darkVibrantSwatch!!.rgb)
            }




        }
    }



}