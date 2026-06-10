package health.flo.network.ohttp.client.interceptor

import okhttp3.HttpUrl

internal fun HttpUrl.toHostHeader(): String {
    val hostHeader = if (host.contains(":")) "[$host]" else host

    return if (port == defaultPort(scheme)) hostHeader else "$hostHeader:$port"
}

private fun defaultPort(scheme: String): Int =
    when (scheme) {
        "http" -> 80
        "https" -> 443
        else -> -1
    }
