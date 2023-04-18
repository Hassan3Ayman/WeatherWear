package com.example.weatherclothes.model

import com.example.weatherclothes.R

class Clothes {
    private val tShirts = listOf(
        R.drawable.tshirt2,
        R.drawable.tshirt3,
        R.drawable.tshirt5,
        R.drawable.tshirt6,
        R.drawable.shirt
    )

    private val shirts = listOf(
        R.drawable.shirt
    )

    private val sweatShirts = listOf(
        R.drawable.sweatshirt1,
        R.drawable.sweatshirt2,
        R.drawable.sweatshirt3,
        R.drawable.sweatshirt9
    )

    private val jackets = listOf(
        R.drawable.jacket1
    )

    fun getCloth(temp: Int): Int{
        return when(temp){
            in 25..50 -> tShirts.random()
            in 10..24 -> sweatShirts.random()
            in -20..9 -> jackets[0]
            else -> sweatShirts.random()
        }
    }
}