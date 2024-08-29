package org.json.junit.example2

import org.json.junit.example2.assertions.Job
import org.json.junit.example2.assertions.SUT
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertTimeout
import org.junit.jupiter.api.assertTimeoutPreemptively
import java.time.Duration
import java.time.Duration.ofMillis
import kotlin.test.Test


class AssertTimeoutTest {
    private val systemUnderTest = SUT(
        systemName = "테스트 대상 시스템"
    )

    @Test
    @DisplayName("작업을 마칠 때까지 기다리는 assertTimeout 메서드")
    fun testTimeout()  {
        // 시스템에 작업을 추가
        systemUnderTest.addJob(Job("작업 1"))
        systemUnderTest.addJob(Job("작업 2"))
        systemUnderTest.addJob(Job("작업 3"))

        // 시스템에 작업이 추가되었는지 확인
        assertTimeout(Duration.ofMillis(500), {
            systemUnderTest.run { 200 }
        })

    }

    @Test
    @DisplayName("시간이 지나면 작업을 중지시키는 assertTimeoutPreemptively 메서드")
    @Throws(InterruptedException::class)
    fun testTimeoutPreemptively() {
        systemUnderTest.addJob(Job("Job 1"))
        assertTimeoutPreemptively(ofMillis(500)) { systemUnderTest.run {
            200
        } }
    }
}