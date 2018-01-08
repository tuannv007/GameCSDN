package tuannv007.com.gamecsdn.base

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import java.util.*

/**
 * Created by Adminis on 1/3/2018.
 */
abstract class BaseAdapter<T>(var itemList: ArrayList<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return getCreateViewHolder(parent!!, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        return getBindViewHolder(holder!!, position)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun addItem(t: T, position: Int) {
        itemList.clear()
        itemList.add(t)
        notifyItemInserted(position)
    }

    fun deleteItem(t: T, position: Int) {
        if (itemList.size > 0) itemList.remove(t)
        notifyItemRemoved(position)
    }

    fun addAllItem(t: List<T>) {
        itemList.clear()
        itemList.addAll(t)
        notifyDataSetChanged()
    }

    abstract fun getCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    abstract fun getBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)
    var clickListener : OnItemClickListener? = null
    fun setOnClickListener(mClickListener : OnItemClickListener){
        clickListener = mClickListener
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}