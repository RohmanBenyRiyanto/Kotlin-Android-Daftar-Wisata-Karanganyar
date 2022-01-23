package com.rohmanbeny.dicodingbeny.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.rohmanbeny.dicodingbeny.R
import com.rohmanbeny.dicodingbeny.model.Wisata
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<Wisata>("data")

        mDatabase = FirebaseDatabase.getInstance().getReference("Wisata")
            .child(data!!.nama.toString())

        tv_nama.text = data.nama
        tv_lokasi.text = data.lokasi
        tv_desc.text = data.desc
        tv_rate.text = data.rating

        Glide.with(this)
            .load(data.poster)
            .into(iv_poster)

        iv_close.setOnClickListener {
            finish()
        }
    }
}