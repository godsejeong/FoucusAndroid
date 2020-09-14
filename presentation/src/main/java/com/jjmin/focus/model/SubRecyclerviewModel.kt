package com.jjmin.focus.model

data class SubRecyclerviewModel(
    var musicName : String,
    var thumbnail : String,
    var musicModel : ArrayList<SubRecommentModel>
) : ModelImpl{
    override fun getType(): ItemType {
        return ItemType.SR
    }
}