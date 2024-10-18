package com.example.jdmcars

import MobilJDM
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView



class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val mobil = intent.getParcelableExtra<MobilJDM>("EXTRA_MOBIL") as MobilJDM
        supportActionBar?.title = mobil.name

        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvName: TextView = findViewById(R.id.tv_item_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_item_description)

        tvName.text = mobil.name
        tvDetailDescription.text = mobil.detailDescription
        imgPhoto.setImageResource(mobil.photo)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                // Kembali ke activity sebelumnya
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
} }