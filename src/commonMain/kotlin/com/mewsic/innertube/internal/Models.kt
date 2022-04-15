package com.mewsic.innertube.internal

import com.mewsic.innertube.enums.*
import com.mewsic.innertube.enums.Client
import com.mewsic.innertube.internal.models.*

object Models {
    val apis = mapOf(
        Host.YOUTUBEI to Api(
            domain = Host.YOUTUBEI,
            mount = "/youtubei/v1/",
        ),
        Host.SUGGEST_QUERIES to Api(
            domain = Host.SUGGEST_QUERIES,
        )
    )

    val devices = mapOf(
        Device.WEB to DeviceInfo(
            Device.WEB,
            DeviceFamily.WEB,
            listOf(
                "Windows NT 10.0",
                "Win64",
                "x64",
                "rv:77.0",
            )
        ),
        Device.ANDROID to DeviceInfo(
            Device.ANDROID,
            DeviceFamily.MOBILE,
            listOf(
                "Linux",
                "U",
                "Android 9",
                "en_GB",
                "VirtualBox Build/PI",
            )
        ),
        Device.IOS to DeviceInfo(
            Device.IOS,
            DeviceFamily.MOBILE,
            listOf(
                "iPhone10,5",
                "U",
                "CPU iOS 14_4 like Mac OS X",
                "en_GB",
            )
        ),
        Device.LR to DeviceInfo(
            Device.LR,
            DeviceFamily.WEB,
            listOf(
                "PlayStation",
                "PlayStation 4/8.03",
            )
        ),
    )

    val services = mapOf(
        Service.YOUTUBE to ServiceInfo(
            Host.YOUTUBE
        ),
        Service.YOUTUBE_MUSIC to ServiceInfo(
            Host.YOUTUBE_MUSIC
        ),
        Service.YOUTUBE_KIDS to ServiceInfo(
            Host.YOUTUBE_KIDS
        ),
        Service.YOUTUBE_STUDIO to ServiceInfo(
            Host.YOUTUBE_STUDIO
        ),
    )

    val clientInfos = mapOf(
        Client.MWEB to ClientInfo(
            name = Client.MWEB,
            version = "5.20180323.00.00",
            key = "AIzaSyAO_FJ2SlqU8Q4STEHLGCilw_Y9_11qcW8",
            id = ClientId.MWEB,
            client = FrontEnd.YOUTUBE_REDUCED,
        ),
        Client.WEB to ClientInfo(
            name = Client.WEB,
            version = "2.20210223.09.00",
            key = "AIzaSyAO_FJ2SlqU8Q4STEHLGCilw_Y9_11qcW8",
            id = ClientId.WEB,
            client = FrontEnd.YOUTUBE,
        ),
        Client.WEB_REMIX to ClientInfo(
            name = Client.WEB_REMIX,
            version = "0.1",
            key = "AIzaSyC9XL3ZjWddXya6X74dJoCTL-WEYFDNX30",
            id = ClientId.WEB_REMIX,
        ),
        Client.WEB_KIDS to ClientInfo(
            name = Client.WEB_KIDS,
            version = "2.1.4",
            key = "AIzaSyBbZV_fZ3an51sF-mvs5w37OqqbsTOzwtU",
            id = ClientId.WEB_KIDS,
            client = FrontEnd.YOUTUBE_PEGASUS_WEB,
        ),
        Client.WEB_CREATOR to ClientInfo(
            name = Client.WEB_CREATOR,
            version = "1.20210223.01.00",
            key = "AIzaSyBUPetSUmoZL-OhlxA7wSac5XinrygCqMo",
            id = ClientId.WEB_CREATOR,
        ),
        Client.ANDROID to ClientInfo(
            name = Client.ANDROID,
            version = "16.07.34",
            key = "AIzaSyA8eiZmM1FaDVjRy-df2KTyQ_vz_yYM39w",
            id = ClientId.ANDROID,
            project = "youtube",
        ),
        Client.ANDROID_MUSIC to ClientInfo(
            name = Client.ANDROID_MUSIC,
            version = "4.16.51",
            key = "AIzaSyAOghZGza2MQSZkY_zfZ370N-PUdXEo8AI",
            id = ClientId.ANDROID_MUSIC,
            project = "apps.youtube.music",
            client = FrontEnd.YOUTUBE_MUSIC_ANDROID,
        ),
        Client.ANDROID_KIDS to ClientInfo(
            name = Client.ANDROID_KIDS,
            version = "6.02.3",
            key = "AIzaSyAxxQKWYcEX8jHlflLt2Qcbb-rlolzBhhk",
            project = "apps.youtube.kids",
        ),
        Client.ANDROID_CREATOR to ClientInfo(
            name = Client.ANDROID_CREATOR,
            version = "21.06.103",
            key = "AIzaSyD_qjV8zaaUMehtLkrKFgVeSX_Iqbtyws8",
            id = ClientId.ANDROID_CREATOR,
            project = "apps.youtube.creator",
        ),
        Client.IOS to ClientInfo(
            name = Client.IOS,
            version = "16.05.7",
            key = "AIzaSyB-63vPrdThhKuerbB2N_l7Kwwcxj6yUAc",
            id = ClientId.IOS,
            project = "youtube",
        ),
        Client.IOS_MUSIC to ClientInfo(
            name = Client.IOS_MUSIC,
            version = "4.16.1",
            key = "AIzaSyBAETezhkwP0ZWA02RsqT1zu78Fpt0bC_s",
            id = ClientId.IOS_MUSIC,
            project = "youtubemusic",
            client = FrontEnd.YOUTUBE_MUSIC_IOS,
        ),
        Client.IOS_KIDS to ClientInfo(
            name = Client.IOS_KIDS,
            version = "5.42.2",
            key = "AIzaSyA6_JWXwHaVBQnoutCv1-GvV97-rJ949Bc",
            project = "youtubekids",
        ),
        Client.IOS_CREATOR to ClientInfo(
            name = Client.IOS_CREATOR,
            version = "20.47.100",
            key = "AIzaSyAPyF5GfQI-kOa6nZwO8EsNrGdEx9bioNs",
            id = ClientId.IOS_CREATOR,
            project = "ytcreator",
        ),
        Client.TVHTML5 to ClientInfo(
            name = Client.TVHTML5,
            version = "7.20210224.00.00",
            key = "AIzaSyDCU8hByM-4DrUqRUYnGn-3llEO78bcxq8",
            client = FrontEnd.YOUTUBE_LR,
        ),
        Client.WEB_EMBEDDED_PLAYER to ClientInfo(
            name = Client.WEB_EMBEDDED_PLAYER,
            version = "1.20210620.0.1",
            key = "AIzaSyAO_FJ2SlqU8Q4STEHLGCilw_Y9_11qcW8",
            id = ClientId.WEB_EMBEDDED_PLAYER,
            screen = ClientScreen.EMBED,
        ),
        Client.ANDROID_EMBEDDED_PLAYER to ClientInfo(
            name = Client.ANDROID_EMBEDDED_PLAYER,
            version = "16.20",
            key = "AIzaSyAO_FJ2SlqU8Q4STEHLGCilw_Y9_11qcW8",
            id = ClientId.ANDROID_EMBEDDED_PLAYER,
            screen = ClientScreen.EMBED,
        ),
        Client.IOS_MESSAGES_EXTENSION to ClientInfo(
            name = Client.IOS_MESSAGES_EXTENSION,
            version = "16.20",
            key = "AIzaSyDCU8hByM-4DrUqRUYnGn-3llEO78bcxq8",
            id = ClientId.IOS_MESSAGES_EXTENSION,
            screen = ClientScreen.EMBED,
        ),
    )

