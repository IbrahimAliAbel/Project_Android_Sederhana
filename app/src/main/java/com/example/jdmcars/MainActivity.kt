package com.example.jdmcars


import MobilJDM
import MobilJDMAdapter
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList



class MainActivity : AppCompatActivity() {

    private lateinit var rvMobil: RecyclerView
    private val list  = ArrayList<MobilJDM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        rvMobil = findViewById(R.id.rv_cars)
        rvMobil.setHasFixedSize(true)

        list.addAll(getListMobil())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvMobil.layoutManager = LinearLayoutManager(this)
        val mobilAdapter = MobilJDMAdapter(list)
        rvMobil.adapter = mobilAdapter

        mobilAdapter.setOnItemClickCallback(object : MobilJDMAdapter.OnItemClickCallback {
            override fun onItemClicked(data: MobilJDM) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("EXTRA_MOBIL", data)
                startActivity(intent)
            }
        })
    }
    private fun getListMobil(): ArrayList<MobilJDM> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataDetailDescription = resources.getStringArray(R.array.data_detail_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val listMobil = ArrayList<MobilJDM>()
        for (i in dataName.indices) {
            val mobil = MobilJDM(
                dataName[i],
                dataDescription[i],
                dataPhoto.getResourceId(i, -1),
                dataDetailDescription[i])
            listMobil.add(mobil)
        }
        dataPhoto.recycle()
        return listMobil
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}}