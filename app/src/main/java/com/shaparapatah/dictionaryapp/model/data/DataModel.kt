package com.shaparapatah.dictionaryapp.model.data

import com.google.gson.annotations.SerializedName

class DataModel (
    @field:SerializedName("text") val text:String?,
    @field:SerializedName("meanigs") val meanings: List<Meanings>?
)