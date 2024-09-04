package com.gsl.shoecollection.model

data class ItemsModel(
    var title: String = "",
    var discription: String = "",
    val picUrl: ArrayList<String> = ArrayList(),
    var size: ArrayList<String> = ArrayList(),
    var price: Double = 0.0,
    var rating: Double = 0.0,
    var numberInCart: Int = 0
)
