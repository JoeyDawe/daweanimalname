package com.dawe.animal.midterm

import android.os.Parcel
import android.os.Parcelable

data class AnimalDetails(
    val name: String, val description: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AnimalDetails> {
        override fun createFromParcel(parcel: Parcel): AnimalDetails {
            return AnimalDetails(parcel)
        }

        override fun newArray(size: Int): Array<AnimalDetails?> {
            return arrayOfNulls(size)
        }
    }
}
