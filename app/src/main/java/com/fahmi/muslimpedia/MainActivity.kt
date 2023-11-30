package com.fahmi.muslimpedia

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import com.fahmi.muslimpedia.adapter.SectionPagerAdapter
import com.fahmi.muslimpedia.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        setUpViewPager()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.menu_search)?.actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        return true
    }

    private fun setUpViewPager() {
        binding.vpNews.adapter = SectionPagerAdapter(fa = this)

        val tabList = arrayOf(
            "Generals",
            "Educations",
            "Humanities",
            "Inspirations"
        )
        TabLayoutMediator(binding.tabs, binding.vpNews) {tab, page ->
            tab.text = tabList[page]
        }.attach()
    }
}