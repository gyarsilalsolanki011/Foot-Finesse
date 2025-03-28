package com.gsl.shoecollection.model

import android.os.Parcel
import android.os.Parcelable

data class ItemsModel(
    var title: String = "",
    var discription: String = "",
    val picUrl: ArrayList<String> = ArrayList(),
    var size: ArrayList<String> = ArrayList(),
    var price: Double = 0.0,
    var rating: Double = 0.0,
    var numberInCart: Int = 0
) :Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.createStringArray() as ArrayList<String>,
        parcel.createStringArray() as ArrayList<String>,
        parcel.readDouble(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(title)
        dest.writeString(discription)
        dest.writeStringList(picUrl)
        dest.writeStringList(size)
        dest.writeDouble(price)
        dest.writeDouble(rating)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemsModel> {
        override fun createFromParcel(parcel: Parcel): ItemsModel {
            return ItemsModel(parcel)
        }

        override fun newArray(size: Int): Array<ItemsModel?> {
            return arrayOfNulls(size)
        }
    }

}
