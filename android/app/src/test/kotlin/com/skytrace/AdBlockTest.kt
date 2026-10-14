package com.skytrace

import com.skytrace.adblock.AdBlock
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class AdBlockTest {
    @Before
    fun setup() {
        AdBlock.enabled = true
    }

    @Test
    fun blocksKnownAdHosts() {
        assertTrue(AdBlock.shouldBlock("doubleclick.net"))
        assertTrue(AdBlock.shouldBlock("pagead2.googlesyndication.com"))
        assertTrue(AdBlock.shouldBlock("ads.facebook.com"))
        assertTrue(AdBlock.shouldBlock("www.google-analytics.com"))
    }

    @Test
    fun allowsNormalHosts() {
        assertFalse(AdBlock.shouldBlock("api.example.com"))
        assertFalse(AdBlock.shouldBlock("github.com"))
        assertFalse(AdBlock.shouldBlock("google.com"))
    }

    @Test
    fun respectsDisabledFlag() {
        AdBlock.enabled = false
        assertFalse(AdBlock.shouldBlock("doubleclick.net"))
    }
}
