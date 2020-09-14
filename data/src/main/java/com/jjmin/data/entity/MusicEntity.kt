package com.jjmin.data.entity

import com.google.gson.annotations.SerializedName

open class MusicEntity {
    @SerializedName("name")
    lateinit var name : String
    @SerializedName("artist")
    lateinit var artist : String
    @SerializedName("category")
    lateinit var category : String
    @SerializedName("hash")
    lateinit var hash : String
    @SerializedName("music")
    lateinit var music : String
    @SerializedName("sub")
    lateinit var sub : List<String>
    @SerializedName("tag")
    lateinit var tag : List<String>
    @SerializedName("thumbnail")
    lateinit var thumbnail : String
}