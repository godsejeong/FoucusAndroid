package com.jjmin.focus.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.jjmin.focus.R
import com.jjmin.focus.model.ItemType
import com.jjmin.focus.model.ModelImpl
import java.util.function.Function


class ListAdapter(private val viewType : ItemType,val context: Context?) : ListAdapter<ModelImpl,BaseViewHolder<ModelImpl>>(itemCallback){

    lateinit var selectionFun : Function<Long,Boolean>

    init {
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ModelImpl> {
        return when (this.viewType) {
            ItemType.MR -> MainRecommentViewHolder(context!!, parent, R.layout.item_main_recomment)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ModelImpl>, position: Int) {
        return when (this.viewType) {
            ItemType.MR -> holder.onBind(getItem(position))
        }
    }

    override fun submitList(list: List<ModelImpl?>?) {
        super.submitList(list?.let { ArrayList(it) })
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    companion object {
        val itemCallback = object : DiffUtil.ItemCallback<ModelImpl>() {
            override fun areItemsTheSame(
                oldItemData: ModelImpl,
                newItemData: ModelImpl
            ): Boolean {
                return oldItemData.getType() == newItemData.getType()
            }

            override fun areContentsTheSame(
                oldItemData: ModelImpl,
                newItemData: ModelImpl
            ): Boolean {
                return oldItemData.equals(newItemData)
            }
        }
    }
}


