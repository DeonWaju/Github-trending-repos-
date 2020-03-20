package com.softcom.model.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.softcom.model.Items

class Converters {

    @TypeConverter
    fun fromItemList(value: List<Items>?) = Gson().toJson(value)

//    @TypeConverter
//    fun toItemList(items: Items) = Gson().fromJson<List<Items>>(items,
//        object : TypeToken<List<Items>>() {}.type)

}