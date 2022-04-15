package com.mewsic.innertube.internal.models

import com.mewsic.innertube.enums.ClientId
import com.mewsic.innertube.enums.ClientScreen
import com.mewsic.innertube.enums.FrontEnd

class ClientInfo(val name: com.mewsic.innertube.enums.Client, val version: String, val key: String, val id: ClientId? = null, val project: String? = null, val client: FrontEnd? = null, val screen: ClientScreen? = null)
