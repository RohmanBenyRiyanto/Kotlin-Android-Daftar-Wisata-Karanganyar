package com.rohmanbeny.dicodingbeny

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.rohmanbeny.dicodingbeny.dashboard.DashboardFragment
import com.rohmanbeny.dicodingbeny.profile.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentHome = DashboardFragment()
        val fragmentProfile = ProfileFragment()

        setFragment(fragmentHome)

        iv_menu1.setOnClickListener{
            setFragment(fragmentHome)

            changeIcon(iv_menu1, R.drawable.ic_home)
            changeIcon(iv_menu2, R.drawable.ic_about_unactive)
        }
        iv_menu2.setOnClickListener{
            setFragment(fragmentProfile)

            changeIcon(iv_menu1, R.drawable.ic_home_unactive)
            changeIcon(iv_menu2, R.drawable.ic_about)
        }
    }

    private fun changeIcon(imageView: ImageView, int: Int) {
        imageView.setImageResource(int)
    }

    private fun setFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.layout_frame, fragment)
        fragmentTransaction.commit()
    }
}