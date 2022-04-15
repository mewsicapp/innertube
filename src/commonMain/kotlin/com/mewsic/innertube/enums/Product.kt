package com.mewsic.innertube.enums

enum class Product(private val _name: String, val version: String) {
    MOZILLA("Mozilla", "5.0");

    override fun toString(): String {
        return _name
    }
}