    val schemas = listOf(
        ClientSchema(
            Client.WEB,
            Device.WEB,
            Service.YOUTUBE,
        ),
        ClientSchema(
            client = Client.WEB_REMIX,
            device = Device.WEB,
            service = Service.YOUTUBE_MUSIC,
        ),
        ClientSchema(
            client = Client.WEB_KIDS,
            device = Device.WEB,
            service = Service.YOUTUBE_KIDS,
        ),
        ClientSchema(
            client = Client.WEB_CREATOR,
            device = Device.WEB,
            service = Service.YOUTUBE_STUDIO,
        ),
        ClientSchema(
            client = Client.ANDROID,
            device = Device.ANDROID,
            service = Service.YOUTUBE,
        ),
        ClientSchema(
            client = Client.ANDROID_MUSIC,
            device = Device.ANDROID,
            service = Service.YOUTUBE_MUSIC,
        ),
        ClientSchema(
            client = Client.ANDROID_KIDS,
            device = Device.ANDROID,
            service = Service.YOUTUBE_KIDS,
        ),
        ClientSchema(
            client = Client.ANDROID_CREATOR,
            device = Device.ANDROID,
            service = Service.YOUTUBE_STUDIO,
        ),
        ClientSchema(
            client = Client.IOS,
            device = Device.IOS,
            service = Service.YOUTUBE,
        ),
        ClientSchema(
            client = Client.IOS_MUSIC,
            device = Device.IOS,
            service = Service.YOUTUBE_MUSIC,
        ),
        ClientSchema(
            client = Client.IOS_KIDS,
            device = Device.IOS,
            service = Service.YOUTUBE_KIDS,
        ),
        ClientSchema(
            client = Client.IOS_CREATOR,
            device = Device.IOS,
            service = Service.YOUTUBE_STUDIO,
        ),
        ClientSchema(
            client = Client.TVHTML5,
            device = Device.LR,
            service = Service.YOUTUBE,
        ),
        ClientSchema(
            client = Client.MWEB,
            device = Device.WEB,
            service = Service.YOUTUBE,
        ),
        ClientSchema(
            client = Client.WEB_EMBEDDED_PLAYER,
            device = Device.WEB,
            service = Service.YOUTUBE,
        ),
        ClientSchema(
            client = Client.ANDROID_EMBEDDED_PLAYER,
            device = Device.WEB,
            service = Service.YOUTUBE,
        ),
        ClientSchema(
            client = Client.IOS_MESSAGES_EXTENSION,
            device = Device.WEB,
            service = Service.YOUTUBE,
        ),
    )

    val clients = schemas.associate {
        it.client to com.mewsic.innertube.internal.models.Client(
            clientInfos[it.client]!!,
            devices[it.device]!!,
            services[it.service]!!,
        )
    }
}
