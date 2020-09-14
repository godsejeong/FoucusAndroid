package com.jjmin.focus.model

data class SubRecommentModel(
    var musicName : String,
    val musicArtist : String,
    val thumbnail : String,
    val musicSource : String,
    val musicUrl : String
) : ModelImpl{
    override fun getType(): ItemType {
        return ItemType.SRM
    }
}