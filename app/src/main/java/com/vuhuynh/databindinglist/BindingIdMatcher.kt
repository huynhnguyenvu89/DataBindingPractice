package com.vuhuynh.databindinglist

import java.lang.IllegalArgumentException
import java.lang.reflect.Field

object BindingIdMatcher {

    private val brFields: HashMap<String, Int> by lazy {
        val fieldsMap = HashMap<String, Int>()
        for (field: Field in BR::class.java.declaredFields) {
            try {
                fieldsMap[field.name] = field.getInt(null)
            } catch (ignore: Exception) { }
        }
        fieldsMap
    }

    @JvmStatic
    fun id(name: String) : Int? {
        if (!brFields.containsKey(name))
            throw IllegalArgumentException("Field not found in BR.java $name")
        return brFields[name]
    }
}