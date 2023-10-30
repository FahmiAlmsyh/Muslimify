package com.fahmi.muslimpedia.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.fahmi.muslimpedia.R
import com.fahmi.muslimpedia.adapter.NewsAdapter
import com.fahmi.muslimpedia.data.repository.NewsRepository
import com.fahmi.muslimpedia.databinding.FragmentCommonBinding
import com.fahmi.muslimpedia.ui.NewsViewModel
import com.fahmi.muslimpedia.utils.NewsViewModelFactory

class WarningForMuslimFragment : Fragment() {
    lateinit var binding: FragmentCommonBinding
    private val WarningForMuslimModel: NewsViewModel by viewModels {
        NewsViewModelFactory(NewsRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommonBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun isLoading(isLoading: Boolean) {
        if (isLoading){
            binding.loadingView.root.visibility = View.VISIBLE
        } else {
            binding.loadingView.root.visibility = View.GONE
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mAdapter = NewsAdapter()

        if (WarningForMuslimModel.warningForMuslimNews.value == null){
            WarningForMuslimModel.getWarningForMuslimNews()
        }

        WarningForMuslimModel.warningForMuslimNews.observe(viewLifecycleOwner){dataNews ->

            mAdapter.setData(dataNews.articles)

            binding.rvCommonNews.apply {
                adapter = mAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
        WarningForMuslimModel.isLoading.observe(viewLifecycleOwner){
            isLoading(it)
        }
    }


}