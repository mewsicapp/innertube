package com.mewsic.ktube.internal.models

import com.mewsic.ktube.enums.ClientId
import com.mewsic.ktube.enums.ClientScreen
import com.mewsic.ktube.enums.FrontEnd

class ClientInfo(val name: com.mewsic.ktube.enums.Client, val version: String, val key: String, val id: ClientId? = null, val project: String? = null, val client: FrontEnd? = null, val screen: ClientScreen? = null)
