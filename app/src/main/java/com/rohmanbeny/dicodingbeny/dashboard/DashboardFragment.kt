package com.rohmanbeny.dicodingbeny.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.rohmanbeny.dicodingbeny.R
import com.rohmanbeny.dicodingbeny.detail.DetailActivity
import com.rohmanbeny.dicodingbeny.model.Wisata
import com.rohmanbeny.mov.home.dashboard.WisataAdapter
import com.rohmanbeny.mov.utils.Preferences
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private lateinit var preferences : Preferences
    private lateinit var mDatabase : DatabaseReference

    private var datalist = ArrayList<Wisata>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        preferences = Preferences(requireActivity().applicationContext)
        mDatabase = FirebaseDatabase.getInstance().getReference("Wisata")

        rv_wisata.layoutManager = LinearLayoutManager(context)

        getData()
    }

    private fun getData() {
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                datalist.clear()
                for (getdataSnapshot in dataSnapshot.children) {
                    val wisata = getdataSnapshot.getValue(Wisata::class.java)
                    datalist.add(wisata!!)
                }
                rv_wisata.adapter = WisataAdapter(datalist) {
                    val intent = Intent(context, DetailActivity::class.java).putExtra("data", it)
                    startActivity(intent)
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(context, "" +databaseError.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}