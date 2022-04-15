package com.mewsic.innertube.payloads.response

import kotlinx.serialization.Serializable

@Serializable
data class ConfigResponse(
    val responseContext: ResponseContext,
    val configData: String? = null,
    val globalConfig: GlobalConfig? = null,
    val globalConfigGroup: GlobalConfigGroup? = null,
    val rawHotConfigGroup: RawHotConfigGroup? = null,
)

@Serializable
class GlobalConfig

@Serializable
data class GlobalConfigGroup(
    val serializedColdConfigGroup: String,
    val serializedHotConfigGroup: String,
    val hotHashData: String,
    val coldHashData: String,
)

@Serializable
data class RawHotConfigGroup(
    val loggingHotConfig: LoggingHotConfig,
)

@Serializable
data class LoggingHotConfig(
    val eventLoggingConfig: EventLoggingConfig,
)

@Serializable
data class EventLoggingConfig(
    val enabled: Boolean,
    val maxAgeHours: Int,
)
