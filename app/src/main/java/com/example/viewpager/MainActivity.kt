package com.example.viewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.navigation.About
import com.example.navigation.Courses
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter=myviewPageAdapter(supportFragmentManager)
        adapter.addFrag(Home(),"Home")
        adapter.addFrag(Courses(),"Courses")
        adapter.addFrag(About(),"About")
        viewPage.adapter=adapter
        tabs.setupWithViewPager(viewPage)
    }


    class myviewPageAdapter(manager:FragmentManager):FragmentPagerAdapter(manager){
        val fragList:MutableList<Fragment> =ArrayList()
        val titleList:MutableList<String> =ArrayList()
        override fun getCount(): Int {
            return fragList.size
        }

        override fun getItem(pos: Int): Fragment {
           return fragList[pos]
        }
        fun addFrag(fragment: Fragment,title:String){
            fragList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }

}
