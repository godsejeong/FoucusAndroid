package com.jjmin.focus.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.google.gson.Gson
import com.jjmin.focus.R
import com.jjmin.focus.model.ItemType
import com.jjmin.focus.model.ModelImpl


class ListAdapter() : ListAdapter<ModelImpl,BaseViewHolder<ModelImpl>>(itemCallback){
    private lateinit var viewType : ItemType

    init {
        setHasStableIds(true)
    }

    fun setType(viewType : ItemType){
        this.viewType = viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ModelImpl> {
        return when (this.viewType) {
            ItemType.MR -> MainRecommentViewHolder(parent.context, parent, R.layout.item_main_recomment)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<ModelImpl>, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun submitList(list: List<ModelImpl?>?) {
        super.submitList(list?.let { ArrayList(it) })
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


