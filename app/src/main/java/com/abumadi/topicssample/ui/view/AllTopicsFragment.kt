package com.abumadi.topicssample.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.abumadi.topicssample.databinding.FragmentAllTopicsBinding
import com.abumadi.topicssample.ui.viewmodels.TopicsListViewModel
import com.airbnb.mvrx.*
import com.xwray.groupie.GroupieAdapter

class AllTopicsFragment : Fragment(), MavericksView {

    private lateinit var binding: FragmentAllTopicsBinding

    // add ViewModel declaration here
    private val viewModel: TopicsListViewModel by fragmentViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAllTopicsBinding.inflate(inflater, container, false)
        viewModel.getData()
        return binding.root
    }

    override fun invalidate() {
        withState(viewModel) { state ->
            when (state.topics) {
                is Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.allTopicsRecyclerview.visibility = View.GONE
                    Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                }
                is Success -> {
                    binding.progressBar.visibility = View.GONE
                    val groupAdapter = GroupieAdapter().apply {
                        addAll(state.topics.invoke()?.map { TopicsItem(it) } ?: emptyList())
                    }
                    binding.allTopicsRecyclerview.adapter = groupAdapter
                    binding.allTopicsRecyclerview.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), "success", Toast.LENGTH_SHORT).show()
                }
                is Fail -> {
                    Toast.makeText(
                        requireContext(),
                        "Failed to load all topics",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}