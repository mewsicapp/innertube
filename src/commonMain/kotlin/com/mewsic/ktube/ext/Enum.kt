package com.mewsic.ktube.ext

import java.util.*

private fun String.capitalizeFirstLetter(): String {
    return lowercase().replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

fun Enum<*>.toTitleCase(): String {
    return name.split("_").joinToString(" ", transform = String::capitalizeFirstLetter)
}

fun Enum<*>.toPascalCase(): String {
    return name.split("_").joinToString(" ", transform = String::capitalizeFirstLetter)
}

fun Enum<*>.toSnakeCase(): String {
    return name.split("_").joinToString("_", transform = String::lowercase)
}

fun Enum<*>.toKebabCase(): String {
    return name.split("_").joinToString("-", transform = String::lowercase)
}

fun Enum<*>.toUpperCase(): String {
    return name.split("_").joinToString(" ", transform = String::uppercase)
}

fun Enum<*>.toLowerCase(): String {
    return name.split("_").joinToString(" ", transform = String::lowercase)
}

fun Enum<*>.toTrainCase(): String {
    return name.split("_").joinToString("-", transform = String::capitalizeFirstLetter)
}
