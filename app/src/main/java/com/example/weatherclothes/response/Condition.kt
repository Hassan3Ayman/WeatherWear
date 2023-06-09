package com.example.weatherclothes.response

import com.google.gson.annotations.SerializedName

data class Condition(
    @SerializedName("text")
    val condition: String,
    @SerializedName("icon")
    val conditionIcon : String
)
