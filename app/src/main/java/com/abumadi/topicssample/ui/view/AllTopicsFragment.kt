package com.abumadi.topicssample.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.abumadi.topicssample.R
import com.abumadi.topicssample.api.responses.TopicsResponse
import com.abumadi.topicssample.data.source.TopicsListRepository
import com.abumadi.topicssample.di.component.DaggerAppComponent
import com.abumadi.topicssample.others.TopicsListApp
import com.abumadi.topicssample.states.TopicModel
import com.abumadi.topicssample.ui.viewmodels.TopicsListViewModel
import com.airbnb.mvrx.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_all_topics.*
import kotlinx.coroutines.delay
import javax.inject.Inject

class AllTopicsFragment : Fragment(R.layout.fragment_all_topics), MavericksView {

    private lateinit var topicsList: List<TopicsResponse.Topic>
    private val adapter by lazy { topicsList.toTopicsITem() }

    // add ViewModel declaration here
    private val viewModel: TopicsListViewModel by fragmentViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.topicsList.observe(viewLifecycleOwner, {
            topicsList = it
        })

//        val component = DaggerAppComponent.builder()
//            .build()
//        component.injectToAllTopicsFragment(this)
    }

    private fun List<TopicsResponse.Topic>.toTopicsITem(): List<TopicsItem> {
        return this.map {
            TopicsItem(it)
        }
    }

    override fun invalidate() {
        withState(viewModel) { state ->
            when (state.topics) {
                is Loading -> {
                    progress_bar.visibility = View.VISIBLE
                    all_topics_recyclerview.visibility = View.GONE
                }
                is Success -> {
                    progress_bar.visibility = View.GONE
                    val groupAdapter = GroupAdapter<ViewHolder>().apply {
                        addAll(adapter)
                    }
                    all_topics_recyclerview.adapter = groupAdapter
                    all_topics_recyclerview.visibility = View.VISIBLE

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