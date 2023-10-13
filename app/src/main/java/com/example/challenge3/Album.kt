package com.example.challenge3

import android.os.Parcel
import android.os.Parcelable
data class Album (
    val image: Int,
    val name: String,
    ): Parcelable {
        constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString()!!
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeInt(image)
            parcel.writeString(name)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Album> {
            override fun createFromParcel(parcel: Parcel): Album {
                return Album(parcel)
            }

            override fun newArray(size: Int): Array<Album?> {
                return arrayOfNulls(size)
            }
        }


    }