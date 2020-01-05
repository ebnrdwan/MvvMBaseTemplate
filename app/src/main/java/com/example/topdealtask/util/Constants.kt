package com.example.topdealtask.util

class Constants {
    object Networking {

        const val RETROFIT_TIMEOUT_SECONDS: Long = 60
        const val API_REQUEST_TAG = "API_REQUEST:->"
        const val API_RESPONSE_TAG = "API_RESPONSE:->"
        const val APP_VERSION_TAG = "APP_FLAVOR:->"
        const val Accept_Language = "Accept-Language"
        const val Content_Type = "Content-Type"
        const val Json = "application/json"
    }

    object Logging {
        const val RX_TAG_ERROR = "RX_ERROR"
        const val RX_TAG_SUCCESS = "RX_SUCCESS"
        const val RX_TAG_NEXT = "RX_NEXT"
        const val RX_TAG_COMPLETE = "RX_COMPLETE"
        const val RX_TAG_SUPSCRIBE = "RX_COMPLETE"
    }

    object RxEditTextConstants {
        const val SKIP = 1.toLong()
        const val DEBOUNCE = 300.toLong()

    }

    object Animations {
        const val Duration: Long = 500
        const val Short_Duration: Long = 200
        const val Delay: Long = 500
        const val XLeftStart: Float = -500f
        const val XRightStart: Float = 500f
        const val YTopStart: Float = -1000f
        const val YBottomStart: Float = 100000f
        const val EndPosition: Float = 0f
        const val fadedOut: Float = 0f
        const val fadedIn: Float = 1f
        const val reverse: Boolean = false
        const val repeatCount: Int = 0
        const val lottieStart: Float = 0.5f
    }

    object Language {
        const val ENGLISH = "en"
        var CURRENT = "en"
        const val ARABIC = "ar"
    }

}
