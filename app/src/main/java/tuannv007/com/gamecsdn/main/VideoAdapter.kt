package tuannv007.com.gamecsdn.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_activity.view.*
import tuannv007.com.gamecsdn.R
import tuannv007.com.gamecsdn.base.BaseAdapter
import tuannv007.com.gamecsdn.model.Item

/**
 * Created by Adminis on 1/3/2018.
 */
class VideoAdapter(t : ArrayList<Item>) : BaseAdapter<Item>(t) {
    override fun getCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_activity, parent, false))
    }

    override fun getBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MyViewHolder) {
            holder.bindData(itemList[position])
            holder.itemView.setOnClickListener {v ->
                clickListener!!.onItemClick(position)
            }
        }
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindData(item : Item){
            Glide.with(itemView.context).load(item.image).into(itemView.imageStory)
            itemView.title.text = item.title
        }
    }
}