package ext.logcat

import android.util.Log

/**
 * Help printing logs splitting text on new line and creating multiple logs for too long texts
 */
object LogHelper {
    private const val MAX_LOG_LENGTH = 4000
    private const val defaultTagName = "response"
    public fun logD(string: String, tag: String? = defaultTagName) {
        string.chunked(MAX_LOG_LENGTH).forEach { Log.d(tag, it) }
    }

    fun logE(string: String, tag: String? = defaultTagName) {
        string.chunked(MAX_LOG_LENGTH).forEach { Log.e(tag, it) }
    }

    fun logI(string: String, tag: String? = defaultTagName) {
        string.chunked(MAX_LOG_LENGTH).forEach { Log.i(tag, it) }
    }

    fun logW(string: String, tag: String? = defaultTagName) {
        string.chunked(MAX_LOG_LENGTH).forEach { Log.w(tag, it) }
    }

    fun logWTF(string: String, tag: String? = defaultTagName) {
        string.chunked(MAX_LOG_LENGTH).forEach { Log.wtf(tag, it) }
    }

    fun logV(string: String, tag: String? = defaultTagName) {
        string.chunked(MAX_LOG_LENGTH).forEach { Log.v(tag, it) }
    }
}