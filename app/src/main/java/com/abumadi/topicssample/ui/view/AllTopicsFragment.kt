package com.abumadi.topicssample.ui.view

import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.abumadi.topicssample.R
import com.abumadi.topicssample.ui.viewmodels.TopicsListViewModel
import com.airbnb.mvrx.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_all_topics.*


class AllTopicsFragment : Fragment(R.layout.fragment_all_topics), MavericksView {

    // add ViewModel declaration here
    private val viewModel: TopicsListViewModel by fragmentViewModel()

    //because groupie addAll function need collection of group>>use extension fun to convert item to map
//    private fun List<TopicsResponse.Topic>.toTopicsITem(): List<TopicsItem> {
//        return this.map {
//            TopicsItem(it)
//        }
//    }
    //TODO: no need for this extension function, logic already migrated below

    override fun invalidate() {
        withState(viewModel) { state ->
            when (state.topics) {
                is Loading -> {
                    progress_bar.visibility = View.VISIBLE
                    all_topics_recyclerview.visibility = View.GONE
                    Toast.makeText(requireContext(), "loading", Toast.LENGTH_SHORT).show()
                }
                is Success -> {
                    progress_bar.visibility = View.GONE
                    val groupAdapter = GroupAdapter<ViewHolder>().apply {
                        addAll(state.topics.invoke()?.map { TopicsItem(it) }?: emptyList())
                    }
                    all_topics_recyclerview.adapter = groupAdapter
                    all_topics_recyclerview.visibility = View.VISIBLE
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