package com.mewsic.ktube.internal.models

import com.mewsic.ktube.enums.BrowseId

class ResponseContext(
    var function: String?,
    var browseId: BrowseId?,
    var context: String?,
    var visitorData: String?,
    var client: Client?,
    var request: Request?,
    var flags: Flags?,
) {
    data class Request(val type: String? = null, val id: String? = null)
    data class Client(val name: String? = null, val version: String? = null)
    data class Flags(val loggedIn: Boolean? = null)
}
