package com.mewsic.ktube.internal.models

import com.mewsic.ktube.enums.Domain
import com.mewsic.ktube.enums.Header
import com.mewsic.ktube.enums.YouTubeHeader
import io.ktor.http.*

data class Client(
    val client: ClientInfo,
    val device: DeviceInfo,
    val service: ServiceInfo,
) {
    private val `package`: String?
        get() {
            if (client.project.isNullOrEmpty()) {
                return null
            }

            return listOf(
                Domain.GOOGLE.reverse(),
                device.identifier,
                client.project
            ).joinToString(".")
        }

    private val product: String
        get() {
            if (`package` == null) {
                return device.product!!
            }

            return "${`package`}/${client.version}" + if (device.comments.isEmpty()) "" else " (${device.comments.joinToString("; ")})"
        }

    fun headers(builder: HeadersBuilder, locale: Locale?) {
        fun header(key: Enum<*>, value: Any) = builder.append(key.toString(), value.toString())

        client.id?.let { header(YouTubeHeader.CLIENT_NAME, it) }
        header(YouTubeHeader.CLIENT_VERSION, client.version)
        header(Header.USER_AGENT, product)
        header(Header.REFERER, service.domain)
        locale?.let { header(Header.ACCEPT_LANGUAGE, locale.acceptLanguage) }
        builder.append("Content-Type", "application/json")
    }
}
