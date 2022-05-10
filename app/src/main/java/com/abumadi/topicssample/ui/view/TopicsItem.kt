package com.abumadi.topicssample.ui.view
import com.abumadi.topicssample.R
import com.abumadi.topicssample.api.responses.TopicsResponse
import com.abumadi.topicssample.states.TopicModel
import com.bumptech.glide.Glide
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.topics_item.view.*

class TopicsItem(private val topics: TopicsResponse.Topic) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.apply {
            //coil instead of glide >>good with coroutines
            Glide
                .with(context)
                .load(topics.ImageLink)
                .centerCrop()
                .into(viewHolder.itemView.topic_imageview)

            viewHolder.itemView.topic_name_textview.text = topics.Name
        }
    }

    override fun getLayout() = R.layout.topics_item
}