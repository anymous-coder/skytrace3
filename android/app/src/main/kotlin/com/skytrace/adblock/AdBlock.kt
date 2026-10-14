package com.skytrace.adblock

object AdBlock {
    @Volatile
    var enabled: Boolean = false

    private val exact = setOf(
        "doubleclick.net", "googleadservices.com", "googlesyndication.com",
        "pagead2.googlesyndication.com", "adservice.google.com", "adservice.google.co.id",
        "securepubads.g.doubleclick.net", "pagead2.googleadservices.com", "ad.doubleclick.net",
        "static.doubleclick.net", "stats.g.doubleclick.net", "google-analytics.com",
        "www.google-analytics.com", "ssl.google-analytics.com", "region1.google-analytics.com",
        "analytics.google.com", "www.googletagmanager.com", "googletagmanager.com",
        "googletagservices.com", "partner.googleadservices.com", "ads.youtube.com",
        "ads.yahoo.com", "ads.twitter.com", "ads-api.twitter.com", "ads.facebook.com",
        "an.facebook.com", "pixel.facebook.com", "connect.facebook.net", "ad.facebook.com",
        "advertising.twitter.com", "ads.linkedin.com", "px.ads.linkedin.com", "ads.pinterest.com",
        "ct.pinterest.com", "log.pinterest.com", "ads.reddit.com", "alb.reddit.com",
        "events.reddit.com", "ads.tiktok.com", "analytics.tiktok.com", "business-api.tiktok.com",
        "ads.snapchat.com", "tr.snapchat.com", "sc-static.net", "adcolony.com",
        "ads30.adcolony.com", "adc3-launch.adcolony.com", "app-measurement.com",
        "firebaselogging.googleapis.com", "applovin.com", "ms.applovin.com", "d.applovin.com",
        "rt.applovin.com", "unityads.unity3d.com", "config.unityads.unity3d.com", "ads.unity3d.com",
        "adserver.unityads.unity3d.com", "vungle.com", "api.vungle.com", "ads.mopub.com",
        "mparticle.com", "adjust.com", "app.adjust.com", "s2s.adjust.com", "appsflyer.com",
        "launches.appsflyer.com", "conversions.appsflyer.com", "attr.appsflyer.com", "branch.io",
        "api2.branch.io", "cdn.branch.io", "amplitude.com", "api.amplitude.com", "api2.amplitude.com",
        "cdn.amplitude.com", "mixpanel.com", "api.mixpanel.com", "decide.mixpanel.com",
        "segment.io", "api.segment.io", "cdn.segment.com", "hotjar.com", "static.hotjar.com",
        "script.hotjar.com", "clarity.ms", "www.clarity.ms", "bat.bing.com", "c.bing.com",
        "ads.bing.com", "scorecardresearch.com", "sb.scorecardresearch.com", "quantserve.com",
        "secure.quantserve.com", "outbrain.com", "widgets.outbrain.com", "taboola.com",
        "cdn.taboola.com", "trc.taboola.com", "criteo.com", "static.criteo.net", "bidder.criteo.com",
        "pubmatic.com", "ads.pubmatic.com", "openx.net", "rtb.openx.net", "rubiconproject.com",
        "ads.rubiconproject.com", "casalemedia.com", "adsafeprotected.com", "pixel.adsafeprotected.com",
        "moatads.com", "z.moatads.com", "adnxs.com", "ib.adnxs.com", "cdn.adnxs.com", "adsrvr.org",
        "insight.adsrvr.org", "media.net", "adform.net", "track.adform.net", "exelator.com",
        "bluekai.com", "tags.bluekai.com", "krxd.net", "cdn.krxd.net", "rlcdn.com", "idsync.rlcdn.com",
        "mathtag.com", "pixel.mathtag.com", "demdex.net", "dpm.demdex.net", "omtrdc.net", "2o7.net",
        "everesttech.net", "adsymptotic.com", "ads-twitter.com", "static.ads-twitter.com",
        "analytics.twitter.com", "sentry.io", "browser.sentry-cdn.com", "bugsnag.com",
        "sessions.bugsnag.com", "newrelic.com", "js-agent.newrelic.com", "bam.nr-data.net",
        "nr-data.net", "tpc.googlesyndication.com", "fundingchoicesmessages.google.com",
        "pagead.l.google.com", "ad.mail.ru", "ad.yandex.ru", "mc.yandex.ru", "an.yandex.ru",
        "ads.vk.com", "ad.vk.com", "top-fwz1.mail.ru", "adfox.ru", "ads.adfox.ru"
    )

    private val suffixes = listOf(
        ".doubleclick.net", ".googlesyndication.com", ".googleadservices.com",
        ".google-analytics.com", ".googletagmanager.com", ".googletagservices.com",
        ".facebook.net", ".scorecardresearch.com", ".outbrain.com", ".taboola.com",
        ".criteo.com", ".adnxs.com", ".adsrvr.org", ".moatads.com", ".adsafeprotected.com",
        ".applovin.com", ".unity3d.com", ".appsflyer.com", ".adjust.com", ".branch.io",
        ".amplitude.com", ".mixpanel.com", ".segment.io", ".segment.com", ".hotjar.com",
        ".clarity.ms", ".pubmatic.com", ".openx.net", ".rubiconproject.com", ".casalemedia.com",
        ".demdex.net", ".omtrdc.net", ".2o7.net", ".everesttech.net", ".ads-twitter.com",
        ".sentry.io", ".nr-data.net", ".newrelic.com", ".bugsnag.com", ".adcolony.com",
        ".vungle.com", ".mopub.com", ".mparticle.com", ".yandex.ru", ".adfox.ru"
    )

    fun shouldBlock(host: String): Boolean {
        if (!enabled) return false
        val h = host.trim().lowercase().trimEnd('.')
        if (h.isEmpty()) return false
        if (h in exact) return true
        for (s in suffixes) {
            if (h.endsWith(s) || h == s.removePrefix(".")) return true
        }
        return false
    }
}
