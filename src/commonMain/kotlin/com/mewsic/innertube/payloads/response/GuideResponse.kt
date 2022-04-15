package com.mewsic.innertube.payloads.response

import kotlinx.serialization.Serializable

@Serializable
data class GuideResponse(
    val items: List<Item>,
    val responseContext: ResponseContext,
    val trackingParams: String
)

@Serializable
data class Item(
    val pivotBarRenderer: PivotBarRenderer
)

@Serializable
data class PivotBarRenderer(
    val items: List<ItemX>,
    val trackingParams: String
)

@Serializable
data class ItemX(
    val pivotBarItemRenderer: PivotBarItemRenderer
)

@Serializable
data class PivotBarItemRenderer(
    val accessibility: Accessibility,
    val icon: Icon,
    val navigationEndpoint: NavigationEndpoint,
    val pivotIdentifier: String,
    val targetId: String,
    val title: Title,
    val trackingParams: String
)

@Serializable
data class Accessibility(
    val accessibilityData: AccessibilityData
)

@Serializable
data class Icon(
    val iconType: String
)

@Serializable
data class NavigationEndpoint(
    val browseEndpoint: BrowseEndpoint,
    val clickTrackingParams: String
)

@Serializable
data class Title(
    val runs: List<Run>
)

@Serializable
data class AccessibilityData(
    val label: String
)

@Serializable
data class BrowseEndpoint(
    val browseId: String
)

@Serializable
data class Run(
    val text: String
)
