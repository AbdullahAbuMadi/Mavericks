package com.abumadi.topicssample.ui.view

import android.view.View
import coil.load
import com.abumadi.topicssample.R
import com.abumadi.topicssample.api.responses.TopicsResponse
import com.abumadi.topicssample.databinding.TopicsItemBinding
import com.xwray.groupie.viewbinding.BindableItem


class TopicsItem(private val topics: TopicsResponse.Topic) : BindableItem<TopicsItemBinding>() {

    override fun bind(binding: TopicsItemBinding, position: Int) {
        binding.apply {
            //coil library
            binding.topicImageview.load(topics.imageLink)
            {
                crossfade(true)
            }
            binding.topicNameTextview.text = topics.name
        }
    }

    override fun getLayout() = R.layout.topics_item

    override fun initializeViewBinding(view: View): TopicsItemBinding {
        return TopicsItemBinding.bind(view)
    }
}