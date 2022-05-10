package com.abumadi.topicssample.ui.view
import coil.load
import com.abumadi.topicssample.R
import com.abumadi.topicssample.api.responses.TopicsResponse
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.topics_item.view.*

class TopicsItem(private val topics: TopicsResponse.Topic) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.apply {
            //coil library
            viewHolder.itemView.topic_imageview.load(topics.ImageLink)
                {
                    crossfade(true)
                }
            viewHolder.itemView.topic_name_textview.text = topics.Name
        }
    }

    override fun getLayout() = R.layout.topics_item
}