package com.mewsic.innertube

import kotlinx.serialization.json.*

class JsonParser {
    @PublishedApi
    internal val deserializer = Json {
        ignoreUnknownKeys = true
    }
    val element: JsonElement

    constructor(json: String) {
        element = deserializer.parseToJsonElement(json)
    }

    constructor(json: JsonElement) {
        element = json
    }

    operator fun get(index: Int) : JsonParser {
        return JsonParser(element.jsonArray[index])
    }

    operator fun get(key: String) : JsonParser {
        return JsonParser(element.jsonObject[key]!!)
    }

    fun has(key: String) : Boolean {
        return element.jsonObject.containsKey(key)
    }

    inline fun <reified T> interpret() : T {
        return deserializer.decodeFromJsonElement(element)
    }

    inline fun <reified T> get(key: String) : T {
        return deserializer.decodeFromJsonElement(element.jsonObject[key]!!)
    }
    inline fun <reified T> getValue(key: String) : T {
        return deserializer.decodeFromJsonElement(element.jsonObject[key]!!)
    }

    fun toList() : List<JsonParser> {
        return element.jsonArray.map { JsonParser(it) }
    }

    override fun toString(): String {
        return element.toString()
    }
}
