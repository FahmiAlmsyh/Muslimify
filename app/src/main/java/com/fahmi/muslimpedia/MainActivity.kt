package com.fahmi.muslimpedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fahmi.muslimpedia.adapter.SectionPagerAdapter
import com.fahmi.muslimpedia.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewPager()
    }

    private fun setUpViewPager() {
        binding.vpNews.adapter = SectionPagerAdapter(fa = this)

        val tabList = arrayOf(
            "Common",
            "About Quran",
            "Al Jazeera",
            "Warn for Muslim"
        )
        TabLayoutMediator(binding.tabs, binding.vpNews) {tab, page ->
            tab.text = tabList[page]
        }.attach()
    }
}